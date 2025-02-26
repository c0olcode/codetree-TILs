import java.io.*;
import java.util.*;

public class Main {

    public static int n,m;
    public static int map[][];
    public static int board[][];

    public static int max = Integer.MIN_VALUE;

    public static void clearBoard(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = 0;
            }
        }
    }

    public static void drawBoard(int x1,int y1,int x2,int y2){
        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                board[i][j] += 1;
            }
        }
    }

    public static boolean checkOverlap(int x1,int y1,int x2,int y2,int i,int j,int k,int l){
        // 보드 초기화
        clearBoard();

        // 좌표별로 보드 칠하기 
        drawBoard(x1,y1,x2,y2);
        drawBoard(i,j,k,l);

        // 검사했을 때 2 이상이면 바로 true 반환 -> 보드 검사하기
        for (int x = 0; x < n; x++){
            for (int y = 0; y < m; y++){
                if (board[x][y] >= 2) return true;
            }
        }

        return false;
    }

    public static int sumRect(int x1,int y1,int x2,int y2){
        int sum = 0;

        for (int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++){
                sum += map[i][j];
            }
        }

        return sum;
    }




    public static void findRect(int x1, int y1, int x2, int y2){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for(int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        if(!checkOverlap(x1,y1,x2,y2,i,j,k,l)){
                            // 중복되지 않는다면 직사각형 합 구하고 최댓값 갱신하기
                            max = Math.max(max, sumRect(x1,y1,x2,y2) + sumRect(i,j,k,l));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.

        // 1. 첫번쨰 직사각형을 구한다 
        // 2. 두번쨰 직사각형을 첫번쨰 직사각형과 겹치지 않도록 구한다.
        // 3. 겹치지 않는 두 직사각형을 구했다면, 두 직사각형의 합을 구한다.
        // 4. 더 큰 수로 업데이트 한다.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        board = new int[n][m];

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 첫번째 직사각형 구하기(좌표 두개 구하기)
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for(int k = i; k < n; k++){
                    for (int l = j; l < m; l++){
                        findRect(i,j,k,l); // 안겹치는 두번째 직사각형 찾기
                    }
                }
            }
        }

        System.out.println(max);


    }
}