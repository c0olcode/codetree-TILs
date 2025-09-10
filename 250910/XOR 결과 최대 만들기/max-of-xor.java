import java.util.*;

public class Main {
    public static int n,m;
    public static int A[];
    public static int max = Integer.MIN_VALUE;
    public static List<Integer> list = new ArrayList<>();

    public static void dfs(int index, int cnt){
        if (cnt == m){
            // xor 연산
            int value = list.get(0);

            for (int i =1; i < m; i++){
                value = value ^ list.get(i);
            }

            max = Math.max(value,max);
            return;
        }
        if (index == n) return;

        // 뽑
        list.add(index);
        dfs(index+1, cnt+1);
        list.remove(list.size()-1);

        // 안뽑
        dfs(index+1, cnt);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.
        dfs(0,0);

        System.out.println(max);

    }
}