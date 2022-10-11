import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("res/Solution_4014_활주로건설.txt"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + test_case + " " + res + "\n");
        }

    }

}
