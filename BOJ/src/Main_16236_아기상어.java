import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N, M = 0;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int sec = 0;
	static int[][] visited;

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair p) {
			if(this.x==p.x) {
				return this.y - p.y;
			}
			else {return (this.x-p.x)*(-1);}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N];

		int start_x = 0;
		int start_y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					start_x = i;
					start_y = j;
				}
				if (map[i][j] > 0 && map[i][j] != 9) {
					M++;
				}
			}
		}
		System.out.println();
		if(M==0) {
			sb.append(0);
		}

		else {
			bfs(start_x, start_y);
			sb.append(sec);
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs(int start_x, int start_y) {
		int size = 2;
		int eated = 0;
		ArrayList<Pair> arr = new ArrayList<>();
		Queue<Pair> q = new LinkedList();

		q.add(new Pair(start_x, start_y));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			map[cur.x][cur.y] = 9;
			int possibleEat = 0;
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (map[nx][ny] == 9)
					continue;
				if (size < map[nx][ny]) continue;

				if (size > map[nx][ny]&&map[nx][ny]!=0) {
					possibleEat++;
					arr.add(new Pair(nx, ny));
					System.out.println(nx+" "+ny);
				}

			}
			
			
			if (possibleEat > 1) {
				Collections.sort(arr);
				for(int i=0;i<arr.size();i++) {
					System.out.println(">> "+arr.get(i).x+" "+arr.get(i).y);
				}
//				System.out.println(arr.get(arr.size()-1).x+" "+arr.get(arr.size()-1).y);
				q.add(new Pair(arr.get(arr.size()-1).x, arr.get(arr.size()-1).y));
				sec++;
				eated++;
				arr.clear();
			} else if (possibleEat == 1) {
				q.add(new Pair(arr.get(0).x, arr.get(0).y));
				sec++;
				eated++;
				arr.clear();
			} else if (possibleEat == 0) {
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (size < map[nx][ny] || map[nx][ny] == 9)
						continue;

					q.add(new Pair(nx, ny));
					visited[nx][ny]=visited[cur.x][cur.y]+1;
					System.out.println("visited "+visited[nx][ny]);
					
				}
				

			}

			if (size == eated) {
				size++;
			}

			if (eated == M) {
				
				break;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			

		}
		
		System.out.println("visit");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("size : " + size);


	}
	

}
