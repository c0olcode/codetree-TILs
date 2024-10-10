import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }    
}

public class Main {

    public static int n;
    public static int m;
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<Pair> list = new ArrayList<>();
    public static ArrayList<Pair> select = new ArrayList<>();


    public static int calc(){
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < select.size()-1; i++){
            for (int j = 0; j < select.size(); j++){
                int x_value = (select.get(i).x - select.get(j).x) * (select.get(i).x - select.get(j).x);
                int y_value = (select.get(i).y - select.get(j).y) * (select.get(i).y - select.get(j).y);

                max = Math.max(max, x_value+y_value);

            }
        }
        return max;
    }
    
    public static void dfs(int index, int cnt){
        if (cnt == m){
            min = Math.min(min, calc());
            return;

        }
        if (index == n){
            return;
        }

        // 선택 x
        dfs(index + 1, cnt);

        // 선택 o
        select.add(list.get(index));
        dfs(index + 1, cnt + 1);
        select.remove(select.size()-1);
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x,y));
        }

        dfs(0,0);  

        System.out.print(min);      
    }
}