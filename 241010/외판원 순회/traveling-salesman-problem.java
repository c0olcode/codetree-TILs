import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX_N = 10;
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int n;
    public static int[][] cost = new int[MAX_N][MAX_N];
    public static boolean visited[] = new boolean[MAX_N];
    public static ArrayList<Integer> picked = new ArrayList<>();
    public static int min = INT_MAX;

    public static void dfs(int cnt){
        if (cnt == n){
            int sum = 0;

            // 처음 편도
            for (int i = 0; i < picked.size()-1; i++){
                int first = cost[picked.get(i)][picked.get(i+1)]; //0이면 방문 안됨

                if (first == 0) return;

                sum += first;
            }

            // 제일 마지막-> 1로 다시 돌아오는 거
            int last = cost[picked.get(picked.size()-1)][0];

            if (last == 0) return;

            sum += last;

            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n; i++){ // 순열 구하기
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

        // 백트래킹으로 1로 시작하는 모든 순열 구한 후
        // 해당 순열에 대해 합 구하기
        // -> 단 순열에 해당하는 cost가 0이면 지날 수 없기에 탐색 끝내기
        // -> 끝까지 탐색해서 비용을 구했다면, 최소비용 업데이트 하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순열 구하기
        visited[0] = true;
        picked.add(0); // 1번은 첫번째로 방문한다. (순열로는 0 인덱스)
        dfs(1); // 1번은 첫번째로 탐색하니까, 이미 탐색했다는 의미로 1 넣음.

        System.out.print(min);

    }
}