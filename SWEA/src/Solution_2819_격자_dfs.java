package algol0816;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_2819_격자_dfs {

	static int T;
	static int N=4;
	static int[][] map;
	
	static int[] dr= {-1,0,1, 0};
	static int[] dc= { 0,1,0,-1};
	
	static TreeSet<String> ts;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			map=new int[N][N];
			ts=new TreeSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=scann.nextInt();
				}
			}//읽기
			/*for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}*/
			//로직

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					npr(i,j,0,new int[] {map[i][j],0,0,0,0,0,0});
				}
			}
			System.out.println("#"+t+" "+ts.size());
		}// T for

		
	}

	private static void npr(int r, int c, int cnt, int[] nums) {
		if(cnt==6) {
			//로직
			return ;
		}
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			
		}
	}

}
