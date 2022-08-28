import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	public static class Coordinate {
		char type; // 사용자 : a/b , bc : c, bc의 범위 :r
		int t; // 사용자 : 시간, bc : -1
		int c; // 사용자: -1, bc : 충전 범위
		int p; // 사용자 :-1, bc : 성능

		Coordinate() {

		}

		Coordinate(char type, int t, int c, int p) {
			this.type = type;
			this.t = t;
			this.c = c;
			this.p = p;
		}
	}

	static ArrayList<Coordinate>[][] arr = new ArrayList[11][11];;
	static boolean[][] isused = new boolean[11][11];
	static int[] nr = { -1, 0, 0, 1 };
	static int[] nc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine(), " ");

			int cur_x = 1;
			int cur_y = 1;

			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					arr[i][j] = new ArrayList();
				}
			}

			for (int i = 0; i < M; i++) {

				int input = Integer.parseInt(st.nextToken());
				Coordinate a = new Coordinate('a', i, -1, -1);
				if (input == 0) {
					arr[cur_x][cur_y].add(a);
				} else if (input == 1) {
					arr[--cur_x][cur_y].add(a);
				} else if (input == 2) {
					arr[cur_x][++cur_y].add(a);
				} else if (input == 3) {
					arr[++cur_x][cur_y].add(a);
				} else {
					arr[cur_x][--cur_y].add(a);
				}
			} // a의 정보

			st = new StringTokenizer(in.readLine(), " ");

			cur_x = 10;
			cur_y = 10;
			for (int i = 0; i < M; i++) {

				int input = Integer.parseInt(st.nextToken());
				Coordinate b = new Coordinate('b', i, -1, -1);

				if (input == 0) {
					arr[cur_x][cur_y].add(b);
				} else if (input == 1) {
					arr[--cur_x][cur_y].add(b);
				} else if (input == 2) {
					arr[cur_x][++cur_y].add(b);
				} else if (input == 3) {
					arr[++cur_x][cur_y].add(b);
				} else {
					arr[cur_x][--cur_y].add(b);
				}
			} // b의 정보

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				Coordinate bc = new Coordinate('c', -1, c, p);
				arr[x][y].add(bc);
				isused[x][y] = true;

				func(x, y, x, y);

			} // bc의 정보, br의 정보

			for(int i=1;i<=10;i++) {
				for(int j=1;j<=10;j++) {
					if(!arr[i][j].isEmpty()) {
						for(int k=0;k<arr[i][j].size();k++) {
							
						}
					}
				}
			}
			
			
			
			

		}

	}

	private static void func(int r, int c, int x, int y) {

		if ((Math.abs(x - r) + Math.abs(y - c)) >= arr[x][y].get(0).c)
			return;

		int temp_r = r;
		int temp_c = c;

		for (int dir = 0; dir < 4; dir++) {

			int next_r = temp_r + nr[dir];
			int next_c = temp_c + nc[dir];

			if (next_r < 1 || next_c < 1 || next_r > 10 || next_c > 10 || isused[next_r][next_c] == true)
				continue;
			
			
			
			Coordinate br = new Coordinate('r', -1, -1, arr[x][y].get(0).p);
			arr[next_r][next_c].add(br);

			isused[next_r][next_c] = true;
			func(next_r, next_c, x, y);
		}
	}

}
