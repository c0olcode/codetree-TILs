import java.util.*;
import java.io.*;

public class Main {

    public static int N,M,max;
    public static int map[][];

    public static void onethreeSearch(int x, int y){
        int cnt = 0;
        for (int j = y; j <= y+2; j++){
            cnt += map[x][j];
        }
        max = Math.max(cnt, max);
    }

    public static void threeoneSearch(int x, int y){
        int cnt = 0;
        for (int i = x; i <= x+2; i++){
            cnt += map[i][y];
        }
        max = Math.max(cnt, max);
    }

    public static void twotwoSearch(int x, int y){
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int i = x; i <= x+1; i++){
            for (int j = y; j <= y+1; j++){
                cnt += map[i][j];
                min = Math.min(min, map[i][j]);
            }
        }

        cnt = cnt-min;
        max = Math.max(max,cnt);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 1*3 탐색
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (j+2 >= M) break;
                onethreeSearch(i,j);
            }
        }

        // 2. 3*1 탐색
        for (int i = 0; i < N; i++){
            if (i+2 >= N) break;
            for (int j = 0; j < M; j++){
                threeoneSearch(i,j);
            }
        }

        // 3. 2*2 탐색
        for (int i = 0; i < N; i++){
            if (i+1 >= N) break;
            for (int j = 0; j < M; j++){
                if (j+1 >= M) break;

                twotwoSearch(i,j);
            }
        }

        System.out.println(max);
    }
}