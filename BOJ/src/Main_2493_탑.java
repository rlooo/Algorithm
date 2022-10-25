import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
// 틀림
public class Main_2493_탑{
	private static class Tower{
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

		for (int i = 1; i <= n; i++) {
			int cur = Integer.parseInt(st.nextToken());

			while(!s.isEmpty()) {
				if (s.peek().h < cur) {
					s.pop();
				}else  {
					sb.append(s.peek().idx + " ");
					break;
				}
			}

			if (s.isEmpty()) {
				sb.append(0 + " ");
			}
            
			s.push(new Tower(cur, i));
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}