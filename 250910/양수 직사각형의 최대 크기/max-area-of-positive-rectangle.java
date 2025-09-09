import java.util.Scanner;
public class Main {

    public static int n,m;
    public static int grid[][];
    public static int max_size = -1;

    public static void search(int i , int j, int k , int l){
        int cnt = 0;
        for (int x = i; x <= k; x++){
            for (int y = j; y <= l; y++){
                if (grid[x][y] <= 0) return;
                cnt++;
            }
        }

        max_size = Math.max(max_size, cnt);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        // 2개 좌표 정하기 
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k <n; k++){
                    for (int l = j; l < m; l++){
                        search(i,j,k,l);
                    }
                }
            }
        }

        System.out.println(max_size);
    }
}