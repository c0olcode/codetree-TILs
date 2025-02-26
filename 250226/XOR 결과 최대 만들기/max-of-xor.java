import java.util.Scanner;

public class Main {

    public static int n,m, ans;
    public static int A[];

    public static void dfs(int index, int cnt, int xor){
        // & cnt == m이면 XOR 연산하기
        if (cnt == m) {
            // XOR 연산
            ans = Math.max(ans, xor);
            return;
        }

        // 인덱스 범위까지 탐색 다 했으면 return
        if (index >= n){
            return;
        }

        // 인덱스 선택 했을 때
        dfs(index+1, cnt+1, xor^A[index]);

        // 인덱스 선택 안했을 때
        dfs(index+1, cnt,xor);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        // n개 중 m개 고르기
        dfs(0,0,0);

        System.out.println(ans);
    
    
    }
}