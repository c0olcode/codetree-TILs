import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n,k;
    public static int[][] map;

    public static Pair currCell; // 현재 위치
    public static boolean[][] visited;
    public static Queue<Pair> bfsQ = new LinkedList<>();

    public static final Pair NOT_EXISTS = new Pair(-1,-1);

    public static boolean isRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int targetNum){
        // 범위 안에 x,y가 있는가?
        // 방문 안했는가? 
        // targetNum > map[x][y] 인가? 

        return isRange(x,y) && !visited[x][y] && targetNum>map[x][y];

    }

    public static void bfs(){

        // bfs 탐색해서 갈 수 있는 모든 좌표를 방문 표시 해둠. 
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        // 시작점 먼저 큐에 넣기
        int cX = currCell.x;
        int cY = currCell.y;
        visited[cX][cY] = true;
        bfsQ.add(currCell);

        // 시작점의 숫자
        int targetNum = map[cX][cY];

        while(!bfsQ.isEmpty()){
            Pair currPos = bfsQ.poll();
            int currX = currPos.x;
            int currY = currPos.y;

            for (int i = 0; i < 4; i++){
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if (canGo(newX, newY, targetNum)){
                    bfsQ.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }

        }
    }

    public static void initializeVisited(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }

    }

    public static boolean needUpdate(Pair bestPos, Pair newPos){

        // bestPos가 NOT_EXIST면 바로 ture return
        if (bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y) return true;
        
        int bx = bestPos.x;
        int by = bestPos.y;
        int nx = newPos.x;
        int ny = newPos.y;

        // newPos의 숫자가 더 크면 ture return/ 작으면 false
        if (map[bx][by] != map[nx][ny]){
            return map[bx][by] < map[nx][ny];
        }
        // 위에서 안걸러졌으면 행비교
        if (bx != nx){
            return bx > nx;
        }
        // 위에서 안걸러졌으면 열비교
        return by > ny;
    }

    public static boolean move(){
        // BFS 탐색을 k번 하기 때문에, 탐색 전마다 visited를 초기화해야함. 
        initializeVisited();

        // BFS 진행하여 갈 수 있는 모든 위치 탐색하기
        bfs();

        // BFS 탐색 통해 갈 수 있는 위치를 구했다면, 해당 위치들 중 가장 우선순위 높은 위치 구하기
        Pair bestPos = NOT_EXISTS; // 초기값은 방문 못하는 좌표로
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                // 갈 수 있는 위치가 아니거나(!visited[i][j]), 현재 위치라면 건너뛰기
                if (!visited[i][j] || i == currCell.x && j == currCell.y) continue;

                Pair newPos = new Pair(i,j); // 갈 수 있는 위치
                // 갈 수 있는 위치와 현재까지의 best위치 비교해서 우선순위 높은 걸로 업데이트하기
                if (needUpdate(bestPos, newPos)){
                    bestPos = newPos;
                }
            }
        }

        // 우선순위 높은 위치로 이동한다.

        // 움직일 위치 없으면 false (이동하지 않았다.)
        if (bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y){
            return false;
        }else{
            currCell = bestPos;
            return true;
        }


    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        // 초기 위치 설정
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        currCell = new Pair(r-1, c-1);

        // k번에 걸쳐 움직이는 것 반복하기
        for (int i = 0; i < k; i++){
            boolean isMoved = move();

            // 움직이지 않았다면 k번 돌지 않아도 종료하기
            if (!isMoved) break;
        }

        // 행, 열은 1부터 시작하니까 1 더해줌
        int finalX = currCell.x;
        int finalY = currCell.y;

        System.out.print((finalX + 1) + " " + (finalY + 1));

    }
}