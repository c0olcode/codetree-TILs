import java.util.*;


class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N;
    public static int ans = Integer.MAX_VALUE;
    public static ArrayList<Pair> list = new ArrayList<>();
    public static ArrayList<Pair> select_list = new ArrayList<>();
    public static char grid[][];


    public static Pair start;
    public static Pair end;

    public static int dist(Pair a, Pair b){
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
    }

    public static int calc(){
        int d = 0;

        // 시작점과 첫번째 점
        d += dist(start, select_list.get(0));

        // 1-2, 2-3 점
        d += dist(select_list.get(0), select_list.get(1));
        d += dist(select_list.get(1), select_list.get(2));

        // 세번째 점과 마지막 점
        d += dist(select_list.get(2), end);

        return d;
    }



    public static void dfs(int index, int cnt){
        // cnt == 3 이면 거리 구하기
        if(cnt == 3){
            // 거리 구하기
            ans = Math.min(ans, calc());
            return;
        }
        // index 범위 초과했다면 return
        if (index >= list.size()) return;


        // 선택 O
        select_list.add(list.get(index));
        dfs(index+1, cnt+1);
        select_list.remove(select_list.size()-1);

        // 선택 X
        dfs(index+1, cnt);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        grid = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
                if(grid[i][j] == 'S')
                    start = new Pair(i, j);
                if(grid[i][j] == 'E')
                    end = new Pair(i, j);
            }
        }

        // 동전을 오름차순으로 각 위치 집어넣기 (Pair를 입력하는 것이기에 sort 안돼서 반복문 복잡하게 함)
        for (int num = 1; num <= 9; num++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (num + ''== grid[i][j]){
                        list.add(new Pair(i,j));
                    }
                }
            }
        }

        // for (int i = 0; i < list.size(); i++){
        //     Pair p = list.get(i);
        //     System.out.println(p.x + " " + p.y);
        // }

        if (list.size() <= 2) {
            System.out.println(-1);
            return;
        }
        
        dfs(0,0);
        System.out.println(ans);


        // Please write your code here.

        // 숫자 입력 받을 때, list에 넣고 sort 하기
        // list size가 3 미만이면 바로 -1 return
        // list 가지고 dfs 수행하기 
            // 순서대로 조합 완성됐으면, 이동하면서 이동거리 구하기 or 완성 전에 바로 이동거리 구하기.
            // 구한 이동거리 중 최소 값 업데이트

        
    }
}