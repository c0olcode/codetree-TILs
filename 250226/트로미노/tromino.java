import java.io.*;
import java.util.*;

public class Main {

    public static int map[][];

    public static int searchTwoTwo(int start_i, int start_j){

        int min = 1001;
        int plus = 0;
        for (int i = start_i; i <= start_i + 1; i++){
            for (int j = start_j; j <= start_j + 1; j++){
                min = Math.min(min, map[i][j]);
                plus += map[i][j];
            }
        }
        //System.out.println(plus-min);

        return plus-min;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1*3 탐색
        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (j + 2 >= m) break;

                int start_j = j;
                int plus = 0;
                for (int x = start_j; x <= start_j+2; x++){
                    plus += map[i][x];
                }
                //System.out.println(plus);
                max = Math.max(max, plus);
            }
        }

        // 3*1 탐색
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j + 2 >= n) break;

                int start_j = j;
                int plus = 0;
                
                for (int x = start_j; x <= start_j+2; x++){
                    plus += map[x][i];
                }
                //System.out.println(plus);
                max = Math.max(max, plus);
            }
        }

        // 2*2 탐색
        for (int i = 0 ; i < n; i++){
            if (i + 1 >= n) break;
            for (int j = 0; j < m; j++){
                if (j + 1 >= m) break;

                int start_i = i;
                int start_j = j;

                int plus = searchTwoTwo(start_i, start_j);
                max = Math.max(max, plus);
            }
        }

        System.out.println(max);


    }
}