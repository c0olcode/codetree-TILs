import java.io.*;
import java.util.*;

// 코드 순서
// 1. 반복문 돌려서 완전 탐색하는 좌표 하나하나를 중심점으로 잡기
// 2. 중심점으로 잡은 좌표를 기준으로 k가 0~최댓값 될 때까지 금 갯수를 각각 구해서 최댓값으로 업데이트하기
// 3. 이 과정을 좌표 끝까지 돌려서 , 최대 금 갯수 구하기 


public class Main {

    public static int n,m;
    public static int map[][];

    public static int getNumOfGold(int row, int col, int k){
        // row, col이 중심점이고, k개 일 때의 금 갯수 구하기
        int numOfGold = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (Math.abs(row-i) + Math.abs(col-j) <= k){ 
                    //마름모 범위 안에 좌표가 있는지 확인
                    numOfGold += map[i][j];
                }
            }
        }
        return numOfGold;
    }

    // 주어진 k에 대해 마름모의 넓이 반환하기
    public static int getArea(int k){
        return k * k + (k+1) * (k+1);
    }



    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //맵 크기
        m = Integer.parseInt(st.nextToken()); //금 하나의 가격
        int maxGold = 0;

        map = new int[n][n];

        for (int i = 0; i < n; i++){ //맵 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 완전 탐색
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                // 위치 하나당 k가 1,2,3,.. 일 때 금 채굴 얼마나 되는지 계산하기
                for (int k = 0; k <= 2*(n-1); k++){
                    //k의 최댓값은 2*(n-1)
                    int numOfGold = getNumOfGold(i,j,k);

                    // 손해 보지 않으면서 채굴할 수 있는 최대 금 갯수 저장하기
                    if(numOfGold * m >= getArea(k)){
                        maxGold = Math.max(maxGold, numOfGold);
                    }
                     

                }

            }
        }

        System.out.print(maxGold);

        

        





    }
}