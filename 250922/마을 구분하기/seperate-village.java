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
    public static int n;
    public static int grid[][];
    public static boolean visit[][];
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};

    public static boolean inRange(int x, int y){
        return x >= 0 && x< n && y >= 0 && y < n;
    }
    
    public static int bfs(int x, int y){
        visit[x][y] = true;
        int cnt = 1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x,y));

        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (inRange(nx,ny) && grid[nx][ny] != 0 && !visit[nx][ny]){
                    cnt++;
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.

        int group_cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != 0 && !visit[i][j]){
                    int cnt = bfs(i,j);
                    group_cnt++;
                    list.add(cnt);
                }

            }
        }

        Collections.sort(list);

        System.out.println(group_cnt);
        for (Integer i : list){
            System.out.println(i);
        }
    }
}