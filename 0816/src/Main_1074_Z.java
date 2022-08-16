import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1074_Z {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		sb.append(func(N, r, c));
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static int func(int n, int r, int c) {
		if (n == 1) {
			if (r == 0 && c == 0)
				return 0;
			else if (r == 0 && c == 1)
				return 1;
			else if (r == 1 && c == 0)
				return 2;
			else
				return 3;
		}

		int half = (int) Math.pow(2, n - 1);

		// 1번 사각형
		if (r < half && c < half) {
			return func(n - 1, r, c);
		}
		// 2번 사각형
		else if (r < half && c >= half) {
			return half * half + func(n - 1, r, c - half);
		}
		// 3번 사각형
		else if (r >= half && c < half) {
			return 2 * half * half + func(n - 1, r - half, c);
		}
		// 4번 사각형
		else {
			return 3 * half * half + func(n - 1, r - half, c - half);
		}

	}

}
