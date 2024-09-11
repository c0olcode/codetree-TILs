import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[][] = new int[n][n];
        int happy = 0;

        for (int i = 0 ; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 탐색
        for (int i = 0 ; i < n; i++){
            int before = 0; //맵은 1~100으로 이뤄져있으니까 0으로 초기화
            int count = 1;
            for (int j = 0; j < n; j++){

                if (before == map[i][j]){
                    count++;
                }
                else{
                    before = map[i][j];
                    count = 1; //다시 시작하니까 count 초기화
                }

                if (count >= m){
                    happy++;
                    break;
                }
            }
        }

        // 열 탐색
        for (int i = 0 ; i < n; i++){
            int before = 0; //맵은 1~100으로 이뤄져있으니까 0으로 초기화
            int count = 1;
            for (int j = 0; j < n; j++){

                if (before == map[j][i]){
                    count++;
                }
                else{
                    before = map[j][i];
                    count = 1; //다시 시작하니까 count 초기화
                }

                if (count >= m){
                    happy++;
                    break;
                }
            }
        }

        System.out.println(happy);


    }
}