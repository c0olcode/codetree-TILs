import java.util.*;
public class Main {

    public static int n;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static boolean visit[];

    public static void dfs(int cnt){
        if (cnt == n){
            for (int i = 0; i < n; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!visit[i]){
                list.add(i);
                visit[i] = true;
                dfs(cnt+1);
                visit[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n+1];
        // Please write your code here.

        dfs(0);
    }
}