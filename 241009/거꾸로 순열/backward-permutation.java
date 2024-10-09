import java.util.*;
import java.io.*;

public class Main {

    public static final int MAX_N = 8;
    public static int n;
    public static boolean visited[] = new boolean[MAX_N+1];
    public static ArrayList<Integer> picked = new ArrayList<>();

    public static void getPermutation(int cnt){
        if (cnt == n){
            for (int i = 0; i < picked.size(); i++){
                System.out.print(picked.get(i) + " ");
            }

            System.out.println();

            return;
        }

        // 배열 인덱스 == 숫자 
        // visited의 i 인덱스를 숫자 i에 대한 방문 여부로 생각하기.
        for (int i = n; i > 0; i--){
            if (visited[i]) continue;

            visited[i] = true;
            picked.add(i);

            getPermutation(cnt+1);

            visited[i] = false;
            picked.remove(picked.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 거꾸로 탐색하기
        // cnt 넣기
        // 방문 체크하기
        getPermutation(0);
    }
}