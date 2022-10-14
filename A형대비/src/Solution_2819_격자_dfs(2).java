package algol0816;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_2819_격자_dfs {

	static int T;
	static int N=4;
	static int[][] map;
	
	static int[] dr= {-1,0,1, 0};
	static int[] dc= { 0,1,0,-1};
	
	static HashSet<String> ts;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			map=new int[N][N];
			ts=new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=scann.nextInt();
				}
			}//읽기
			/*for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}*/
			//로직
            // 4x4 (i,j)위치에서 6번 4방 이동해보자. 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					npr(i,j,0,new int[] {map[i][j],0,0,0,0,0,0});
				}
			}
			System.out.println("#"+t+" "+ts.size());
		}// T for

		
	}
    // 중복순열 cnt==6까지 반복하자 
	private static void npr(int r, int c, int cnt, int[] nums) {
		if(cnt==6) {
			//로직 nums에 1개 +6개가 채워 들어온다. 
			//System.out.println(Arrays.toString(nums));
			ts.add(Arrays.toString(nums));//[0,1,1]
			return ;
		}
		//4방해서 갈수 있는지 체크하고 가자
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc))continue;
			nums[cnt+1]=map[nr][nc]; // 0번째 이미 채워서 들어왔다.
			npr(nr,nc,cnt+1,nums);
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
