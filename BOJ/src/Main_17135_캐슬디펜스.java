import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

	static int n;
	static int m;
	static int d;
	static int[][] board;
	static boolean[] visited;
	static Set<Pair> set = new HashSet<Pair>();
	static int res = 0;
	static int enemy = 0;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 격자판 행의 수
		m = Integer.parseInt(st.nextToken()); // 열의 수
		d = Integer.parseInt(st.nextToken()); // 공격 거리 제한

		board = new int[n][m];
		visited = new boolean[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					enemy++;
				}
			}
		} // 입력

		// 궁수의 위치 정해주기 combination
		comb(0, 3);
		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void comb(int start, int cnt) { // mC3
		// 백트래킹 사용
		if (cnt == 0) {
			int temp_enemy = enemy;
			int[][] temp_board = new int[n][m];
			set.clear();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp_board[i][j] = board[i][j];
				}
			}
			int sum = 0;
			while (temp_enemy > 0) {

				for (int i = 0; i < m; i++) { // 궁수 3명 한 명씩 나옴
					if (visited[i] == true) {

						int min_dist = Integer.MAX_VALUE;
						int r = -1; // 적 인덱스
						int c = -1; // 적 인덱스

						// d계산
						for (int k = 0; k < n; k++) {
							for (int l = 0; l < m; l++) {
								if (temp_board[k][l] == 1) {
									// 적과의 거리 비교
									int dist = Math.abs(k - (n)) + Math.abs(l - i);
									if (dist <= d) { // 공격할 수 있음
										if (min_dist > dist) { // 공격할 수 있는 적 중 가장 가까운 적 구하기
											min_dist = dist;
											r = k;
											c = l;

										} else if (min_dist == dist) { // 공격할 수 있는 적이 여러명일 때
											// 가장 왼쪽 적 공격
											if (c > l) {
												r = k;
												c = l;

											}

										}

									}

								}
							}
						}
						if (r != -1 && c != -1) {
							set.add(new Pair(r, c));

						}

					}
				}

				// 모든 궁수의 공격이 끝남
				sum += set.size();
				
				for(Pair p:set) {
					temp_board[p.x][p.y] = 0; // 공격 받은 적 지움
					temp_enemy--;
				}
				
				set.clear();

				for (int l = 0; l < m; l++) {
					if (temp_board[n - 1][l] == 1) {
						temp_enemy--;
					}
				}

				// 살아남은 궁수들 한 칸 아래 이동
				for (int l = 0; l < m; l++) {
					for (int k = n - 1; k >= 1; k--) {
						temp_board[k][l] = temp_board[k - 1][l];
					}
				}
				for (int l = 0; l < m; l++) {
					temp_board[0][l] = 0;
				}

			}
			res = Math.max(res, sum);

			return;
		}

		for (int i = start; i < m; i++) {
			visited[i] = true;
			comb(i + 1, cnt - 1);
			visited[i] = false;
		}

	}

}
