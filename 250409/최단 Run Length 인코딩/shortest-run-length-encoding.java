import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        // Please write your code here.

        int n = A.length();

        char pre_char = A.charAt(0); 
        int cnt = 0;
        int min_length = 100;

        for (int i = 0; i < n; i++){ // shift 횟수 : n만큼 돌게된다면 제자리 돌아와서 연산 한번 더함
            StringBuilder sb = new StringBuilder(); // 인코딩 결과 담을 sb

            for (int j = 0; j < n; j++){ // 문자열 탐색
                if (pre_char == A.charAt(j)){ // 연속된 문자열일 때
                    cnt++;
                }
                else{ // 연속된 문자열 아닐 때
                    sb.append(pre_char); 
                    sb.append(cnt);

                    pre_char = A.charAt(j);
                    cnt = 1;
                }
            }
            sb.append(pre_char);
            sb.append(cnt);
            
            // 최소 길이 구하기
            String temp = sb.toString(); // 인코딩 결과물
            min_length = Math.min(temp.length(), min_length);

            //System.out.println(i + "번째 temp.length() : " + temp.length() + ", temp : " + temp);

            // shift 하기
            StringBuilder sb2 = new StringBuilder(); // shift 결과물
            sb2.append(A.charAt(n-1)); 
            for (int j = 0; j < n-1; j++){
                sb2.append(A.charAt(j));
            }
            A = sb2.toString();

            // System.out.println(A);
        
        }
        
        System.out.println(min_length);

    }
}