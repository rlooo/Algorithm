
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		int[][] sum_arr = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum_arr[i][j] = sum_arr[i-1][j]+sum_arr[i][j-1]-sum_arr[i-1][j-1]+arr[i][j];
			}
		}

		int x1, y1, x2, y2;

		for (int k = 1; k <= m; k++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			System.out.println(sum_arr[x2][y2]-sum_arr[x1-1][y2]-sum_arr[x2][y1-1]+sum_arr[x1-1][y1-1]);
			

		}
	}
}