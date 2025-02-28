import java.util.Scanner;

public class Main {

    public static int n,m;
    public static int max_safeCnt = Integer.MIN_VALUE;
    public static int max_k = 100;
    public static int max_high = 1;
    public static int curr_k;
    public static int grid[][];
    public static boolean visit[][];
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static boolean canGo(int x, int y){
        return inRange(x,y) && (grid[x][y] > curr_k) && !visit[x][y];
    }

    public static void dfs(int x, int y){

        // 4방향 탐색하기
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx,ny)){
                visit[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }

    public static void initializeVisit(){
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
        

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                int num = sc.nextInt();
                grid[i][j] = num;
                if (num > max_high) max_high = num;
            }
                

        // Please write your code here.

        // 쵣 높이 max_high이니까 max_high까지 탐색하기.
        for (int k = 1; k <= max_high; k++){
            // 안전 영역 수
            int cnt = 0;
            curr_k = k;

            // 방문 초기화
            initializeVisit();

            // 탐색하기
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    //탐색 가능 여부 보고 dfs 탐색하기
                    if(canGo(i,j)){
                        visit[i][j] = true;
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            // dfs 탐색 끝났으면, 안전 영역 수 비교해서 최댓값 업데이트
            if (cnt > max_safeCnt){
                max_k = k;
                max_safeCnt = cnt;
            }
        }

        System.out.println(max_k + " " + max_safeCnt);
    }
}