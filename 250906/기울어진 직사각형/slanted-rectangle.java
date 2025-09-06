import java.util.Scanner;
public class Main {

    public static int n;
    public static int grid[][];
    public static int max_sum;
    public static int dx[] = {-1,-1,1,1};
    public static int dy[] = {1,-1,-1,1};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void move(int i , int j, int k, int l){
        int sum = 0;

        // 1번 이동
        for (int m = 1; m <= k; m++){
            i += dx[0];
            j += dy[0];
            // 만약 해당 좌표가 범위 벗어나면 탐색 끝내기 -> 추후에 더 큰 범위 탐색 못하도록 수정하기
            if (!inRange(i,j)) return;

            sum += grid[i][j];
        }
        // 2번 이동
        for (int m = 1; m <= l; m++){
            i += dx[1];
            j += dy[1];
            // 만약 해당 좌표가 범위 벗어나면 탐색 끝내기 -> 추후에 더 큰 범위 탐색 못하도록 수정하기
            if (!inRange(i,j)) return;

            sum += grid[i][j];
        }
        // 3번 이동
        for (int m = 1; m <= k; m++){
            i += dx[2];
            j += dy[2];
            // 만약 해당 좌표가 범위 벗어나면 탐색 끝내기 -> 추후에 더 큰 범위 탐색 못하도록 수정하기
            if (!inRange(i,j)) return;

            sum += grid[i][j];
        }
        // 4번 이동
        for (int m = 1; m <= l; m++){
            i += dx[3];
            j += dy[3];
            // 만약 해당 좌표가 범위 벗어나면 탐색 끝내기 -> 추후에 더 큰 범위 탐색 못하도록 수정하기
            if (!inRange(i,j)) return;

            sum += grid[i][j];
        }


        // 최댓값 갠신
        max_sum = Math.max(max_sum, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        // 1. 시작점 정하기
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                // 2. 몇 칸 이동할건지 선택하기 (최대 n칸 이동 가능)
                for (int k = 1; k <=n; k++){
                    for (int l = 1; l<=n; l++){
                        // 3. 이동하기 -> 범위 밖이면 끝내기
                        move(i,j,k,l);
                    }
                }

            }
        }


        System.out.println(max_sum);
    }
}