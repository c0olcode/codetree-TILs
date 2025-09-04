import java.util.Scanner;
public class Main {

    public static int n,m;

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y <m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        int arr[][] = new int[n][m];

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int dir = 0;

        int x = 0;
        int y = 0;
        arr[x][y] = 1;

        for (int i =2; i <= n*m; i++){
            // 다음 칸 좌표 구한 후 범위 내 || 방문x 만족 확인
                // -> 불만족 시 위치 회전
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if (!inRange(nx,ny) || arr[nx][ny] != 0){
                dir = (dir+1) % 4;
            }

            // 다음 칸 좌표로 이동 후, 숫자 채우기
            // 현재 좌표 정보 갱신
            x = x+dx[dir];
            y = y+dy[dir];
            arr[x][y] = i;
        } 
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}