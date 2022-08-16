import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑2 {

	private static class Tower {
		int h;
		int idx;

		public Tower(int h, int idx) {
			this.h = h;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Tower> s = new Stack<Tower>();

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine(), " ");

		int cur = Integer.parseInt(st.nextToken());
		s.push(new Tower(0, cur));
		sb.append(0 + " ");

		for (int i = 1; i < n; i++) {
			cur = Integer.parseInt(st.nextToken());
			if (!s.empty()) {
				while (s.peek().h < cur) {
					s.pop();
					if (s.empty()) {
						sb.append(0 + " ");
						s.push(new Tower(cur, i));
						continue;
					}
				}
			}
			if (!s.empty()) {
				if (s.peek().h > cur) {
					sb.append(s.peek().idx + 1 + " ");
				}
			}
			s.push(new Tower(cur, i));

		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

}