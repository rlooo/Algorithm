import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static boolean[] isused;
	static int[] order;
	static int k;
	static int[][] cal;
	static int min_num = Integer.MAX_VALUE;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][m + 1];
		isused = new boolean[k + 1];
		order = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력

		cal = new int[k + 1][3];
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cal[i][j] = Integer.parseInt(st.nextToken());
			} // 연산정보 입력
		}
		func2(0, arr);

		System.out.println(min_num);

	}

	private static int[][] func(int r, int c, int s, int[][] arr) {
		if (s == 0) {
			return arr;
		}

		int temp = arr[r - s][c - s];
		for (int i = r - s; i < r + s; i++) { // 왼쪽 줄
			arr[i][c - s] = arr[i+1][c - s];
		}
		for (int j = c - s + 1; j <= c + s; j++) { // 아랫줄
			arr[r + s][j - 1] = arr[r + s][j];
		}
		for (int i = r + s; i >= r - s + 1; i--) { // 오른쪽 줄
			arr[i][c + s] = arr[i - 1][c + s];
		}
		
		for (int j = c + s; j >= c - s + 2; j--) {// 윗 줄
			arr[r - s][j] = arr[r - s][j - 1];
		}
		arr[r - s][c - s + 1] = temp;
	

		return func(r, c, s - 1, arr);
	}

	private static void func2(int cnt, int[][] arr) {
		if (cnt == k) {
			int[][] temp_arr = new int[n+1][m+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					temp_arr[i][j]=arr[i][j];
				}
			}
			for (int i = 0; i < cnt; i++) {
				temp_arr=func(cal[order[i]][0], cal[order[i]][1], cal[order[i]][2], temp_arr);

			}
			

			for (int x = 1; x <= n; x++) {
				int sum = 0;
				for (int y = 1; y <= m; y++) {
					sum += temp_arr[x][y];
				}
				if (min_num > sum) {
					min_num = sum;
				}
			}
			return;
		}
		for (int i = 1; i <= k; i++) {
			if (!isused[i]) {
				order[cnt] = i;
				isused[i] = true;
				func2(cnt + 1, arr);
				isused[i] = false;
			}
		}
	}

}
