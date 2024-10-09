import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NM = 20;
    public static final int map[][] = new int[MAX_NM][MAX_NM];

    public static int n;
    public static int m;

    // 좌표에 포함되는 값들이 양수 판별하고, 양수라면 최종 크기 반환하기
    public static int isPositive(int x1, int y1, int x2, int y2){
        int count = 0;

        for (int i = x1; i <= x2 ; i++){
            for (int j = y1; j <= y2; j++){
                // 음수거나 0이라면
                if (map[i][j] <= 0){ 
                    return -1; // 못 찾는거니까 -1
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int maxSize = -1;

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 양쪽 대각선 좌표 구하기
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        maxSize = Math.max(maxSize, isPositive(i,j,k,l));
                    }
                }
            }
        }

        System.out.print(maxSize);
    }
}