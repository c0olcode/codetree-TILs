import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX_N = 10;
    public static int n;
    public static int map[];
    public static int min = Integer.MAX_VALUE;
    public static int totalSum = 0;
    public static ArrayList<Integer> select = new ArrayList<>();

    public static int calc(){
        int value = 0;
        for (int i = 0; i < select.size(); i++){
            value += map[select.get(i)];
        }

        int second = totalSum - value;

        return Math.abs(value - second);
    }


    public static void dfs(int index, int cnt){
        if (cnt == n){
            // 리스트 속 숫자로 계산하기
            min = Math.min(min, calc());
            return;
        }
        
        if (index == map.length) return;

        // 해당 인덱스를 선택하지 않았을 때
        dfs(index + 1, cnt);

        // 선택했을 때
        select.add(index);
        dfs(index + 1, cnt + 1);
        select.remove(select.size()-1);
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[2*n];

        for (int i = 0; i < 2*n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            totalSum += map[i];
        }

        dfs(0,0);

        System.out.print(min);
    }
}