package 보충_0811;

import java.util.Arrays;
// 재귀
public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	static boolean[] visited;

	// dfs + 저장 <--> 원위치+가지치기prunning => 백트래킹
	public static void main(String[] args) {
		R = 3;
		nums = new int[R];
		visited = new boolean[N];
		ncr(0,0);
		System.out.println(count);// 깊이

	}

	private static void ncr(int start, int cnt) {
		if (cnt == R) {
			count++; //visit가 있어야 구할 수 있음
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < N; i++) { //start가 중요
			visited[i] = true; // visit 없어도 되는데 count를 구하기 위해 남겨놓은 것
			nums[cnt] = p[i];
			ncr(i+1, cnt + 1); // 깊이 들어가서 끝날 때까지는 안내려감. 손으로 써보기
//			nums[cnt]=0;
			visited[i] = false;
		}
	}

}
