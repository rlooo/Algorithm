import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2109_빵집 {

	static StringBuilder sb = new StringBuilder();
	static boolean[][] isVisited;
	static char[][] map;
	static int R;
	static int C;
	static int cnt = 0;
	static boolean flag = false;
	static int[] nx = { -1, 0, 1 };
	static int[] ny = { 1, 1, 1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		isVisited = new boolean[R][C];
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		} // 입력

		for (int i = 0; i < R; i++) {
			flag=false;
			DFS(i, 0);
		}

		sb.append(cnt);
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void DFS(int cur_x, int cur_y) {
		if (cur_y == C - 1) {
			cnt++;
			flag=true;
			return;
		}
		isVisited[cur_x][cur_y] = true;

		for (int dir = 0; dir < 3; dir++) {
			int next_x = cur_x + nx[dir];
			int next_y = cur_y + ny[dir];

			if (next_x >= 0 && next_y >= 0 && next_x < R && next_y < C) {
				if (map[next_x][next_y] == '.' && !isVisited[next_x][next_y]) {
					DFS(next_x, next_y);
					if(flag==true) return;

				}
			}
		}
		return;
	}

}
