import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int m;
    public static final int MAXNM = 10;

    public static void dfs(int startIndex, int depth, int[] arr){
        if (depth == m){
            // arr 출력
            for (int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIndex; i < n; i++){
            arr[depth] = i+1; // 인덱스는 0부터 시작하지만 숫자는 1부터 시작하기 때문
            dfs(i+1, depth+1, arr);

        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int arr[] = new int[MAXNM];

        dfs(0,0,arr);

    }
}