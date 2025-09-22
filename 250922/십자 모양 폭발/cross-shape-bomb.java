import java.util.*;

public class Main {
    public static int n;
    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        // Please write your code here.

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};

        // 1. 격차 폭파 시키기
            // 1. 본인 폭파
        int bomb_size = grid[r][c];
        grid[r][c] = 0;
        for (int i = 1; i <bomb_size; i++){
            for (int j = 0; j < 4; j++){
                int nx = r + dx[j]*i;
                int ny = c + dy[j]*i;
                if (inRange(nx,ny)){
                    grid[nx][ny] = 0;
                }
            }
        }

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < n; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        //int[][] second_grid = new int[n][n];

        for (int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if (grid[j][i] != 0) list.add(grid[j][i]);
            }
            
            for (int j = n-1; j >= 0; j--){
                if (list.size() != 0){
                    grid[j][i] = list.get(list.size()-1);
                    list.remove(list.size()-1);
                }else{
                    grid[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }




    }
}