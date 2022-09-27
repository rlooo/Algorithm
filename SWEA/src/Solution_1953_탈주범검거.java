import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int res;
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우
	static int[][] dist;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/Solution_1952_수영장.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			dist = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = -1; // -1로 초기화
				}
			}
			bfs();

			sb.append("#" + test_case + " " + res + "\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(R, C)); // 맨홀뚜껑부터 시작
		dist[R][C] = 0;

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				if (map[cur.x][cur.y] == 2) {// 좌우 안됨
					if (dir == 2 || dir == 3)
						continue;
				} else if (map[cur.x][cur.y] == 3) { // 상하 안됨
					if (dir == 0 || dir == 1)
						continue;
				} else if (map[cur.x][cur.y] == 4) { // 좌하 안됨
					if (dir == 1 || dir == 2)
						continue;
				} else if (map[cur.x][cur.y] == 5) { // 상좌 안됨
					if (dir == 0 || dir == 2)
						continue;
				} else if (map[cur.x][cur.y] == 6) {// 상우 안됨
					if (dir == 0 || dir == 3)
						continue;
				} else if (map[cur.x][cur.y] == 7) {// 하우 안됨
					if (dir == 1 || dir == 3)
						continue;
				}

				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (dist[nx][ny] != -1)
					continue;

				if (map[nx][ny] == 0)
					continue;

				// 여기가 문제임
				if (dir == 0) { // 상일경우
					if (map[nx][ny] != 1 && map[nx][ny] != 2 && map[nx][ny] != 5 && map[nx][ny] != 6)
						continue;
				} else if (dir == 1) { // 하일경우
					if (map[nx][ny] != 1 && map[nx][ny] != 2 && map[nx][ny] != 4 && map[nx][ny] != 7)
						continue;
				} else if (dir == 2) { // 좌일경우
					if (map[nx][ny] != 1 && map[nx][ny] != 3 && map[nx][ny] != 4 && map[nx][ny] != 5)
						continue;
				} else if (dir == 3) { // 우일경우
					if (map[nx][ny] != 1 && map[nx][ny] != 3 && map[nx][ny] != 6 && map[nx][ny] != 7)
						continue;
				}

				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				q.add(new Pair(nx, ny));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (dist[i][j] < L && dist[i][j] != -1) {
					res++;
				}
			}

		}

	}

}
