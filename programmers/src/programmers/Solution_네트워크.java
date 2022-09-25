package programmers;

import java.util.ArrayList;

public class Solution_네트워크 {
	static ArrayList<ArrayList<Integer>> nodeList;
	static boolean[] visited;

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		visited = new boolean[n];
		nodeList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			nodeList.add(new ArrayList<>());
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					nodeList.get(i).add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {

				dfs(n, computers, i);
				answer++;
			}
		}

		return answer;
	}

	private static void dfs(int n, int[][] computers, int i) {
		visited[i] = true;
		for (int j = 0; j < nodeList.get(i).size(); j++) {
			int node = nodeList.get(i).get(j);

			if (visited[node] == true)
				continue;

			dfs(n, computers, node);

		}

	}

	public static void main(String[] args) {
//		int[][] arr1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int[][] arr2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
//		int[][] arr3 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
//		int[][] arr4 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][] arr5 = { { 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 1 } };

//		System.out.println(solution(3, arr1));
//		System.out.println(solution(3, arr2));
//		System.out.println(solution(3, arr3));
		System.out.println(solution(5, arr5));
	}
}
