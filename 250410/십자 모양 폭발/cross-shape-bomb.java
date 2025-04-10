import java.util.*;
import java.io.*;

public class Main {

    static int n,r,c,bomb_size;
    static int map[][];
    
    public static void main(String[] args) throws IOException{

        // 1. 입력 & 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        bomb_size = map[r][c] -1;

        map[r][c] = -1; // 터진 곳은 -1로 초기화

        // 2. 십자가 모양으로 폭탄 터트리기 
        for (int i = 0; i < bomb_size; i++){
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};
            
            for (int j = 0; j < 4; j++){ // 4방향
                int nx = r + dx[j]*(i+1);
                int ny = c + dy[j]*(i+1);

                if (nx >= 0 && nx < n && ny >= 0 && ny < n){ // 범위 내 좌표라면
                    map[nx][ny] = -1; // 폭탄 터짐
                }
            }
        }

        
        // for (int i =0; i < n; i++){
        //     for (int j = 0; j < n; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 3. temp 배열 생성
        ArrayList<Integer>[] temp = new ArrayList[n];

        // System.out.println();
        // for (int j =0; j < n; j++){
        //     for (int i = n-1; i >=0; i--){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int j =0; j < n; j++){
            temp[j] = new ArrayList<>();
            for (int i = n-1; i >=0; i--){
                if (map[i][j] > 0){
                    temp[j].add(map[i][j]);
                }
            }
        }
        // System.out.println();

        // for (int i = 0; i < temp.length;i++){
        //     System.out.println(temp[i].toString());
        // }

        // temp -> result 배열에 담기
        int result[][] = new int[n][n];

        for (int j =0; j < n; j++){
            int index = 0; // temp에 접근하기 위함.
            int max_index = temp[j].size()-1;


            for (int i = n-1; i >=0; i--){
                if (index > max_index){
                    result[i][j] = 0;
                }
                else{
                    result[i][j] = temp[j].get(index);
                    index++;
                }
            }
        }

        //System.out.println();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }












    }
}