import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2239_스도쿠 {
    static int cnt = 0;
    static int[][] a;
    static boolean[][] c;
    static boolean[][] c2;
    static boolean[][] c3;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        a = new int[10][10];
        c = new boolean[10][10];
        c2 = new boolean[10][10];
        c3 = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            String str = in.readLine();
            for (int j = 0; j < 9; j++) {
                a[i][j] = str.charAt(j) - '0';
                if (a[i][j] != 0) {
                    c[i][a[i][j]] = true;
                    c2[j][a[i][j]] = true;
                    c3[square(i, j)][a[i][j]] = true;
                }
            }
        }
        go(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static boolean go(int z) {
        cnt += 1;
        if (cnt >= 10000000)
            return true;
        if (z == 81) {

            return true;
        }
        int x = z / 9;
        int y = z % 9;
        if (a[x][y] != 0) {
            return go(z + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (c[x][i] == false && c2[y][i] == false && c3[square(x, y)][i] == false) {
                    c[x][i] = c2[y][i] = c3[square(x, y)][i] = true;
                    a[x][y] = i;
                    if (go(z + 1)) {
                        return true;
                    }
                    a[x][y] = 0;
                    c[x][i] = c2[y][i] = c3[square(x, y)][i] = false;
                }
            }
        }

        return false;
    }

    static int square(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

}
