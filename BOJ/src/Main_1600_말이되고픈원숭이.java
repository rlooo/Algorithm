import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static class Pair {
		int x;
		int y;
		int cnt;
		int k;

		Pair(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

	static int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1, 1,-1, 0, 0};
	static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2,0, 0, 1, -1};
	static boolean[][][] visited;
	static int[][] board;
	static int W, H, minMove;
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int K = Integer.parseInt(in.readLine()); // 말의 움직임으로 이동
		st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // 가로길이
		H = Integer.parseInt(st.nextToken()); // 세로길이
		board = new int[H][W];
		visited = new boolean[H][W][31];
		minMove = Integer.MAX_VALUE;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				int input = Integer.parseInt(st.nextToken());
				board[i][j] = input;
			}
		} // 입력

		visited[0][0][0] = true;

		bfs(K);
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(int K) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0, K));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			System.out.println(cur.x + " " + cur.y + " " + cur.cnt);
			if (cur.x == W - 1 && cur.y == H - 1) {

				sb.append(cur.cnt);
				return;
			}

			for (int dir = 0; dir < dx.length; dir++) {

				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= W || ny >= H)
					continue;

				if (board[nx][ny] == 1)
					continue;

				if (visited[nx][ny][cur.k] != false)
					continue;
				visited[nx][ny][cur.k] = true;
				
				if (dir > 7) {
					q.add(new Pair(nx, ny, cur.cnt + 1, cur.k));

				}
				if (cur.k == 0)
					continue;
				if (dir <= 7) {
					q.add(new Pair(nx, ny, cur.cnt + 1, cur.k - 1));

				}

			}

		}
//		sb.append(-1);

	}

}
