import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX_N = 8;

    public static int n;
    public static boolean visited[] = new boolean[MAX_N+1];
    public static ArrayList<Integer> picked = new ArrayList<>();


    public static void getPermutation(int depth){
        if (depth == n){
            for (int i = 0; i < picked.size(); i++){
                System.out.print(picked.get(i) + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++){
            if (visited[i]) continue;

            visited[i] = true;
            picked.add(i);

            getPermutation(depth+1);

            visited[i] = false;
            picked.remove(picked.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        getPermutation(0);
    }
}