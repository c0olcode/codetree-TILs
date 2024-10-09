import java.io.*;
import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MIN_VALUE; // 가장 작은 정수 값
    public static final int MAX_NUM = 5;

    public static int n;
    public static int m;
    public static int[][] map = new int[MAX_NUM][MAX_NUM];
    public static int[][] board = new int[MAX_NUM][MAX_NUM];


    public static void clearBoard(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = 0;
            }
        }
    }

    // 직사각형 겹치는지 확인하기
    public static boolean checkBoard(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] >= 2) return true;
            }
        }
        return false;
    }
    
    // 색칠하기
    public static void draw(int x1, int y1, int x2, int y2){
        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                board[i][j]++;
            }
        }
    }

    // 주어진 좌표에 해당하는 두 직사각형이 겹치는지 확인하기
    public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        clearBoard();
        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);
        return checkBoard();
    }


    // 주어진 좌표에 해당하는 직사각형의 합 구하기
    public static int rectSum(int x1, int y1, int x2, int y2){

        int sumOfNums = 0;
        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                sumOfNums += map[i][j];
            }
        }

        return sumOfNums;
    }

    // 첫 번째 직사각형이 (x1, y1), (x2, y2)를 양쪽 꼭지점으로 할 때
    // 두 번째 직사각형을 겹치지 않게 잘 잡아
    // 최대 합을 반환하는 함수
    public static int findMaxSum(int x1, int y1, int x2, int y2){
        int maxSum = INT_MIN;

        // (i, j), (k, l)을 양쪽 꼭지점으로 하는
        // 두 번째 직사각형을 정하여
        // 겹치지 않았을 때 중
        // 최댓값을 찾아 반환합니다.
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        if (!overlapped(x1, y1, x2, y2, i, j, k, l)){
                            maxSum = Math.max(maxSum,
                            rectSum(x1,y1,x2,y2)+ rectSum(i, j, k, l));
                        }
                    }
                }
            }
        }

        return maxSum;
    }

    // 두 직사각형을 잘 잡았을 때의 최대 합을 반환하는 함수
    public static int findMaxSum(){
        int maxSum = INT_MIN; //처음에는 최솟값으로 설정해두기

        // (i,j) (k,l)을 양쪽 꼭지점으로 하는 첫번째 직사각형 정하여
        // 그 중 최댓값을 찾아 반환
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        maxSum = Math.max(maxSum, findMaxSum(i,j,k,l));
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        // 경계는 닿아도 ㅇㅋ
        // 정사각형이어도 되는거지? -> ㅇㅇ 안따져도 될듯
        // 직사각형은 정사각형이 될 수 없다. -> 정사각형은 직사각형이 될 수 있다.

        // 1. 시작점을 정한다.
        // 2. 시작점에 따라 다양한 직사각형을 그린다.
        // 3. 그린 직사각형과 겹치지 않는 또다른 다양한 직사각형을 그린다.
        // 4. 합을 구해서 최댓값을 업데이트 한다. 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = findMaxSum();
        System.out.print(ans);

    }
}