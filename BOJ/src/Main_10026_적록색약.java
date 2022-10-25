import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10026_적록색약 {
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;
	static boolean[][] dist;
	static int cnt = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		arr = new char[N][N];
		dist = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // 입력

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'R') {
					bfs(new Pair(i, j), (int) 'R');
				}
				if (arr[i][j] == 'G') {
					bfs(new Pair(i, j), (int) 'G');
				}
				if (arr[i][j] == 'B') {
					bfs(new Pair(i, j), (int) 'B');
				}
			}
		}
		sb.append(cnt+" ");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j]=false;																			
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		cnt = 0;
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B') {
					bfs(new Pair(i, j), (int) 'B');
				}
				if (arr[i][j] == 'R') {
					bfs(new Pair(i, j), (int) 'R');
				}
			}
		}
		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(Pair p, int color) {
		if (dist[p.x][p.y] != false) {
			return;
		}

		Queue<Pair> q = new LinkedList<>();
		q.add(p);
		dist[p.x][p.y] = true;
		cnt++;

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || dist[nx][ny] != false || arr[nx][ny] != (char) color)
					continue;

				dist[nx][ny] = true;
				q.add(new Pair(nx, ny));

			}

		}

	}

}
