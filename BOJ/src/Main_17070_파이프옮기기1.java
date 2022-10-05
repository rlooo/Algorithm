import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int[][] map;
	static boolean[][][] visited;
	static int res = 0;
	static int N;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	static class Pipe {
		int state; // 오른족: 0, 아래: 1, 오른쪽 아래 : 2
		int x;
		int y;

		Pipe(int s, int x, int y) {
			state = s;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[3][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		} // 입력

		visited[0][0][1] = true;
		dfs(new Pipe(0, 0, 1));

		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void dfs(Pipe cur) {

		if (cur.x == N - 1 && cur.y == N - 1) {
			res++;

			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			int nextState;
			if (cur.state == 0) {

				if (dir == 1)
					continue;
			} else if (cur.state == 1) {
				if (dir == 0)
					continue;
			}

			nextState = dir;

			int nx = cur.x + dx[dir];
			int ny = cur.y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (map[nx][ny] == 1)
				continue;
			if (nextState == 2) {
				if (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)
					continue;
			}

			if (visited[nextState][nx][ny] == true)
				continue;
			visited[nextState][nx][ny] = true;
			dfs(new Pipe(nextState, nx, ny));
			visited[nextState][nx][ny] = false;

		}

	}

}
