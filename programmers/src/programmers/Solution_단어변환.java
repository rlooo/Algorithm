package programmers;

public class Solution_단어변환 {
	static int ans = Integer.MAX_VALUE;

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		boolean[] visited = new boolean[words.length];
		String pre = begin;
		dfs(target, words, visited, pre, 0);
		if (ans == Integer.MAX_VALUE) {
			answer = 0;
		} else {
			answer = ans;
		}
//		System.out.println(answer);
		return answer;
	}

	private static void dfs(String target, String[] words, boolean[] visited, String pre,  int cnt) {

		if (pre.equals(target)) {
			ans = Math.min(cnt, ans);

			return;
		}

		for (int i = 0; i < words.length; i++) {
			int sameCh = 0;
			for (int j = 0; j < words[i].length(); j++) {
				if (words[i].charAt(j) != pre.charAt(j)) {
					sameCh++;
				}
				if (sameCh == 2) {
					break;
				}
			}
			if (sameCh == 1) {
				if (visited[i] == false) {
					visited[i] = true;
					dfs(target, words, visited, words[i], cnt + 1);
					visited[i] = false;
				}

			}

		}

	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words2 = { "hot", "dot", "dog", "lot", "log" };
		solution(begin, target, words);
	}

}
