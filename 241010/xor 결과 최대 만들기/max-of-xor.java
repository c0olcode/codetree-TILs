import java.util.*;
import java.io.*;

public class Main {

    public static final int MAXNM = 20;

    public static int n;
    public static int m;
    public static int[] numArr = new int[MAXNM];
    public static ArrayList<Integer> picked = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

    public static void dfs(int depth, int start){
        if (depth == m){

            if (m == 1){
                max = Math.max(max, picked.get(0));
            }
            else if (m == 2){
                max = Math.max(max, picked.get(0) ^ picked.get(1));
            
            }
            else{
                int xor = picked.get(0) ^ picked.get(1);
                for (int i = 2; i < m; i++){
                    xor = xor ^ picked.get(i);
                }
                max = Math.max(max, xor);
            }

            return;
        }

        for (int i = start; i < n; i++){
            picked.add(i);
            dfs(depth+1, i+1);
            picked.remove(picked.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(max);



    }
}