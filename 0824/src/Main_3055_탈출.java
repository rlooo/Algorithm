import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static int[] nx = { 0, 0, -1, 1 };
	static int[] ny = { -1, 1, 0, 0 };
	static int[][] visited_d;
	static int[][] visited_w;
	static char[][] arr;
	static int R, C;
	static StringBuilder sb = new StringBuilder();

	static ArrayList<Pair> start_w = new ArrayList<>();

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

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited_d = new int[R][C];
		visited_w = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // 입력

		Pair start_d = null;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'S') {
					start_d = new Pair(i, j);
				}
				if (arr[i][j] == '*') {
					start_w.add(new Pair(i, j));
				}
			}
		}
		bfs(start_d, start_w);

		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs(Pair start_d, ArrayList<Pair> start_w) {
		boolean flag = false;
		Queue<Pair> qd = new LinkedList<>();
		Queue<Pair> qw = new LinkedList<>();

		qd.add(start_d);
		visited_d[start_d.x][start_d.y] = 1;

		for (int i = 0; i < start_w.size(); i++) {
			qw.add(start_w.get(i));
			visited_w[start_w.get(i).x][start_w.get(i).y] = 1;
		}

		while (!qw.isEmpty()) {
			for (int q = 1; q <= qw.size(); q++) {
				Pair cur_w = qw.poll();

				for (int dir = 0; dir < 4; dir++) {
					Pair next_w = new Pair(cur_w.x + nx[dir], cur_w.y + ny[dir]);

					if (next_w.x < 0 || next_w.y < 0 || next_w.x >= R || next_w.y >= C
							|| visited_w[next_w.x][next_w.y] > 0)
						continue;

					if (arr[next_w.x][next_w.y] == '.') {
						visited_w[next_w.x][next_w.y] = visited_w[cur_w.x][cur_w.y] + 1;
						qw.add(next_w);
					}

				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						System.out.print(visited_w[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
		}

		while (!qd.isEmpty()) {
			Pair cur_d = qd.poll();
			System.out.println(cur_d.x + " " + cur_d.y);
			for (int dir = 0; dir < 4; dir++) {
				Pair next_d = new Pair(cur_d.x + nx[dir], cur_d.y + ny[dir]);

				if (next_d.x < 0 || next_d.y < 0 || next_d.x >= R || next_d.y >= C || arr[next_d.x][next_d.y] == 'X')
					continue;

				if (visited_w[next_d.x][next_d.y] <= visited_d[next_d.x][next_d.y] && arr[next_d.x][next_d.y] != 'D'
						&& visited_d[next_d.x][next_d.y] != 0)
					continue;

				visited_d[next_d.x][next_d.y] = visited_d[cur_d.x][cur_d.y] + 1;
				qd.add(next_d);

				if (arr[next_d.x][next_d.y] == 'D') {
					sb.append(visited_d[next_d.x][next_d.y] - 1);

					return;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(visited_d[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

		}

		sb.append("KAKTUS");

	}

}
