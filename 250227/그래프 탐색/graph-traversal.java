// 인접 리스트 이용해서 풀기
import java.util.*;
import java.io.*;

public class Main {

    public static int n,m,cnt;
    public static ArrayList<Integer> graph[];
    public static boolean visit[];


    public static void dfs(int p){
        // p에 해당하는 리스트 가져오기 (반복문)
        for (int i = 0; i<graph[p].size(); i++){
            // 리스트 가져와서 방문 안했다면
            int n = graph[p].get(i);

            if (!visit[n]){
                // 방문 표시하고 재귀하기 && cnt ++ 하기
                visit[n] = true;
                cnt++;
                dfs(n);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1]; //1번 부터 시작하니까 쉽게 접근하기 위함. 
        graph = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++){ // 리스트 생성 & 초기화
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());

            // 양방향 인접 리스트 완성하기
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        // dfs 탐색 시작 (1 넣기)
        visit[1] = true;
        dfs(1);

        System.out.println(cnt);


        
    }
}