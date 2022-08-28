import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	static int[][] board;
	static int[][] rupee;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int problem = 0;
		while (true) {
			n = Integer.parseInt(in.readLine());

			if (n == 0) {
				out.write(sb.toString());
				out.flush();
				out.close();
				return;
			}

			problem++;
			sb.append("Problem " + problem + ": ");

			board = new int[n][n];
			rupee = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = Integer.MAX_VALUE;
				}

			} // 입력

			rupee[0][0] = board[0][0];
			bfs(new Pair(0, 0));

			sb.append(rupee[n - 1][n - 1] + "\n");
		}

	}

	private static void bfs(Pair start) {

		Queue<Pair> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (rupee[nx][ny] <= rupee[cur.x][cur.y] + board[nx][ny])
					continue; // 최단거리가 아니면 큐에 담지 않는다

				rupee[nx][ny] = rupee[cur.x][cur.y] + board[nx][ny];
				q.add(new Pair(nx, ny));
			}

		}

	}

}
