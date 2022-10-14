package bo0818;

import java.util.ArrayList;
import java.util.Arrays;

//npr 순서고려 
// dfs -> dfs+prunning+저장+원위치
public class PermTest2 {
	
	static int [] p= {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static ArrayList<String> nums2;
	static boolean[] visited ;
	
	public static void main(String[] args) {
		R=3;
		nums2=new ArrayList<>();
		visited=new boolean[N];
		npr(0, nums2);
		System.out.println(count);
	}

	private static void npr(int cnt, ArrayList<String> nums ) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums.toArray()));
			return ;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums.add(p[i]+"");
			npr(cnt+1,nums);
			nums.remove(p[i]+"");
			visited[i]=false;
		}
	}

}
