import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] room;
	static int max_room=0;
	static int[][] arr;
	static int[][] visited;
	static int n;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine()); // 테스트 케이스

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			max_room=0;
			n = Integer.parseInt(in.readLine());

			arr = new int[n][n];
			visited = new int[n][n];
			room = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				Arrays.fill(visited[i],0);
				for (int j = 0; j < n; j++) {
					bfs(new Pair(i, j));
				}
			}
			
			int num=0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					num++;
					if(max_room==room[i][j]) {
						sb.append(num);
						break;
					}
					
				}
			}
			
			sb.append(num+" "+max_room+"\n");

		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(Pair s) {
		Queue<Pair> q = new LinkedList<>();
		q.add(s);
		visited[s.x][s.y] = 0;

		int nx=-1,ny=-1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				nx = cur.x + dx[dir];
				ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] > 0)
					continue;

				if (arr[nx][ny] != arr[cur.x][cur.y] + 1)
					continue;

				visited[nx][ny] += visited[cur.x][cur.y] + 1;
				max_room=Math.max(max_room, visited[nx][ny]);
				
				q.add(new Pair(nx, ny));

			}

		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
//		room[s.x][s.y]=visited[nx][ny];

	}

}
