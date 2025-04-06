import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int calcMin(){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++){
            Pair p = list.get(i);
            min = Math.min(map[p.x][p.y], min);
        }

        return min;

    }
    
    public static void dfs(int depth){
        if (depth == N){
            // 색칠된 칸에서 최솟값 구하기
            int min = calcMin();
            // 위에서 구한 최솟값의 최댓값 구하기
            max = Math.max(min, max);
            return;
        }

        // 0~N-1번째 칸 (가로 기준) 고르기
        for (int i = 0; i < N; i++){
            if (!visit[i]){
                // 방문표시 & dfs 탐색 & 리스트에 좌표값 담기
                visit[i] = true;
                list.add(new Pair(depth, i));
                dfs(depth+1);

                list.remove(list.size()-1);
                visit[i] = false;
            }
        }

    }

    public static int N;
    public static int max = -1;
    public static int map[][];
    public static boolean visit[];
    public static ArrayList<Pair> list = new ArrayList<>();
    

    public static void main(String[] args) throws IOException{

        // 1. 입력 받기 & 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. dfs 탐색
        dfs(0); // 0 ~ N-1번째 라인(세로 기준)까지 탐색

        System.out.println(max);


        
    }
}