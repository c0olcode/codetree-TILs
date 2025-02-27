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
        Pair p1 = select_list.get(0);
        Pair p2 = select_list.get(1);

        int u_dist = (int)(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2));

        // 2. 최소 거리 업데이트 하기. 
        min_dist = Math.min(u_dist, min_dist); 
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