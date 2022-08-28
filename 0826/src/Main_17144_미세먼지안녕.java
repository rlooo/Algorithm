import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] room = new int[R][C];
		int[][] dust = new int[R][C];
		
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int[][] d1 = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; // 반시계 방향
		int[][] d2 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 시계 방향
		Queue<Pair> q = new LinkedList<>();

		ArrayList<Integer> ac = new ArrayList<>(); // 공기청정기

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				
				if (room[i][j] == -1) { //냉장고 위치 저장
					ac.add(i);
				}
			}
		} // 입력

		while (true) {

			if (T <= 0) {
				break;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					dust[i][j]=0;
					if (room[i][j] > 0) {
						q.add(new Pair(i, j));
					}
				}
			} // 미세먼지 위치 저장
			
			
			
			while (!q.isEmpty()) {
				Pair cur_dust = q.poll();
				if(room[cur_dust.x][cur_dust.y]<5) continue;
				int cnt = 0;
				// 미세먼지 확산
				for (int dir = 0; dir < 4; dir++) {// 인접방향 확산
					int nx = cur_dust.x + dx[dir];
					int ny = cur_dust.y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue; // 범위 넘어가면 확산 x
					if (room[nx][ny] == -1)
						continue; // 공기청정기 있으면 확산 x

//					room[nx][ny] += room[cur_dust.x][cur_dust.y] / 5; // 확산된 미세먼지 양을 더한다
					dust[nx][ny] += room[cur_dust.x][cur_dust.y] / 5; // 확산된 미세먼지 양을 더한다
					//문제 이해를 잘하고 처음에 전략을 잘 짜야됨. 확산될 때마다 더하는게 아닌 "한번에" 더해주어야 함
					++cnt;

				}
				room[cur_dust.x][cur_dust.y] -= (room[cur_dust.x][cur_dust.y] / 5) * cnt; // 확산된 미세먼지 양만큼 빼고 남은 미세먼지양

			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					room[i][j]+=dust[i][j];
				}
			} 


			// 공기청정

			// 위 공기청정기
			// 시작지점 저장
			int ac1_row = ac.get(0);
			int save = room[ac1_row][0];
			int x = ac1_row;
			int y = 0;

			// 4방향으로 돌 때까지(반시계방향)
			int index = 0;
			while (index < 4) {
				// x,y이동
				int nx = x + d1[index][0];
				int ny = y + d1[index][1];

				if (nx < 0 || ny < 0 || nx > ac1_row || ny >= C) {
					// 범위를 벗어난 경우 방향 변경을 위해 +1
					index++;

					continue;
				} // 범위 안

				// 이동한 지점의 값 저장
				int next = room[nx][ny];
				// 이동하기 전 값으로 현재 이동한 지점 값 갱신
				room[nx][ny] = save;
				// 이동한 지점의 기존 값으로 save 값 갱신 -> 다음 이동 후 이 값으로 이동한 좌표 갱신을 위해
				save = next;

				// x,y 이동한 좌표로 갱신
				x = nx;
				y = ny;
			}

			room[ac1_row][1] = 0;
			room[ac1_row][0] = -1;

			index = 0;
			while (index < 4) {

				// 아래 공기청정기
				// 시작지점 저장
				int ac2_row = ac.get(1);
				save = room[ac2_row][0];
				x = ac2_row;
				y = 0;

				// 4방향으로 돌 때까지(반시계방향)
				index = 0;
				while (index < 4) {
					// x,y이동
					int nx = x + d2[index][0];
					int ny = y + d2[index][1];

					if (nx < ac2_row || ny < 0 || nx >= R || ny >= C) {
						index++;

						continue;
					} // 범위 안

					int cur = room[nx][ny];
					room[nx][ny] = save;
					save = cur;

					x = nx;
					y = ny;
				}
				room[ac2_row][1] = 0;
				room[ac2_row][0] = -1;

				T--;
			}

		}
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j]>0)res += room[i][j];
			}
		}



		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}
}
