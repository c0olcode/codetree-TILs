import java.util.*;

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n,m;
    public static int grid[][];
    public static boolean visit[][];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y){
        return x >= 0 && x< n && y>= 0 && y < m;
    }

    public static void bfs(){

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (inRange(nx,ny) && !visit[nx][ny] && grid[nx][ny] == 1){
                    q.add(new Pair(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        // 시작점 입력
        q.add(new Pair(0,0));
        visit[0][0] = true;

        bfs();

        if (visit[n-1][m-1]) System.out.println(1);
        else System.out.println(0);




    }


}