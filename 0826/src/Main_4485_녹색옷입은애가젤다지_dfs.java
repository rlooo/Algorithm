import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지_dfs {
	//dfs로 풀면 시간초과가 난다 ~~
	static int[][] board;
	static int[][] rupee;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int problem=1;
		while (true) {
			n = Integer.parseInt(in.readLine());
			
			sb.append("Problem "+problem+": ");
			
			if(n==0) {
				
				return;
			}
			
			res = Integer.MAX_VALUE;
			board = new int[n][n];
			rupee = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}

			} // 입력
			
			rupee[0][0] = board[0][0];
			dfs(0, 0);
			sb.append(res+" ");
			out.write(sb.toString());
			out.flush();
			out.close();

		}

		
	}

	private static void dfs(int x, int y) {

		if (x == n - 1 && y == n - 1) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(rupee[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			res = Math.min(res, rupee[x][y]);
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (rupee[nx][ny] > 0)
				continue;

			rupee[nx][ny] = rupee[x][y] + board[nx][ny];
			dfs(nx, ny);
			rupee[nx][ny] = 0;

		}

	}

}
