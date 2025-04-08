import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        ArrayList<Integer> top = new ArrayList<>();
        ArrayList<Integer> bottom = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            top.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            bottom.add(sc.nextInt());
        }
        
        for (int i = 0; i < t; i++){
            int temp1 = top.get(top.size()-1);
            top.remove(top.size()-1);

            int temp2 = bottom.get(bottom.size()-1);
            bottom.remove(bottom.size()-1);

            bottom.add(0,temp1);
            top.add(0,temp2);
        }

        for (int i = 0; i<n; i++){
            System.out.print(top.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i<n; i++){
            System.out.print(bottom.get(i) + " ");
        }
    }
}