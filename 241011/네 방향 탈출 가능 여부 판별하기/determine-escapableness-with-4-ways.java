import java.util.*;
import java.io.*;

class Pair {
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static Queue<Pair> q = new LinkedList<>();
    public static int map[][];
    public static boolean visited[][];
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};


    public static void bfs(){

        while(!q.isEmpty()){
            Pair obj = q.poll();

            for (int i = 0; i < 4; i++){
                int x = obj.x + dx[i];
                int y = obj.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (map[x][y] == 0) continue;
                if (visited[x][y]) continue;

                visited[x][y] = true;
                q.add(new Pair(x,y));
            }

        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Pair(0,0));

        bfs();

        if (visited[n-1][m-1]) {
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }
    }
}