import java.util.Scanner;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n,m;
    public static int dx[] = {1,0};
    public static int dy[] = {0,1};
    public static int grid[][];
    public static boolean visit[][];

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return inRange(x,y) && !visit[x][y] && (grid[x][y] == 1);
    }

    public static void dfs(Pair p){

        for (int i = 0; i < 2; i++){
            int nx = p.x+dx[i];
            int ny = p.y+dy[i];

            if (canGo(nx,ny)){
                visit[nx][ny] = true;
                dfs(new Pair(nx,ny));
            }
        }

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

        visit = new boolean[n][m];
        visit[0][0] = true;
        dfs(new Pair(0,0));

        if (visit[n-1][m-1]){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

}