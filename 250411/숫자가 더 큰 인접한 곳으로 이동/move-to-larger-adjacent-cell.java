import java.util.Scanner;
public class Main {
    static int n;
    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.print(map[r][c] + " "); //제일 처음 숫자
        
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        while(true){
            boolean moved = false;

            for (int i = 0; i < 4; i++){ // 상하좌우 우선순위대로 이동
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (inRange(nx,ny) && (map[r][c] < map[nx][ny])){ //더 크다면
                    // 이동 & 이동 표시 & 출력
                    r = nx;
                    c = ny;
                    moved = true;
                    System.out.print(map[r][c] + " ");
                    break;
                }
            }

            // 예외처리-> 이동할 칸 없는 경우
            if(!moved) break;
        }

        
    }
}