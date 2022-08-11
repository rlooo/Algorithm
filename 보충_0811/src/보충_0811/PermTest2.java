package 보충_0811;

import java.util.Arrays;

//재귀 - recursion - 자신이 자신을 호출
//for while -end condition!!
//int 2100000000
//long 9000000000000000000
//10! 
//1000000000 반복 0.7
//5! = 5*4!
//f(5)= 5* f(4)
public class PermTest2 {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	// 1111 10101
	// 서브셋 이용 
	// 0 
	// 1
	// 10
	// 11
	// 100
	// 101
	// 110
	// 11100
	// dfs + 저장 <--> 원위치+가지치기prunning => 백트래킹
	public static void main(String[] args) {
		R = 3;
		nums = new int[R];
		npr(0,0);
		System.out.println(count);// 깊이

	}
	// 완전 탐색 브루트폴스
	// + bit dp
	private static void npr(int cnt, int flag) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & (1<<i))!=0)
				continue;
			nums[cnt] = p[i];
			npr(cnt + 1, (flag|(1<<i))); // 깊이 들어가서 끝날 때까지는 안내려감. 손으로 써보기
//			nums[cnt]=0;
		}
	}

}
