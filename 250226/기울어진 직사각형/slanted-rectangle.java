import java.util.Scanner;
public class Main {

    public static int n,max;
    public static int grid[][];
    public static int dx[] ={-1,-1,1,1};
    public static int dy[] ={1,-1,-1,1};

    public static boolean inRange(int x, int y){
        return x >=0 && x < n && y >= 0 && y <n;
    }

    public static int countScore(int i,int j, int k, int l){
        int moveCnt[] = {k,l,k,l};

        int cnt = 0;

        for (int dir = 0; dir < 4; dir++){// 4방향으로 이동하며, 좌표가 범위 안에 있는지 확인하고 더하기

              // 대각선 0방향에 대해 k번 이동하기 or
                // 대각선 1방향에 대해 l번 이동하기 or
                // 대각선 2방향에 대해 k번 이동하기 or
                // 대각선 3방향에 대해 l번 이동하기 -> 이래서 k,l 두개인데 배열 크기 4로 함.(방향 4개니까)
            for (int move =0; move < moveCnt[dir]; move++){
                i += dx[dir];
                j += dy[dir];

                if (!inRange(i,j)) return 0;
                cnt += grid[i][j];
            }
        }

        return cnt;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        // 탐색할 좌표를 선택한다.
        // 좌표의 가로, 세로 증가 폭을 반복문 돌리면서 정한다 -> 정하고 해당 좌표로 갔는데, 범위 내가 아닐겅우에는 break;
            // 탐색 다 했으면 max값 업데이트하기.

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 1; k < n; k++){ //1,3 방향 길이
                    for (int l = 1; l < n; l++){ // 2,4 방향 길이
                        // max값 계속 경신하기
                        max = Math.max(max,countScore(i,j,k,l));
                    }
                }
            }
        } 

        System.out.println(max);
    }
}