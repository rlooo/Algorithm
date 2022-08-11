import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		func(0);
	}

	private static void func(int r, int c, int cnt) {
		if (cnt == 0) {return;}
		
		int temp = arr[r - s][c - s];
		for (int i = r - s; i <= r + s; i++) { // 왼쪽 줄
			arr[i - 1][c - s] = arr[i][c - s];
		}
		for (int j = c - s + 1; j <= c + s; j++) { // 아랫줄
			arr[r + s][j - 1] = arr[r + s][j];
		}
		for (int i = r + s; i >= r - s + 1; i--) { // 오른쪽 줄
			arr[i][c + s] = arr[i - 1][c + s];
		}
		arr[r - s][c - s + 1] = temp;
		for (int j = c + s; j >= c - s + 3; j--) {// 윗 줄
			arr[r - s][j] = arr[r - s][j - 1];
		}

		for (int i = r - s; i <= r + s; i++) {
			for (int j = c - s; j <= c + s; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		func(r, c, s - 1);
	}

	}

}
