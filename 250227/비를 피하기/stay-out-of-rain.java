// 0: 이동 가능
// 1: 이동 불가 (벽)
// 2: 이동 가능 (사람)
// 3: 이동 가능 && 비 피할 수 있음. 

import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n,h,m; 
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static int step[][]; // 이동거리 저장
    public static boolean visit[][]; // 방문여부 저장
    public static int grid[][]; // 입력받은 맵
    public static int ans[][];
    public static Queue<Pair> q = new LinkedList<>();
    public static ArrayList<Pair> person_list = new ArrayList<>(); //2
    public static ArrayList<Pair> shield_list = new ArrayList<>(); //3

    public static void printAns(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initailize(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visit[i][j] = false;
                step[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int x, int y){
        return x >=0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        return inRange(x,y) && (grid[x][y] != 1) && !visit[x][y];
    }

    public static void bfs(){
        // step, visit 초기화
        initailize();

        // 탐색 시작
        while(!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (canGo(nx,ny)){
                    visit[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                    step[nx][ny] = step[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];
        step = new int[n][n];
        ans = new int[n][n]; // 정답(출력할 것)
        
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int num = sc.nextInt();
                grid[i][j] = num;

                // 2,3인지 확인하고 리스트에 담기
                if(num == 2){ // 사람
                    person_list.add(new Pair(i,j));
                }
                else if(num == 3){
                    shield_list.add(new Pair(i,j));
                }
            }

        }
                
        // M == 0이면 그냥 -1 출력하고 끝내기
        if (m == 0){
            for (int i = 0; i < h; i++){
                Pair p = person_list.get(i);
                ans[p.x][p.y] = -1;
            }
            printAns();
            return;
        }

        // 사람 수(h)만큼 bfs 탐색 반복하기
        for (int i = 0; i < h; i++){ 
            Pair p = person_list.get(i);

            q.add(p);
            bfs();

            int dist = -1;

            // 비 피할 곳 방문여부 확인해서 더 작은 거리로 ans 업데이트 하기
            for (int j = 0; j < shield_list.size(); j++){
                Pair a = shield_list.get(j);

                if (visit[a.x][a.y]){
                    if (dist == -1) { 
                        dist = step[a.x][a.y];
                    }
                    else{
                        dist = Math.min(dist,step[a.x][a.y]);
                    }
                }
            }

            ans[p.x][p.y] = dist;
        }

        printAns();
    }
}