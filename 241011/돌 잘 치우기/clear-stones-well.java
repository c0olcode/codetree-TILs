import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n;
    public static int m; // 뽑아낼 돌 개수
    public static int k; // 시작점 개수
    public static int max = Integer.MIN_VALUE;

    public static ArrayList<Pair> select = new ArrayList<>();
    public static ArrayList<Pair> start = new ArrayList<>();
    public static ArrayList<Pair> rock = new ArrayList<>();
    
    public static int map[][];
    public static boolean visited[][];

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void countMap(){
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 0 && visited[i][j]) count++;
            }
        }

        // 최댓값으로 업데이트 하기
        max = Math.max(max, count);
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();

        // 선택된 돌을 큐에 넣고 && 1->0으로 바꾸고 && 방문 표시하기
        for (int i = 0; i < select.size(); i++){ // select.size()==m 이어야함
            Pair obj = select.get(i);
            map[obj.x][obj.y] = 0;
            visited[obj.x][obj.y] = true;
            q.add(select.get(i));
        }

        while(!q.isEmpty()){
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};

            Pair obj = q.poll();

            for (int i = 0; i < 4; i++){
                int x = obj.x + dx[i];
                int y = obj.y + dy[i];

                if (inRange(x,y) && map[x][y] == 0 && !visited[x][y]){
                    visited[x][y] = true;
                    q.add(new Pair(x,y));
                }

            }

        }
    }

    // 0-> 1로 다시 바꿔준다. && 방문 표시 초기화
    public static void initialize(){
        for (int i = 0; i < select.size(); i++){
            Pair obj = select.get(i);
            map[obj.x][obj.y] = 1;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void dfs(int index, int cnt){
        if (cnt == m){
            // select의 돌들을 bfs 탐색하기
            bfs();
            // bfs 결과로 나온 visited[][] 토대로 칸 개수 세기 && 최댓값 업데이트
            countMap();
            // Map , 방문 표시 초기화하기
            initialize();
            return;
        }
        if (index == rock.size()){
            return;
        }

        // 해당 인덱스 안 골랐을 때
        dfs(index+1, cnt);

        // 해당 인덱스 골랐을 때
        select.add(rock.get(index));
        dfs(index+1, cnt+1);
        select.remove(select.size()-1);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        // 맵 세팅
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    rock.add(new Pair(i,j));
                }
            }
        }

        // 시작점 세팅
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            start.add(new Pair(x,y));
        }

        // 해당 함수에서 최대 칸 수 구함
        dfs(0,0);

        System.out.print(max);

    }
}