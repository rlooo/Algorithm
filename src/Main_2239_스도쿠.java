import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2239_스도쿠 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] arr = new int[9][9];
        int[][][] check = new int[9][9][9];

        for (int i = 0; i < 9; i++) {
            String str = in.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] != 0) {
                    check[i][j][arr[i][j] - 1]++;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (check[i][j][k] != 3) {

                    }
                }
            }
        }

    }

}
