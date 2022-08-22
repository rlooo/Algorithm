import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기 {
	static int[] nx = { -1, 0, 1, 0 };
	static int[] ny = { 0, 1, 0, -1 };
	static int[][] board;
	static HashSet<String> ts;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			ts = new HashSet<>();
			board = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					dfs(i, j, 0, "" + board[i][j]);
				}
			}
			sb.append(ts.size()+"\n");

		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(int x, int y, int cnt, String str) {
		if (cnt == 6) {
			ts.add(str);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int next_x = x + nx[dir];
			int next_y = y + ny[dir];
			if (next_x < 0 || next_y < 0 || next_x >= 4 || next_y >= 4)
				continue;

			dfs(next_x, next_y, cnt + 1, str+ board[next_x][next_y]);

		}

	}

}
