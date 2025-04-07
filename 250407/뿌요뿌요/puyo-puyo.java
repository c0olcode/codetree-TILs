import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int n, bomb_cnt, max_size; // 터지게 되는 블럭 수, 최대 블럭의 크기 
    static int grid[][];
    static boolean visit[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visit[x][y] = true;

        int block_num = grid[x][y];
        int block_size = 1;

        while(!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (inRange(nx,ny) && !visit[nx][ny] && (grid[nx][ny]==block_num)){
                    q.add(new Pair(nx,ny));
                    visit[nx][ny] = true;
                    block_size++;
                }
            }
        }

        // 터지게 되는 블럭 수 업데이트
        if (block_size >= 4) bomb_cnt++;

        // 최대 블럭의 크기 업데이트 
        max_size = Math.max(block_size, max_size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 완전 탐색
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visit[i][j]){ // 방문 안했다면 탐색 시작
                    bfs(i,j);
                }
            }
        }

        System.out.println(bomb_cnt + " " + max_size);
        
    }
}