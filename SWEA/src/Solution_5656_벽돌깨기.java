import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int[][] map;
	static int N, W, H;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] selected;
	static int[][] dist;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Solution_5656_벽돌깨기.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			selected = new int[N];
			dist = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			perm(0);

			sb.append("#" + test_case + "\n");

		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();

			select();
			return;
		}
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			perm(cnt + 1);
		}

	}

	public static void select() {
		for (int w = 0; w < N; w++) {
			for (int i = 0; i < H; i++) {
				if(map[i][w]!=0) {
					bfs(new Pair(i,w));
				}
			}
		}
	}
	private static void bfs(Pair start) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		dist[start.x][start.y]=1;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x+dx[dir];
				int ny = cur.y+dy[dir];
				if(nx<0||ny<0||nx>=H||ny>=W)continue;
				if(dist[nx][ny]!=0) continue;
				if(map[cur.x][cur.y]<=dist[cur.x][cur.y]-1)continue;
				
			}
		}

	}

}
