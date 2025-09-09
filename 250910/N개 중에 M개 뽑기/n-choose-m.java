import java.util.Scanner;
import java.util.*;

public class Main {

    public static int n,m;
    public static List<Integer> list = new ArrayList<>();

    public static void dfs(int index, int cnt){
        if (cnt == m){
            for (int i = 0; i < m; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

            return;
        }
        if(index > n){
            return;
        }

        // 뽑
        list.add(index);
        dfs(index+1,cnt+1);
        list.remove(list.size()-1);

        // 안뽑
        dfs(index+1,cnt);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        dfs(1,0);
    }
}