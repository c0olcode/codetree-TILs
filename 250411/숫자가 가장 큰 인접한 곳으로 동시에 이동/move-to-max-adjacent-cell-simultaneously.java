import java.util.*;
import java.io.*;

public class Main {

    static int n,m,t;
    static int map[][];
    static int count[][];
    static int next_count[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static boolean inRange(int x, int y){
        return x >= 0 && x<n && y>=0 && y<n;
    }

    public static void moved(int x, int y){
        int max_x = 0; // 어쨌든 처음 탐색에서 바로 업데이트 됨.
        int max_y = 0;
        int max = 0;

        // 4방향 탐색해서 제일 큰 수로 이동하기
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx,ny) && (map[nx][ny] > max)){// 더 큰 수라면
                max_x = nx;
                max_y = ny;
                max = map[max_x][max_y];
            }
        }
        // next_count 업데이트하기
        next_count[max_x][max_y]++;
    }

    public static void main(String[] args) throws IOException{

        // 1. 입력 받기 & 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //격자크기
        m = Integer.parseInt(st.nextToken()); //구슬갯수
        t = Integer.parseInt(st.nextToken()); // 시간

        map = new int[n][n];
        count = new int[n][n];
        next_count = new int[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1; 
            int c = Integer.parseInt(st.nextToken())-1;

            count[r][c] = 1; //구슬 위치 기록 (0:없음 / 1: 있음)
        }

        // 2. t번 반복하여 구슬 이동하기
        for (int iternum = 0; iternum < t; iternum++){

            // 2-1. count 완전탐색하여서 구슬 존재하면 상하좌우 탐색하기
            for (int i = 0; i < n; i++){
                for (int j =0; j < n; j++){
                    if (count[i][j] == 1) moved(i,j);
                }
            }
            // System.out.println("count");
            // for (int i = 0; i < n; i++){
            //     for (int j =0; j < n; j++){
            //         System.out.print(count[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("next_count");
            // for (int i = 0; i < n; i++){
            //     for (int j =0; j < n; j++){
            //         System.out.print(next_count[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            // 2-2. count 배열 업데이트
            for (int i = 0; i < n; i++){
                for (int j =0; j < n; j++){
                    if (next_count[i][j] == 1){ // 구슬 하나만 있다면
                        count[i][j] = 1;
                    }
                    else count[i][j] = 0;
                }
            }

            // 2-3. next_count 초기화
            for (int i = 0; i < n; i++){
                for (int j =0; j < n; j++){
                    next_count[i][j] = 0;
                }
            }

        }

        // 3. 구슬 갯수 세서 출력하기
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j++){
                if (count[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);

    }
}