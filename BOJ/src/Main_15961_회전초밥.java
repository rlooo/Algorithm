import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] visited = new int[d + 1];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(in.readLine());
            arr[i] = input;
        }

        int max = 0;
        int cnt = 0;
        // 첫번째 구간의 값은 디폴트로 구해줌
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) {
                cnt++;

            }
            visited[arr[i]]++;
        }
        max = cnt;
        if (visited[c] == 0)
            max = max + 1;

        for (int i = 1; i < N; i++) {
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                cnt--;
            }
            if (visited[arr[(i + k - 1) % N]] == 0) {
                cnt++;
            }
            visited[arr[(i + k - 1) % N]]++;

            if (max <= cnt) {
                if (visited[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

        }

        sb.append(max);
        out.write(sb.toString());
        out.flush();
        out.close();

    }
}