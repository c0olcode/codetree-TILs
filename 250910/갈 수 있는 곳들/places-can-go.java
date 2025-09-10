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
    public static int n,k;
    public static boolean visit[][];
    public static int grid[][];
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};

    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y){
        return x >= 0 && x <n && y>=0 && y <n;
    }

    public static void bfs(){

        while(!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if (inRange(nx,ny) && !visit[nx][ny] && grid[nx][ny] ==0){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            visit[x][y] = true;
            q.add(new Pair(x,y));
        }

        bfs();

        int cnt = 0;
        for (int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visit[i][j]) cnt++;
            }
        }

        System.out.println(cnt);



    }
}