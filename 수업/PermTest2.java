package bo0811;

import java.util.Arrays;

//nPr 3p2= 3*2
// 재귀
public class PermTest2 {
	static int[] p= {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static int[] nums;
	// 11111 10101
	// 0
	// 1
	// 10
	// 11
	// 100
	// 101
	// 110 
	// 11100
	// dfs + 저장 <--> 원위치+가지치기prunning => backtracking
	public static void main(String[] args) {
		R=3;
		nums=new int[R];
		npr(0,0);
		System.out.println(count);
	}
	//+ bit dp
	private static void npr(int cnt, int flag) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return ;
		}
		for (int i = 0; i <N; i++) {
			if((flag & (1<<i))!=0) continue;
			nums[cnt]=p[i];
			npr(cnt+1,(flag | (1<<i)) );
			nums[cnt]=0;
		}
	}
}
