import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int result = Integer.MIN_VALUE;

        // 2*2 탐색
        for (int i = 0; i <= n-2; i++){
            for (int j = 0; j <= m-2; j++){
                int min = Integer.MAX_VALUE;
                int sum = 0;

                for (int k = i; k <= i+1; k++){
                    for (int l = j; l <= j+1; l++){
                        sum += grid[k][l];
                        min = Math.min(min, grid[k][l]);
                    }
                }

                sum -= min;
                result = Math.max(sum,result);
            }
        }

        // 1*3
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= m-3; j++){
                int sum = 0;

                for (int k = j; k <= j+2; k++){
                    sum += grid[i][k];
                }

                result = Math.max(sum,result);
            }
        }

        // 3*1
        for (int j = 0; j < m; j++){
            for (int i =0; i <= n-3; i++){
                int sum = 0;
                for (int k = i; k <= i+2; k++){
                    sum += grid[k][j];
                }
                result = Math.max(sum,result);
            }
        }

        System.out.println(result);


    }
}