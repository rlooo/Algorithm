import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1_낚시터자리잡기 {

	static int n;
	static int res = Integer.MAX_VALUE;

	static class Pair {
		int ent;
		int num;

		Pair(int ent, int num) {
			this.ent = ent;
			this.num = num;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(in.readLine()); // 낚시터 자리 개수
			int[] visited = new int[n + 1]; // 낚시터 배열(1-index)

			Pair[] entrance = new Pair[3];
			Pair[] order = new Pair[3];
			boolean[] visited_ent = new boolean[3];

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int ent = Integer.parseInt(st.nextToken()); // 출입구의 위치
				int num = Integer.parseInt(st.nextToken()); // 낚시꾼들의 수

				entrance[i] = new Pair(ent, num);
			}

			// 순열로 출입구 선택 순서 만들기
			perm(entrance, order, visited_ent, 0, visited);

			sb.append("#" + test_case + " " + res + "\n");
			out.write(sb.toString());
			out.flush();
			out.close();

		}

	}

	private static void perm(Pair[] entrance, Pair[] order, boolean[] visited_ent, int depth, int[] visited) {
		if (depth == entrance.length) {
			Arrays.fill(visited, 0);
			func(order, 0, visited); // 출입구선택순서 가지고
			return;
		}
		for (int i = 0; i < entrance.length; i++) {
			if (visited_ent[i] != false)
				continue;
			visited_ent[i] = true;
			order[depth] = entrance[i];
			perm(entrance, order, visited_ent, depth + 1, visited);
			visited_ent[i] = false;
		}

	}

	private static void func(Pair[] order, int index, int[] visited) {

//		if (index == order.length) { // 입구 모두 클리어
		if (index == 1) { // 입구 2개 클리어
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += visited[i];

			}
			System.out.println(sum);
//			res = Math.min(res, sum);
			return;

		}
		int temp_num = order[index].num; // 해당 출입구의 사람 수

		int s1 = order[index].ent;
		int s2 = order[index].ent;

		while (temp_num > 0) {
			// 남은 사람이 한명이고 같은 거리의 빈자리가 두 곳 있을 때
			System.out.println(s1 + " " + s2 + " " + temp_num);
			if (temp_num == 1 && visited[s1] == 0 && visited[s2] == 0
					&& ((Math.abs(s1 - order[index].ent) + 1) == (Math.abs(s2 - order[index].ent) + 1))) {

				break;

			}

			if (visited[s1] == 0 && s1 > 0) { // 사람이 배정될 수 있는 경우
				visited[s1] = Math.abs(s1 - order[index].ent) + 1;
				temp_num--;
				s1--;
			} else {
				if (s1 > 0) {// 범위 체크
					s1--;
				}
			}

			if (visited[s2] == 0 && s2 > 0) { // 사람이 배정될 수 있는 경우
				visited[s2] = Math.abs(s2 - order[index].ent) + 1;
				temp_num--;
				s2++;
			} else {
				if (s2 < n - 1) { // 범위 체크
					s2++;
				}
			}

		}

		if (temp_num == 1) {
			func(order, index + 1, visited);

			func(order, index + 1, visited);

			temp_num--;

		} else {
			func(order, index + 1, visited);
		}

	}

}
