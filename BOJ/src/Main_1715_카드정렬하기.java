import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1715_카드정렬하기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(in.readLine()));
        }

        int sum = 0;
        while (q.size() > 1) {
            int a = q.poll();
            sum += a;

            int b = q.poll();
            sum += b;
            q.add(a + b);
        }
        sb.append(sum);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

}
