import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static class City {
		int r, c, dist;

		public City(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static class Chicken {
		int r, c;

		public Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int n;
	private static int m;
	private static int[][] city;
	private static int[][] chicken;
	private static int min_dist = Integer.MAX_VALUE; // 집부터 치킨집까지의 최소 거리

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = bf.readLine();
		st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		city = new int[n + 1][n + 1];
		Queue<Chicken> chicken = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j]==2) {chicken.add(new Chicken(i,j));}
			}
		} // 입력
		
		ArrayList<Integer> t = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int k=0;k<chicken.size()-m;k++) {
			t.add(0);
		}
		for(int k = 0; k < m; k++) {
			t.add(1);
		}
		
		do {
			for(int k=0;k<chicken.size();k++) {
				if(t.get(k)==1) {
					index.add(k);
				}
				bfs(index);
		}
		}while(np(index)==true);
		

	}

		public static boolean np(ArrayList<Integer> index) { // numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열 존재하면 true, 아니면 false
			
			int N = index.size();
			// 1. 꼭대기 찾기
			int i = N-1;
			while(i>0 && index[i-1]>=index[i]) --i;
			
			if(i==0) return false; // 다음 순열을 만들수 없는 이미 가장 큰 순열의 상태!
			
			//2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
			int j= N-1;
			while(index[i-1]>=index[j]) --j;
			
			//3. i-1위치값과 j 위치값 교환
			swap(index, i-1, j);
			
			//4. i위치부터 맨뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
			int k = N-1;
			while(i<k) swap(index, i++, k--);
			
			return true;
		}
		
		public static void swap(int[] numbers,int i,int j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}

	static void bfs(ArrayList<Integer> c) {
		final int[] DR = { 1, 0, -1, 0 };
		final int[] DC = { 0, 1, 0, -1 };

		int house = 0; // 집의 개수
		int ret = 0;
		

		// bfs에 사용할 큐 생성
		Queue<City> q = new LinkedList<>();
		// 거리와 방문처리를 위한 boolean 배열
		boolean[][] visit = new boolean[n + 1][n + 1]; // 1-index 이므로

		for (int i = 0; i < c.size(); i++) {
			q.offer(new City(chicken[c.get(i)].r,chicken[c.get(i)].c,0));
			visit[chicken[c.get(i)].r][chicken[c.get(i)].c] = true;
		} //모든 치킨집 push
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (city[i][j] == 1) {
					house++;
				}
			}
		} // 입력

		int t_house = house;

		// BFS 진행
		while (!q.isEmpty()) {// 큐가 빌 때까지 반복
			City cur = q.poll(); // 큐에서 치킨집 하나 뽑아냄
			if (city[cur.r][cur.c] == 1) {
				t_house--;
				ret += cur.dist;
			}
			if (t_house != 0)
				break;
			for (int i = 1; i < 4; i++) { // 인접한 칸으로 탐색 진행
				int nr = cur.r + DR[i];
				int nc = cur.c + DC[i];

				if (nr < 0 || nr > n || nc < 0 || nc > n)
					continue;

				if (visit[nr][nc] == true)
					continue;

				visit[nr][nc] = true;

				q.add(new City(nr, nc, cur.dist + 1));

			}
			min_dist = Math.min(min_dist, ret);

		}
	}

}
