import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAX_N = 20;

    public static int min = Integer.MAX_VALUE;

    public static char[][] map = new char[MAX_N][MAX_N];
    public static ArrayList<Pair> coinPos = new ArrayList<>();
    public static ArrayList<Pair> selectedPos = new ArrayList<>();

    public static Pair start;
    public static Pair end;

    public static int n;
    public static int m = 3;

    // 거리 계산
    public static int calc(Pair a, Pair b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static int dist(){
        // 처음 시작점에서 첫 번째 위치까지
        int value = calc(start, selectedPos.get(0));

        for (int i = 0; i < m-1; i++){
            value += calc(selectedPos.get(i), selectedPos.get(i+1));
        }
        // 마지막 동전에서 종착점까지
        value += calc(selectedPos.get(m-1), end);

        return value;
    }

    public static void findMinMoves(int index, int cnt){
        if (cnt == m){
            // 탐색 끝났으니 조합된 위치 가지고 이동 거리 구하기

            min = Math.min(min, dist());

            return;
        }

        if (index == coinPos.size()){
            // 주어진 동전을 끝까지 탐색했으므로 탐색 종료
            return;
        }

        // 파라미터로 주어진 인덱스를 탐색하지 않는 경우
        findMinMoves(index + 1, cnt);

        // 파라미터로 주어진 인덱스를 탐색하는 경우
        selectedPos.add(coinPos.get(index));
        findMinMoves(index + 1, cnt + 1);
        selectedPos.remove(selectedPos.size()-1);

        
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 맵 초기화
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    start = new Pair(i,j);
                }
                else if(map[i][j] == 'E'){
                    end = new Pair(i,j);
                }
            }
        }   

        // 동전 숫자 순서대로 coinPos에 담기
        for (int num = 1; num <= 9; num++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (num == map[i][j] - '0'){
                        coinPos.add(new Pair(i,j));
                    }
                }
            }
        }

        if (coinPos.size() <= 2){
            System.out.print(-1);
            return;
        }

        // 백트래킹으로 조합해서 찾기 (인덱스 번호, cnt)
        findMinMoves(0,0);

        System.out.print(min);



    }
}