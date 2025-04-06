import java.util.*;
import java.io.*;

public class Main {

    // 3. 최댓값 구함
    public static void searchMax(int x1, int y1, int x2, int y2){
        int cnt = 0;

        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                if (map[i][j] <= 0){ // 값이 음수라면
                    return;
                }
                cnt++;
            }
        }
        max_result = Math.max(cnt, max_result);
    }


    public static int N,M;
    public static int map[][];
    public static int max_result = -1;

    public static void main(String[] args) throws IOException{

        // 1. 입력 받기 & 변수 초기화 작업
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 모든 좌표 조합 구하기 (왼쪽 상단, 오른쪽 하단 점 두개)
        // (x1,y1) (x2,y2)
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                for (int k = i; k < N; k++){ // x2
                    for (int l = j; l < M; l++){ // y2
                        searchMax(i,j,k,l);
                    }
                }
            }
        }

        // 4. 모든 연산 끝났으면 양수직사각형 크기 반환.
       System.out.println(max_result);
    }
}