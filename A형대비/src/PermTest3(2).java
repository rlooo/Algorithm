package bo0818;

import java.util.Arrays;

//npr 순서고려 
// bit man.
// flag 12345   10010  0~ (1<<5) -1
// 0 1 10 11 100 101 110 111 ... 11111
public class PermTest3 {
	
	static int [] p= {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static int [] nums;
	
	public static void main(String[] args) {
		R=3;
		nums=new int[R];
		npr(0,0);
		System.out.println(count);
	}
    // 100 -> 1| 100 --> 101
	private static void npr(int cnt, int flag) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return ;
		}
		for (int i = 0; i < N; i++) {
			if((flag &(1<<i))!=0)continue;
			nums[cnt]=p[i];
			npr(cnt+1,(flag | (1<<i)));
			nums[cnt]=0;
		}
	}

}
