import java.util.*;

public class Main {
    public static int n,m;
    public static ArrayList<Integer> combination = new ArrayList<>();

    public static void printCombination(){
        for (int i = 0; i < combination.size(); i++){
            System.out.print(combination.get(i) + " ");
        }
        System.out.println();
    }

    public static void findCombination(int num, int cnt){
        // 숫자 n에 도달했으면 더 이상 탐색 x
        if (num > n){
            // cnt가 m이면 출력
            if(cnt == m){
                printCombination();
            }
            return;
        }

        // num에 해당하는 숫자 사용했을 때의 경우
        combination.add(num);
        findCombination(num+1, cnt+1);
        combination.remove(combination.size()-1);

        // num 사용 안했을 때
        findCombination(num+1, cnt);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        
        findCombination(1,0); 
    }
}