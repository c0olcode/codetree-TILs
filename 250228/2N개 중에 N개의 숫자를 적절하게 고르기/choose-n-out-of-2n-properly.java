import java.util.*;
public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static int arr[];
    public static ArrayList<Integer> list = new ArrayList<>();

    public static int calc(){

        int select_cnt = 0;
        int unselect_cnt = 0;

        // 선택한 그룹의 합 구하기
        for (Integer value:list){
            select_cnt += arr[value];
        }

        // 선택 안한 그룹의 합 구하기
        for(int i = 0; i < 2*n; i++){
            if(!list.contains(i)) unselect_cnt+= arr[i];
        }

        // 두 그룹의 차이 구하기
        return Math.abs(select_cnt-unselect_cnt);
        

    }

    public static void dfs(int index, int cnt){
        if (cnt == n){
            // 최소합차 구하기
            ans = Math.min(calc(),ans);
            return;
        }
        if (index == 2*n) return;

        // 선택 o
        list.add(index);
        dfs(index+1, cnt+1);
        list.remove(list.size()-1);

        // 선택 x
        dfs(index+1, cnt);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        dfs(0,0);
        System.out.println(ans);
    }
}