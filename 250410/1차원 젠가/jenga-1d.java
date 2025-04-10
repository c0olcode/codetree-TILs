import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 초기 블럭 수
        int[] blocks = new int[n];
        int last_index = n-1;

        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }

        for (int i =0; i < 2; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = 0; j <= last_index; j++){
                if(j >= s-1 && j <=e-1) continue;
                temp.add(blocks[j]);
            }

            last_index = temp.size()-1;

            for (int j = 0; j < temp.size(); j++){
                blocks[j] = temp.get(j);
            }

            //System.out.println(temp.toString());
        }

        System.out.println(last_index+1);
        for(int i =0; i <= last_index; i++){
            System.out.println(blocks[i]);
        }
    }
}