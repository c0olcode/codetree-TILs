import java.util.*;

public class Main {

    // 인접그래프 정보 담을 리스트배열
    static ArrayList<Integer> graph[];
    static boolean visit[];
    static int N,M;
    static int cnt = 0;

    public static void dfs(int num){
        // num의 인접그래프를 순서대로 탐색 -> 해당 정점 방문 안했다면 방문 true & dfs 탐색 & cnt++

        for (int i = 0; i < graph[num].size();i++){
            int v2 = graph[num].get(i);
            
            if(!visit[v2]){
                visit[v2] = true;
                cnt++;
                dfs(v2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[N+1];

        // 인접리스트 초기화
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 1번부터 탐색 시작하니까 방문 true & dfs
        visit[1] = true;
        dfs(1);

        System.out.println(cnt);


        
    }
}