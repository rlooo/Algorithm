import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int m;
	static char[][] board;
	static boolean[][] w_visited;
	static boolean[][] b_visited;
	static int[] nx = { -1, 0, 1, 0 };
	static int[] ny = { 0, 1, 0, -1 };
	static int w_area;
	static int b_area;
	static int s_w;
	static int s_b;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 가로 크기
		m = Integer.parseInt(st.nextToken()); // 세로 크기

		board = new char[m][n];
		w_visited = new boolean[m][n];
		b_visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String str = in.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		bfs();
		sb.append(s_w + " " + s_b);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs() {
		Queue<Pair> w_q = new LinkedList<>();
		Queue<Pair> b_q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (board[i][j] == 'W') {
					if (w_visited[i][j] != true) {
						w_visited[i][j] = true;
						w_q.add(new Pair(i, j));

						w_area = 0;
						while (!w_q.isEmpty()) {
							w_area++;
							Pair cur = w_q.poll();

							for (int dir = 0; dir < 4; dir++) {
								Pair next = new Pair(cur.x + nx[dir], cur.y + ny[dir]);

								if (next.x < 0 || next.y < 0 || next.x >= m || next.y >= n
										|| w_visited[next.x][next.y] == true || board[next.x][next.y] != 'W')
									continue;

								w_visited[next.x][next.y] = true;
								w_q.add(next);
							}
						}
						s_w += w_area * w_area;

					}

				} else if (board[i][j] == 'B') {
					if (board[i][j] == 'B') {
						if (b_visited[i][j] != true) {
							b_visited[i][j] = true;
							b_q.add(new Pair(i, j));

							b_area = 0;
							while (!b_q.isEmpty()) {
								b_area++;
								Pair cur = b_q.poll();

								for (int dir = 0; dir < 4; dir++) {
									Pair next = new Pair(cur.x + nx[dir], cur.y + ny[dir]);

									if (next.x < 0 || next.y < 0 || next.x >= m || next.y >= n
											|| b_visited[next.x][next.y] == true || board[next.x][next.y] != 'B')
										continue;

									b_visited[next.x][next.y] = true;
									b_q.add(next);
								}
							}
							s_b += b_area * b_area;

						}
					}

				}

			}

		}

	}

}
