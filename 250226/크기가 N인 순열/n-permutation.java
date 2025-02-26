import java.util.*;
public class Main {

    public static int n;
    public static int MAX_N = 8;
    public static boolean visit[] = new boolean[MAX_N + 1];
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void dfs(int cnt){
        if(cnt == n){
            for (int i = 0; i < n; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        // 순열 -> 1~n까지 반복문 돌리면서 방문 여부 확인
            // visit 배열 보고 방문했으면 continue;
            // 방문 안했으면 cnt++, list.add

        for (int i = 1; i <= n; i++){
            if (visit[i]) continue;
            
            list.add(i);
            visit[i] = true;
            dfs(cnt+1);

            list.remove(list.size()-1);
            visit[i] = false;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.

        dfs(0);

    }
}