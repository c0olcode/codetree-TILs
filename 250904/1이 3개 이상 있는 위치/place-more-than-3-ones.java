import java.util.Scanner;
public class Main {

    public static int n;

    public static boolean inRange(int x, int y){
        return x >=0 && x < n && y >=0 && y <n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int cnt = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};


        // 반복문 돌려서 완전탐색
            // 좌표 하나씩 잡고 상하좌우 탐색해서 인접 숫자 1이 3개 이상인지 확인하고, 조건 만족하면 cnt++
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int fcnt = 0;

                for (int d = 0; d < 4; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    
                    if (inRange(nx,ny) && arr[nx][ny] == 1){
                        fcnt++;
                    }
                }

                if (fcnt >= 3) cnt++;
            }
        }

        System.out.println(cnt);
        

    }
}