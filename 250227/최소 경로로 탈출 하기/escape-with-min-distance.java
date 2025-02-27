// BFS 탐색



import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static boolean visit[][];
    public static int n, m;
    public static int a[][];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return inRange(x,y) && !visit[x][y] && (a[x][y]!=0);
    }

    public static void bfs(){
        
        while (!q.isEmpty()){

            Pair p = q.poll();
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                // 탐색 가능하다면 (범위 내 && 방문 x && 뱀 X) -> 방문표시, 큐에 넣기, a[i][j] +=1;
                if (canGo(nx,ny)){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                    a[nx][ny] += a[p.x][p.y];
                }
            }
        }
            
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visit = new boolean[n][m];
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        q.add(new Pair(0,0));
        visit[0][0] = true;
        bfs();

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         System.out.print(visit[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 우측 하단 방문 false면 -1 출력
        if (!visit[n-1][m-1]){
            System.out.println(-1);
        }
        else{ // 방문 했으면 a[n][m] 출력
            System.out.println(a[n-1][m-1]-1);
        }


    }
}