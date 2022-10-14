package bo0811;

import java.util.Arrays;

//nPr 3p2= 3*2
// 재귀
public class PermTest {
	static int[] p= {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static int[] nums;
	static boolean [] visited ;
	// dfs + 저장 <--> 원위치+가지치기prunning => backtracking
	public static void main(String[] args) {
		R=3;
		nums=new int[R];
		visited=new boolean[N];
		npr(0);
		System.out.println(count);
	}
	private static void npr(int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return ;
		}
		for (int i = 0; i <N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			nums[cnt]=p[i];
			npr(cnt+1);
			nums[cnt]=0;
			visited[i]=false;
		}
	}

}
