import java.util.*;

public class Main {

    public static int n;
    public static int min_cost = Integer.MAX_VALUE;
    public static int cost[][];
    public static boolean visit[];
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void calcCost(){
        int c = 0;

        for (int i = 0; i < n-1; i++){
            int v1 = list.get(i);
            int v2 = list.get(i+1);

            if(cost[v1][v2]==0) return; //0이면 이동 불가니까 return

            c += cost[v1][v2];
        }
        int last = list.get(n-1);
        int first = list.get(0);

        // 마지막 정점과 첫번째 정점 이어주기
        if(cost[last][first]==0) return; //0이면 이동 불가니까 return
        c += cost[last][first];

        // 최소 거리 업데이트
        min_cost = Math.min(min_cost, c);
    }

    public static void dfs(int cnt){
        if(cnt == n){
            // 거리 계산 & 최소거리 업데이트
            // for (int i = 0; i < list.size(); i++){
            //     System.out.print(list.get(i) + " ");
            // }
            // System.out.println();
            calcCost();
            return;
        }

        // 방문 안한 정점 방문하기
        for(int i = 1; i < n; i++){
            if (!visit[i]){
                visit[i] = true;
                list.add(i);

                dfs(cnt+1);

                visit[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        visit[0] = true; // 1번지점부터 무조건 탐색해야함 (인덱스론 0)
        list.add(0);
        dfs(1);

        System.out.println(min_cost);
        
    }
}