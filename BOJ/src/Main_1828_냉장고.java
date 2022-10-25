import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	static class Pair implements Comparable<Pair> {

		int min_c;
		int max_c;

		public Pair(int min_c, int max_c) {
			this.min_c = min_c;
			this.max_c = max_c;
		}

		@Override
		public int compareTo(Pair p) {
			int diff = this.max_c - p.max_c;
			return diff != 0 ? diff : this.min_c- p.min_c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		Pair[] arr = new Pair[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int min_c = Integer.parseInt(st.nextToken());
			int max_c = Integer.parseInt(st.nextToken());

			arr[i] = new Pair(min_c, max_c);

		}

		Arrays.sort(arr); // 최저 온도 기준으로 정렬(오름차순)

		int maxNum = arr[0].max_c;
		int cnt=1;
		for (int i = 1; i < n; i++) {
			if(arr[i].min_c>maxNum) {
				cnt++;
				maxNum=arr[i].max_c;
			}
		}

		sb.append(cnt);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

}
