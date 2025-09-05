import java.util.Scanner;
public class Main {

    public static int Cdir(char dir){
        if (dir == 'N') return 0;
        else if(dir == 'E') return 1;
        else if(dir == 'S') return 2;
        else return 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        int x = 0;
        int y = 0;

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        int t = 0;

        roop1:
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int idir = Cdir(dir);

            for (int j =0; j < dist; j++){
                x = x + dx[idir];
                y = y + dy[idir];
                t++;

                if (x == 0 && y == 0){
                    System.out.println(t);
                    flag = true;
                    break roop1;
                }
            }   
        }

        if (!flag){
            System.out.println(-1);
        }
    }
}