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
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};

    public static boolean inRange(int x, int y){
        return x >= 0 && x< n && y >= 0 && y < m;
    }


    public static void bfs(int x, int y, int k){
        visit[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));

        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if (inRange(nx,ny) && grid[nx][ny] > k && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
    }

    public static void initVisit(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                visit[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visit = new boolean[n][m];
        int high_k = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                high_k = Math.max(grid[i][j], high_k);
            }
        // Please write your code here.

        int max_safe = 0;
        int min_k = high_k;

        for (int k = 1; k <= high_k; k++){
            int safe_cnt = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (grid[i][j] > k && !visit[i][j]){
                        bfs(i,j,k);
                        safe_cnt++;
                    }
                }
            }
            if (max_safe < safe_cnt){
                max_safe = safe_cnt;
                min_k = k;
            }
            initVisit();
        }

        System.out.println(min_k + " " + max_safe);

    }
}