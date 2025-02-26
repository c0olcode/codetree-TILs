import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static boolean visit[][];
    public static Queue<Pair> q = new LinkedList<>();

    public static int n,m;
    public static int grid[][];

    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};

    public static boolean inRange(int x, int y){
        return x >=0 && x < n && y >= 0 && y < m;
    }

    public static int bfs(){
        // BFS 시작
            // 큐 꺼내기
            // dx,dy로 4방향 탐색하기 (for문)
                // 범위 안에 있고 && 뱀 없고 && 방문 안했으면
                    // 방문 표시 & 큐에 담기
        while(!q.isEmpty()){
            Pair p = q.poll();

            if (p.x == n-1 && p.y == m-1){
                return 1;
            }

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (inRange(nx,ny) && !visit[nx][ny] && grid[nx][ny] == 1){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }

            }
        }
        return 0;
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

        // 시작점 (0,0) 큐에 넣기 & 방문 표시
        q.add(new Pair(0,0));
        visit[0][0] = true;

        System.out.println(bfs());

        

    }
}