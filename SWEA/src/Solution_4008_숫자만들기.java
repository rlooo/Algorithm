import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {

    static int[] num, isSelected;
    static int N;
    static int[] card = new int[4];
    static int min_res;
    static int max_res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            min_res = Integer.MAX_VALUE;
            max_res = Integer.MIN_VALUE;
            N = Integer.parseInt(in.readLine());

            isSelected = new int[N];
            num = new int[N];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 4; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            sb.append("#" + tc + " " + (max_res - min_res) + "\n");

        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void perm(int cnt) {

        if (cnt == N - 1) {
            int cal = num[0];
            for (int i = 1; i < N; i++) {
                if (isSelected[i - 1] == 0) {// +일 때
                    cal += num[i];
                } else if (isSelected[i - 1] == 1) { // - 일 때
                    cal -= num[i];
                } else if (isSelected[i - 1] == 2) { // * 일 때
                    cal *= num[i];
                } else { // /일 때
                    cal /= num[i];
                }
            }
            min_res = Integer.min(min_res, cal);
            max_res = Integer.max(max_res, cal);
            return;

        }

        for (int i = 0; i < 4; i++) {
            if (card[i] == 0)
                continue;
            card[i]--;
            isSelected[cnt] = i;
            perm(cnt + 1);
            card[i]++;
        }

    }

}
