import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        // Please Write your code.

        int x = 0;
        int y = 0;
        int n = commands.length();
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int result = -1;
        int t = 0;
        int dir = 0;

        for (int i = 0; i < n; i++){
            if (commands.charAt(i) == 'F'){
                x += dx[dir];
                y += dy[dir];
            }
            else if (commands.charAt(i) == 'L'){
                dir = (dir+3) % 4;
            }
            else{
                dir = (dir+1) % 4;
            }

            t++;

            if (x == 0 && y == 0){
                result = t;
                break;
            }
        }

        System.out.println(t);
    }
}