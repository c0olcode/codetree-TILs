import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        int happy = 0;

        if (m == 1) {
            System.out.println(2*n);
            return;
        }

        // 행 탐색
        for (int i = 0; i < n; i++){
            int succeed_num = -1;
            int succeed_cnt = 1;
            for (int j = 0; j < n; j++){
                
                // succeed_num 비교하며 연속여부 확인
                // 연속이면 cnt ++ & m 이상인지 충족여부 확인 -> 충족이면 반복문 종료하고 행복 수열++
                if (succeed_num == grid[i][j]){
                    succeed_cnt++;
                    if (succeed_cnt >= m) {
                        happy++;
                        //System.out.println("행" + i + " " + j);
                        break;
                    }
                }
                else{// 연속 아니면 succeed_num을 현재 값으로 갱신 & cnt 0으로 갱신
                    succeed_num = grid[i][j];
                    succeed_cnt = 1;
                }
            }
        }

        // 열 탐색
        for (int j = 0; j < n; j++){
            int succeed_num = -1;
            int succeed_cnt = 1;

            for (int i = 0; i < n; i++){
                // succeed_num 비교하며 연속여부 확인
                // 연속이면 cnt ++ & m 이상인지 충족여부 확인 -> 충족이면 반복문 종료하고 행복 수열++
                if (succeed_num == grid[i][j]){
                    succeed_cnt++;

                    if (succeed_cnt >= m) {
                        happy++;
                        //System.out.println("열" + i + " " + j);
                        break;
                    }
                }
                else{// 연속 아니면 succeed_num을 현재 값으로 갱신 & cnt 0으로 갱신
                    succeed_num = grid[i][j];
                    succeed_cnt = 1;
                }
            }
        }

        System.out.println(happy);


    }
}