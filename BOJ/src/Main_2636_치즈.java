import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static boolean[][] air;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] pan;
	static int H, W, airCnt;
	static List<Pair> cheeze;

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
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		pan = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if (pan[i][j] == 0) {
					airCnt++;
				}
			}
		}

		int totalCnt = H * W;
		int time = 0;

		while (airCnt != totalCnt) {
			air = new boolean[H][W];
			cheeze = new LinkedList<>();
			bfs(pan);
			for (int i = 0; i < cheeze.size(); i++) {
				pan[cheeze.get(i).x][cheeze.get(i).y] = 0;
				airCnt++;
			}
			time++;

		}

		sb.append(time + "\n" + cheeze.size() + "\n");
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs(int[][] pan) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, 0));
		air[0][0] = true;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;
				if (air[nx][ny] != false)
					continue;
				air[nx][ny] = true;
				if (pan[nx][ny] == 1) {
					cheeze.add(new Pair(nx, ny));
				} else {
					q.add(new Pair(nx, ny));
				}

			}
		}

	}

}
