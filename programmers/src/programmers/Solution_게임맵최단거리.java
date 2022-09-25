package programmers;

import java.util.LinkedList;
import java.util.Queue;


public class Solution_게임맵최단거리 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] maps1 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		int[][] maps2 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };

//		solution(maps1);
		solution(maps2);

	}

	public static int solution(int[][] maps) {
		int answer = 0;
		Pair start = new Pair(0, 0);
		int[][] dist = new int[maps.length][maps[0].length];
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist[0].length;j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
			
		}
		answer = bfs(maps, start, dist);
		System.out.println(answer);
		return answer;
	}

	private static int bfs(int[][] maps, Pair start, int[][] dist) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		dist[0][0]=1;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int dir = 0;dir<4;dir++) {
				int nx = p.x+dx[dir];
				int ny = p.y+dy[dir];
			
				if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length) continue;
				if(maps[nx][ny]!=1)continue;
				if(dist[nx][ny]!=Integer.MAX_VALUE) continue;
				
				q.add(new Pair(nx,ny));
				dist[nx][ny]=Math.min(dist[nx][ny],dist[p.x][p.y]+1);
			}
			
		}
		
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist[0].length;j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		if(dist[dist.length-1][dist[0].length-1]==Integer.MAX_VALUE) {return -1;}
		else {return dist[dist.length-1][dist[0].length-1];}

	}

}
