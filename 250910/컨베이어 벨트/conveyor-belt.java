import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        // Please write your code here.

        for (int i =1; i <= t; i++){
            // 각자 temp 저장
            int temp1 = top[n-1];
            int temp2 = bottom[n-1];

            // 칸 이동
            for (int k = n-2; k >= 0; k--){
                top[k+1] = top[k];
                bottom[k+1] = bottom[k];
            }
            top[0] = temp2;
            bottom[0] = temp1;
        }

        for (int i =0; i < n; i++){
            System.out.print(top[i] + " ");
        }
        System.out.println();

        for (int i =0; i < n; i++){
            System.out.print(bottom[i] + " ");
        }
    }
}