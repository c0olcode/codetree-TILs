import java.io.*;
import java.util.*;

// 결론 : 네 방향 탐색 할 수 있도록 반복문 세팅해놓고 
// 한 방향 당 몇 칸 가는지를 반복문으로 구현한다. 

public class Main {

    public static int n;
    public static int map[][];
    public static final int DIR_NUM = 4; // 네 방향
    public static final int MAX_N = 20; // n의 최댓값

    // 2차원 배열이 범위 내에 있는지 확인하는 함수
    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // 2. 시작점으로 삼은 좌표를 가지고 넓이/높이에 따라 직사각형 구하기 (-> 점수 산출 위함)
    // getScore 메서드는 기울어진 직사각형의 점수(값의 합)를 계산하는 역할
    public static int getScore(int x, int y, int k, int l){

        int[] dx = new int[]{-1,-1,1,1}; // 대각선 탐색 위함
        int[] dy = new int[]{1,-1,-1,1};
        int[] moveNum = new int[]{k,l,k,l}; // 높이, 넓이

        int sumOfNums = 0;

        //직사각형 경계 따라가며 값 합산하기
        for (int d = 0; d < DIR_NUM; d++){ //대각선 네 방향
            // 대각선 네 방향에 대해 순서대로 이동함
            for (int q = 0; q < moveNum[d]; q++){

                // 대각선 0방향에 대해 k번 이동하기 or
                // 대각선 1방향에 대해 l번 이동하기 or
                // 대각선 2방향에 대해 k번 이동하기 or
                // 대각선 3방향에 대해 l번 이동하기 -> 이래서 k,l 두개인데 배열 크기 4로 함.(방향 4개니까)

                x += dx[d];
                y += dy[d];

                // 경계 벗어나면 불가능하니, 답 갱신 안되도록 0 반환하기
                if(!inRange(x,y)) {
                    return 0;
                }
                sumOfNums += map[x][y];
            }
        }
        return sumOfNums;
    }
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        int maxValue = 0;

        // map 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } 



        // 탐색을 어떻게..? 
        // 1. 반복문으로 각 좌표 돌면서 해당 좌표를 시작점으로 삼기
        // 2. 해당 좌표 기준으로 1,2,3,4번 방향순으로 순회하기 (순회 가능한지 체크)
        
        // 1. 좌표 완전탐색 (-> 해당 좌표를 시작점으로 삼기 위함)
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 1; k < n; k++){ //높이와
                    for (int l = 1; l < n; l++){ //너비
                        maxValue = Math.max(maxValue, getScore(i,j,k,l)); //완전탐색하면서 최댓값 업데이트
                    }
                }
            }
        }
        
        System.out.print(maxValue);
    }
}