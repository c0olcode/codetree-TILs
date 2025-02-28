import java.util.*;

public class Main {
    public static int n, people_cnt;
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};
    public static int grid[][];
    public static boolean visit[][];

    public static ArrayList<Integer> cnt_list = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visit[x][y] && (grid[x][y] == 1);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        people_cnt = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0], curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx, ny)) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    people_cnt++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (canGo(i, j)) {
                    bfs(i, j);
                    cnt_list.add(people_cnt);
                }
            }
        }

        Collections.sort(cnt_list);

        System.out.println(cnt_list.size());
        for (Integer value : cnt_list) {
            System.out.println(value);
        }
    }
}
