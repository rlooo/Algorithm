import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이차원 배열을 돌리면 인덱스 실수가 많이 생김
// 배열 돌리기 같은 문제는 이 방법이 실수가 덜 생김

public class Main_16926_배열돌리기1 {
	static int n, m, r;
	static int[][] arr;
	static int[] directionX = { 0, 1, 0, -1 };
	static int[] directionY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int s = Math.min(n, m) / 2; // 회전하는 사각형의 개수
		for (int i = 0; i < r; i++) {
			rotate(s);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

	private static void rotate(int s) {
		for (int i = 0; i < s; i++) {
			int direction = 0; // 방향
			int sx = i;
			int sy = i;
			int temp = arr[sx][sy];
			while (direction < 4) {
				int nx = sx + directionX[direction];
				int ny = sy + directionY[direction];

				// 사각형을 벗어나지 않으면 계속 진행
				if (nx < i || ny <= i || nx >= n - i || ny >= m - i) {
					direction++;
					continue;
				}
				arr[sx][sy] = arr[nx][ny];
				sx = nx;
				sy = ny;

			}
			arr[i+1][i]=temp;
		}

	}
}
