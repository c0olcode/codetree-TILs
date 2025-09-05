import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int m_cnt = 0;

        if (n==3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) m_cnt++;
                }
            }
            System.out.println(m_cnt);
            return;

        }


        // 3*3 코드 -> 탐색 범위 그만큼 한정 짓기
        for (int i = 0; i< n-3; i++){
            for (int j = 0; j < n-3; j++){
                int cnt = 0;

                for (int k = i; k <= i+2; k++){
                    for (int l = j; l <=j+2; l++){
                        if (grid[k][l] == 1) cnt++;
                    }
                }

                m_cnt = Math.max(m_cnt, cnt);
            }
        }

        System.out.println(m_cnt);
    }
}