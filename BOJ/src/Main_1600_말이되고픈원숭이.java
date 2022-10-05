import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static int[][] map;
	static int[][][] dist;
	static int K, W, H;
	static int res = Integer.MAX_VALUE;
	static int mx[] = { 0, 0, -1, 1 };
	static int my[] = { -1, 1, 0, 0 };
	static int[] hx = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] hy = { -2, -2, -1, -1, 1, 1, 2, 2 }; // 말 이동

	static class Pair {
		int x;
		int y;
		int h;

		Pair(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		K = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		dist = new int[K + 1][H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(res==Integer.MAX_VALUE) {
			res=-1;
		}
		else {res=res-1;}
		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, K));
		dist[K][0][0] = 1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {

				int nx = cur.x + mx[dir];
				int ny = cur.y + my[dir];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (dist[cur.h][nx][ny] != 0)
					continue;

				dist[cur.h][nx][ny] += dist[cur.h][cur.x][cur.y] + 1;
				q.add(new Pair(nx, ny, cur.h));

			}
			if (cur.h > 0) {

				for (int dir = 0; dir < 8; dir++) {

					int nx = cur.x + hx[dir];
					int ny = cur.y + hy[dir];

					if (nx < 0 || ny < 0 || nx >= H || ny >= W)
						continue;

					if (map[nx][ny] == 1)
						continue;

					if (dist[cur.h - 1][nx][ny] != 0)
						continue;

					dist[cur.h - 1][nx][ny] += dist[cur.h][cur.x][cur.y] + 1;
					q.add(new Pair(nx, ny, cur.h - 1));
				}

			}

			for (int i = 0; i < K + 1; i++) {
				if (dist[i][H - 1][W - 1] != 0) {
					res = Math.min(res, dist[i][H - 1][W - 1]);
				}
			}

		}

	}

}
