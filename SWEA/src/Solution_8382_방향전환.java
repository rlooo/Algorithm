package bo0825;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8382_방향전환 {

	static int T,N=200;
	static int x1,y1,x2,y2;
	static int [] dr= {-1,0,1, 0};  //짝 상하
	static int [] dc= { 0,1,0,-1};  //홀 좌우
	static int[][][] visited ;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			x1=scann.nextInt()+100;
			y1=scann.nextInt()+100;
			x2=scann.nextInt()+100;
			y2=scann.nextInt()+100;
			//읽기끝
			//로직시작
			visited=new int[N+1][N+1][2];
			Queue<int[]> que=new LinkedList<>();
			que.offer(new int[] {x1,y1,0,0});
			que.offer(new int[] {x1,y1,0,1});
			visited[x1][y1][0]=1;  //짝수
			visited[x1][y1][1]=1;  //홀수
			int value=0;
			//bfs 로직
			while(!que.isEmpty()) {
				int[] cur=que.poll(); // 하나빼
				int r=cur[0];
				int c=cur[1];
				int cnt=cur[2];
				int dir=cur[3];
				
				//도착했나??
				if(r==x2 && c==y2) {
					value=cnt;
					break;
				}
				//도착안했으면 방향이동 -> 좌나 우, 상또는 하 등 2방향뿐
				// 방향+홀수 -> 무조건 방향전환
				for (int d = 1;d <4 ; d+=2) {
					int s=(dir+d)%4; // dir=0 s=1,3 좌우
					int u=(dir+d)%2; // dir=0 u=1
					int nr=r+dr[s];
					int nc=c+dc[s];
					if(!check(nr,nc))continue; // 밖 제외
					if(visited[nr][nc][u]==0) {
						visited[nr][nc][u]=1;
						que.offer(new int[] {nr,nc,cnt+1,s});  // 위아래로 시작+ 이동회수
					}
				}
			}
			//출력
			System.out.println("#"+t+" "+value);
		}

	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N+1 && c>=0 && c<N+1;
	}

}
