import java.util.*;
import java.io.*;

public class Main {

    public static final int MAX_N = 10;
    public static boolean visited[] = new boolean[MAX_N];

    public static int n;
    public static int map[][] = new int[MAX_N][MAX_N];
    public static int maxSum = 0;

    // 백트래킹으로 최댓값 구하기
    public static void getMax(int cnt, int sum){
        if (cnt == n){
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int j = 0; j < n; j++){ // j는 열 인덱스
            if (visited[j]) continue;

            visited[j] = true;
            getMax(cnt+1, sum+map[cnt][j]);

            visited[j] = false;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getMax(0, 0);

        System.out.println(maxSum);
    }
}