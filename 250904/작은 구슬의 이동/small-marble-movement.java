import java.util.Scanner;

public class Main {
    public static int N;

    public static int changeD(String D){
        if (D.equals("U")) return 0;
        if (D.equals("R")) return 1;
        if (D.equals("L")) return 2;
        if (D.equals("D")) return 3;
        return -1;
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //격자 크기
        int T = sc.nextInt(); //초
        int R = sc.nextInt() -1; //행
        int C = sc.nextInt() -1; //열
        String D = sc.next(); // 위치
        // Please write your code here.

        //int arr[][] = new int[N][N];
        int dx[]={-1,0,0,1};
        int dy[]={0,1,-1,0};
        int dir = changeD(D);

        for (int i = 1; i <= T; i++){ //1초부터 t초까지
            // 부딛힘 검사(다음 이동 시 충돌 여부) -> 부딪히면 방향 이동하고 continue
                //-> 안부딪히면 그대로 한 칸 이동하고 현재 좌표값 갱신
            
            int nx = R+ dx[dir];
            int ny = C+ dy[dir];

            if (!inRange(nx,ny)){
                dir = 3-dir;
                continue;
            }
            R = nx;
            C = ny;
        }

        R+=1;
        C+=1;

        // 출력 시 행/열에 1씩 더해주기
        System.out.println(R + " " + C);


    }
}