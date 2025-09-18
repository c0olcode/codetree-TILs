import java.util.*;

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[][] grid;
    public static Pair start;
    public static Pair end;
    public static ArrayList<Pair> list = new ArrayList<>();
    public static ArrayList<Pair> s_list = new ArrayList<>();

    public static void calcDist(){
        // 시작점 -> 1번 거리
        Pair one = s_list.get(0);
        int dist = Math.abs(start.x - one.x) + Math.abs(start.y - one.y);

        // 1-> 2번 , 2->3번, 3-> 끝점
        Pair two = s_list.get(1);
        Pair three = s_list.get(2);
        dist += Math.abs(two.x - one.x) + Math.abs(two.y - one.y);
        dist += Math.abs(two.x - three.x) + Math.abs(two.y - three.y);
        dist += Math.abs(end.x - three.x) + Math.abs(end.y - three.y);

        min = Math.min(min, dist);
    }


    public static void dfs(int index, int cnt){{
        if (cnt == 3){
            // 거리 측정하기
            calcDist();
            return;
        }
        if (index >= list.size()) return;

        // 뽑
        s_list.add(list.get(index));
        dfs(index+1, cnt+1);
        s_list.remove(s_list.size()-1);

        // 안뽑
        dfs(index+1, cnt);
    }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];
        int cnt = 0;
    
        for (int i = 0; i < N; i++) {
            String value = sc.next();
            for (int j = 0; j < N; j++){
                char ch = value.charAt(j);

                if (ch == 'S'){
                    start = new Pair(i,j);
                }
                else if (ch == 'E'){
                    end = new Pair(i,j);
                }
                else if (ch == '.'){
                    continue;
                }
                else{
                    grid[i][j] = ch - '0';
                    list.add(new Pair(i,j));
                    cnt++;
                }
            }
        }

        // list 정렬하기
        Collections.sort(list, ((a,b) -> grid[a.x][a.y] - grid[b.x][b.y]));

        if (cnt <=2) {
            System.out.println(-1);
            return;
        }

        dfs(0,0);

        System.out.println(min);



        // 

        // for (int i = 0; i < N; i++){
        //     for (int j = 0; j < N; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}