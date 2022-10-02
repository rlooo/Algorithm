import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_보급로{
	static int[][] map;
	static int N;
	static int res ;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int time;

		Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time=time;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.time<o.time) {
				return -1;
			} else if(this.time>o.time){return 1;}
			return 0;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/Solution_1249_보급로.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			res = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			bfs();

			sb.append("#" + test_case + " " + res + "\n");

		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs() {
		Queue<Pair> q = new PriorityQueue<>();
		visited[0][0]=true;
		q.add(new Pair(0, 0, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			
			if(cur.x==N-1&&cur.y==N-1) {
				res = cur.time;
				return;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				
				if(visited[nx][ny]!=false) continue;
				
				visited[nx][ny]=true;
				q.add(new Pair(nx,ny,cur.time+map[nx][ny]));
			}

		}

	}

}
