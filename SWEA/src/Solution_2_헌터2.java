import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2_헌터2 {
	private static int N, minTime;
	private static boolean[][] visited;
	private static Pair hunter;
	private static Pair[] monsters, customers;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int dist(Pair p1, Pair p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	private static void dfs(Pair cur, int cntMonster, int cntCustomer, int monster_nums, int timeSum) {
		if (cntMonster == monster_nums && cntCustomer == monster_nums) {
			minTime = Math.min(minTime, timeSum);
			return;
		}
		for (int i = 1; i <= monster_nums; i++) {
			if (!visited[i][0]) {
				visited[i][0] = true;
				dfs(monsters[i], cntMonster + 1, cntCustomer, monster_nums,  timeSum+dist(cur, monsters[i]));
				visited[i][0] = false;
			}
			if (!visited[i][1] && visited[i][0]) {
				visited[i][1] = true;
				dfs(customers[i], cntMonster, cntCustomer + 1, monster_nums,  timeSum+dist(cur, customers[i]));
				visited[i][1] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());

			monsters = new Pair[5];
			customers = new Pair[5];
			hunter = new Pair(1, 1);
			minTime = Integer.MAX_VALUE;
			int monster_nums = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					int cur = Integer.parseInt(st.nextToken());

					if (cur > 0) {// 몬스터이면
						monsters[cur] = new Pair(i, j);
						monster_nums++;
					}
					if (cur < 0) { // 고객이면
						customers[cur * (-1)] = new Pair(i, j);
					}
				}
			} // 입력

			for (int i = 1; i <= monster_nums; i++) {
				visited = new boolean[monster_nums + 1][2]; // 첫번째는 몬스터 방문 배열, 두번째는 고객 방문 배열
				visited[i][0] = true;
				dfs(monsters[i], 1, 0, monster_nums, dist(hunter, monsters[i]));
			}
			sb.append("#" + tc + " " + minTime + "\n");

		}

		out.write(sb.toString());
		out.flush();
		out.close();

	}

}
