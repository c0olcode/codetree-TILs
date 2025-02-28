import java.util.*;

public class Main {

    public static int cnt, n,m;
    public static ArrayList<Integer> graph[];
    public static boolean visit[];

    public static void dfs(int v1){
        for (int i =0; i < graph[v1].size(); i++){
            int v2 = graph[v1].get(i);
            if(!visit[v2]){
                visit[v2] = true;
                cnt++;
                dfs(v2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        visit[1] = true;
        dfs(1);

        System.out.println(cnt);
    }
}