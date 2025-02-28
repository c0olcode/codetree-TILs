import java.util.*;

class Pair{
    int x,y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n,k,r1,r2,c1,c2;
    public static int min_time = Integer.MAX_VALUE;

    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};

    public static boolean visit[][];
    public static int grid[][];
    public static int time[][];

    public static ArrayList<Pair> wall = new ArrayList<>();
    public static ArrayList<Pair> select_wall = new ArrayList<>();

    public static Pair start, end;


    public static void removeWall(){
        for (Pair p:select_wall){
            grid[p.x][p.y] = 0;
        }
    }

    public static void clearWall(){
        for (Pair p:select_wall){
            grid[p.x][p.y] = 1;
        }
    }

    public static void initailize(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visit[i][j] = false;
                time[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void bfs(){
        // visit, time 초기화 작업
        initailize();

        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visit[start.x][start.y] = true;

        while(!q.isEmpty()){

            Pair p = q.poll();

            // 4방향 탐색
            for (int i = 0; i < 4; i++){

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (inRange(nx,ny) && !visit[nx][ny] && (grid[nx][ny]==0)){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                    time[nx][ny] = time[p.x][p.y] + 1;
                }
            }
        }

        // 만약 도착점 방문 안했으면 return
        if (!visit[end.x][end.y]) return;

        // 방문 했으면 최소시간 업데이트
        min_time = Math.min(min_time, time[end.x][end.y]);

    }

    public static void dfs(int index, int cnt){
        if (cnt == k){
            // 벽 없애기 작업
            removeWall();

            // BFS 탐색
            bfs();

            // 벽 원상 복구
            clearWall();

            return;
        }
        
        if(index == wall.size()) return;

        // 선택 o
        select_wall.add(wall.get(index));
        dfs(index+1, cnt+1);
        select_wall.remove(select_wall.size()-1);

        // 선택x
        dfs(index+1, cnt);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];
        time = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num  = sc.nextInt();
                grid[i][j] = num;
                if (num == 1) wall.add(new Pair(i,j));
            }
        }
        int r1 = sc.nextInt()-1;
        int c1 = sc.nextInt()-1;
        int r2 = sc.nextInt()-1;
        int c2 = sc.nextInt()-1;

        start = new Pair(r1,c1);
        end = new Pair(r2,c2);
        
        // 없앨 벽 고르기
        dfs(0,0);

        if (min_time == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(min_time);
        }
    }
}