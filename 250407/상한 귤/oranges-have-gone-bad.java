import java.util.*;

class Pair{
    int x,y,time;
    public Pair(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int n,k;
    static int grid[][];
    static int result[][];
    static boolean visit[][];
    static Queue<Pair> q = new LinkedList<>();
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (inRange(nx,ny) && !visit[nx][ny] && (grid[nx][ny] == 1)){
                    result[nx][ny] = p.time+1; 
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny,p.time+1));
                }
            }
        }

    }

    public static void main(String[] args) {

        // 1. 변수 초기화 과정
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        result = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int value = sc.nextInt();
                grid[i][j] = value;
                if(value == 0){
                    visit[i][j] = true;
                    result[i][j] = -1;
                }
                else if(value == 2){
                    q.add(new Pair(i,j,0));
                    visit[i][j] = true; //result는 초기화되면 자동으로 0이니까 안해도 ㅇㅋ
                }
            }
        }

        // 2. 탐색 시작
        bfs();

        // 3. 예외 처리 (끝까지 상하지 않는 귤)
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visit[i][j]) {
                    result[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


            
    }
}