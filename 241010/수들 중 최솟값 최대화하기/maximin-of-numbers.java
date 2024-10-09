import java.io.*;
import java.util.*;

public class Main {

    //public static int semiMin = Integer.MAX_VALUE;
    public static int finalMax = Integer.MIN_VALUE;
    public static final int MAX_N = 10;
    public static int n;

    public static boolean visited[] = new boolean[MAX_N];
    public static int map[][] = new int[MAX_N][MAX_N];
    public static ArrayList<Integer> picked = new ArrayList<>();

    public static void dfs(int cnt){
        if (cnt == n){

            int semiMin = Integer.MAX_VALUE;
            for (int i = 0; i < picked.size(); i++){
                semiMin = Math.min(semiMin, map[i][picked.get(i)]);
            }

            finalMax = Math.max(finalMax, semiMin);

            return;
        }

        for (int i = 0; i < n; i++){
            if (visited[i]) continue;

            visited[i] = true;
            picked.add(i);
            
            dfs(cnt+1);

            visited[i] = false;
            picked.remove(picked.size()-1);

        }

    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.print(finalMax);

    }
}