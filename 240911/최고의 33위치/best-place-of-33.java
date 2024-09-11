import java.util.*;
import java.io.*;

public class Main {

    static int map[][];
    
    public static int searchCoin(int i_start, int i_end, int j_start, int j_end){
        int count = 0;
        for (int i = i_start; i <= i_end; i++){
            for (int j = j_start; j <= j_end; j++){
                count += map[i][j];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        // 입력을 먼저 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max_coin = 0;

        // 격자를 돌아가면서 탐색한다. 
        for (int i = 0; i < N; i++){
            if (i + 2 >= N) break;

            int i_start = i;
            int i_end = i + 2;

            for (int j = 0; j < N; j++){
                if (j + 2 >= N) break;

                int j_start = j;
                int j_end = j + 2;

                // 시작, 종료점 가지고 탐색하면서 동전 갯수 구하기
                int coin = searchCoin(i_start, i_end, j_start, j_end);
                max_coin = Math.max(max_coin, coin);
            }
        }

        System.out.println(max_coin);
    }
}