import java.util.Scanner;

public class Main {
    public static int n,m;
    public static int grid[][];
    public static int max_sum;
    public static int board[][];

    public static void Initailize(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = 0;
            }
        }
    }

    public static void printBoard(int i, int j, int k, int l){
        for (int q = i; q <=k; q++){
            for (int w = j; w <= l; w++){
                board[q][w] += 1;
            } 
        }
    }

    public static boolean isDouble(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(board[i][j] >= 2) return true;
            }
        }

        return false;
    }

    public static int getSum(int i, int j, int k, int l){
        int sum = 0;
        for (int q = i; q <= k; q++){
            for (int w = j; w <= l; w++){
                sum += grid[q][w];
            } 
        }

        return sum;
    }


    public static void checkBoard(int i, int j, int k, int l,int a,int b,int c,int d){
        // 보드 초기화
        Initailize();

        // 각자 보드에 1씩 더하기
        printBoard(i,j,k,l);
        printBoard(a,b,c,d);

        // 겹침 여부 조사하기
        if(isDouble()) return;

        int sum = getSum(i,j,k,l) + getSum(a,b,c,d);

        // 합 구하기
        max_sum = Math.max(sum, max_sum);
    }

    public static void getTwo(int i, int j, int k, int l){
        // 두번째 직사각형 좌표 구하기
        for (int a = 0; a < n; a++){
            for (int b = 0; b < m; b++){
                for (int c = a; c < n; c++){
                    for (int d = b; d < m; d++){
                        // 3. 두 직사각형 겹침 여부 검증하기
                        checkBoard(i,j,k,l,a,b,c,d);
                    }
                } 
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        max_sum = Integer.MIN_VALUE;

        grid = new int[n][m];
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        // 1. 첫번째 직사각형 좌표 구하기
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        // 2. 두 번째 직사각형 좌표 구하기
                        getTwo(i,j,k,l);
                    }
                } 
            }
        }

        System.out.println(max_sum);

    }
}