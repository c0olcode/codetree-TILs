import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}

public class Main {
    public static int n,m;
    public static int min_dist = Integer.MAX_VALUE;

    public static ArrayList<Pair> point_list = new ArrayList<>();
    public static ArrayList<Pair> select_list = new ArrayList<>();

    public static void dist(){
        // 1. 유클리디안 거리 재기
        int max_dist = -1;
            // 이중 for문 돌려서 거리 하나씩 다 계산 하기
        for (int i = 0; i < m-1; i++){
            for (int j = 0; j < m; j++){
                Pair p1 = select_list.get(i);
                Pair p2 = select_list.get(j);
                int u_dist = (int)(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2));

                // 2. 최대 거리 업데이트 하기. 
                max_dist = Math.max(u_dist, max_dist); 
            }
        }

        min_dist = Math.min(max_dist, min_dist);
    }

    public static void combination(int index, int cnt){
        if (cnt == m){
            // 거리 재기 & 최소 거리 업데이트
            dist();
            return;
        }
        if (index == n) return;

        // 선택 o
        select_list.add(point_list.get(index));
        combination(index+1, cnt+1);
        select_list.remove(select_list.size()-1);

        // 선택 x
        combination(index+1, cnt);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point_list.add(new Pair(x,y));
        }

        combination(0,0);
        System.out.println(min_dist);
        
    }
}