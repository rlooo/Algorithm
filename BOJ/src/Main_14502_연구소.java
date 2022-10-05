import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int[][] map;
	static int[][] temp_map;
	static int N, M;
	static List<Pair> empty_list = new ArrayList<>();
	static List<Pair> virus_list = new ArrayList<>();
	static Pair[] selected;
	static boolean[] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int res = 0;
	static int temp = 0;

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

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp_map = new int[N][M];
		selected = new Pair[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp_map[i][j] = map[i][j];
				if (map[i][j] == 0) {
					empty_list.add(new Pair(i, j));
				}
				if (map[i][j] == 2) {
					virus_list.add(new Pair(i, j));
				}
			}
		}
		visited = new boolean[empty_list.size()];

		comb(0, 0);

		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			temp++;
			for (int i = 0; i < 3; i++) {
				map[selected[i].x][selected[i].y] = 1;
			}

			for (int i = 0; i < virus_list.size(); i++) {
				bfs(virus_list.get(i));
			}

			int safe_area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						safe_area++;
					}
				}
			}

			res = Math.max(safe_area, res);

			for (int i = 0; i < 3; i++) {
				map[selected[i].x][selected[i].y] = 0;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = temp_map[i][j];
				}

			}
			return;
		}

		for (int i = start; i < empty_list.size(); i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			selected[cnt] = empty_list.get(i);
			comb(cnt + 1, i + 1);
			visited[i] = false;
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

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (map[nx][ny] == 1 || map[nx][ny] == 2)
					continue;

				map[nx][ny] = 2;
				q.add(new Pair(nx, ny));

			}

		}

	}
}
