import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Pair[] conv;
	static Pair start, destination;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(in.readLine());
			conv = new Pair[n];

			st = new StringTokenizer(in.readLine());
			start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				conv[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(in.readLine());
			destination = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			dist = new int[destination.x + 1][destination.y + 1];
			visited = new boolean[destination.x + 1][destination.y + 1];

			sb.append(bfs() == true ? "happy" : "sad");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static boolean bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(start.x, start.y));
		visited[start.x][start.y] = true;

		int death = 1000;
		while (!q.isEmpty()) {
			Pair cur = q.poll();

			if (dist[cur.x][cur.y] > death) {
				System.out.println("목말라죽음" + cur.x + " " + cur.y + " " + dist[cur.x][cur.y] + " " + death);
				return false;
			}

			if (cur.x == destination.x && cur.y == destination.y)
				return true;
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < start.x || ny < start.y || nx >= destination.x || ny >= destination.y)
					continue;

				if (visited[nx][ny] != false)
					continue;

				for (int i = 0; i < conv.length; i++) {
					if (nx == conv[i].x && ny == conv[i].y) {
						System.out.println("nx:" + nx + " " + "ny:" + ny + " " + dist[nx][ny] + " " + death);
						death = dist[cur.x][cur.y] + 1001;
					}
				}

				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				visited[nx][ny] = true;
				q.add(new Pair(nx, ny));

			}

		}
		return false;

	}
}
