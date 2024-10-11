import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAXNM = 200;

    public static int n;
    public static int m;
    public static int map[][];
    public static boolean visited[][];

    // 둘러쌓이지 않은 물 리스트
    public static ArrayList<Pair> notAroundWater = new ArrayList<>();
    public static Queue<Pair> q = new LinkedList<>();

    // 빙하가 있는지 확인하기
    public static boolean isAllZero(){
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void visitedInitialize(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean isOutWaterVisited(){
        for (int i = 0; i < m; i++){
            if (visited[0][i]) return true;
            if (visited[n-1][i]) return true;
        }

        for (int i = 0; i < n; i++){
            if (visited[i][0]) return true;
            if (visited[i][m-1]) return true;
        }

        return false;
    }

    // 물 (x,y)가 둘러쌓였는지 여부 확인
    public static void inBfs(int x, int y){
        // 큐 초기화하기
        q.clear();

        //방문여부 초기화하기
        visitedInitialize();

        visited[x][y] = true;
        q.add(new Pair(x,y));

        while(!q.isEmpty()){
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};

            Pair water = q.poll();
            
            for (int i = 0; i < 4; i++){
                int wx = water.x + dx[i];
                int wy = water.y + dy[i];

                if (inRange(wx,wy) && !visited[wx][wy] && map[wx][wy] == 0){
                    visited[wx][wy] = true;
                    q.add(new Pair(wx,wy));
                }
            }

        }

        // 외곽에 있는 물(0)까지 닿았는지 확인
        if (isOutWaterVisited()){
            notAroundWater.add(new Pair(x,y));
        }
    }

    // 내부에 있는 0을 하나씩 bfs 탐색해서, 둘러쌓였는지 아닌지 판단하기. -> 안둘러 쌓였으면 리스트에 넣기
    public static void around(){
        for (int i = 1; i < n-1; i++){
            for (int j = 1; j < m-1; j++){
                if (map[i][j] == 0){
                    // bfs 탐색해서 안둘러쌓였으면 리스트에 넣기.
                    inBfs(i,j);
                }
            }
        }
    }

    public static int getSize(){
        int size = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 1) size++;
            }
        }

        return size;
    }

    public static void bfs(){
        // 큐에 0 다 넣기 (둘러쌓인 물 제외, 외곽 물 포함)
        q.clear();
        visitedInitialize();
        
        // 둘러 쌓이지 않은 물 insert
        for (int i = 0; i < notAroundWater.size(); i++){
            Pair a = notAroundWater.get(i);
            visited[a.x][a.y] = true;
            q.add(a);
        }
        // 외곽에 있는 물 insert
        for (int i = 0; i < m; i++){
            visited[0][i] = true;
            q.add(new Pair(0,i));
            visited[n-1][i] = true;
            q.add(new Pair(n-1,i));
        }
        for (int i = 0; i < n; i++){
            visited[i][0] = true;
            visited[i][m-1] = true;
            q.add(new Pair(i,0));
            q.add(new Pair(i,m-1));
        }

        while(!q.isEmpty()){
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};

            Pair a = q.poll();

            for (int i = 0; i < 4; i++){
                int x = a.x + dx[i];
                int y = a.y + dy[i];

                if (inRange(x,y) && !visited[x][y] && map[x][y] == 1){
                    map[x][y] = 0;
                    visited[x][y] = true;
                }
            }
        }
        
    }

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 0;
        int time = 0;

        while(!isAllZero()){
            // 둘러쌓였는지 확인하기
            around();

            // 탐색 전에 현재 빙하 크기 구하기
            size = getSize();

            // bfs 탐색 시작하기
            bfs(); 
            time++;

            // notAroundWater 초기화하기 && visit도 초기화(사실 안해도 되긴 할듯)
            notAroundWater.clear();
            
        }

        System.out.print(time + " " + size);
        
    }
}