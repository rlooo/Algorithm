import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int[][] air_pan;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int H;
	static int W;
	static List<Pair> cheeze = new ArrayList<>();
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int[][] pan = new int[H][W];
		air_pan = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num=0;
		int air_cnt=0;
		while(air_cnt!=H*W) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(air_pan[i][j]>0) continue;
					if(pan[i][j]==1) continue;
					num++;
					bfs(pan, num);
				}
			}
			for(int i=0;i<cheeze.size();i++) {
				pan[cheeze.get(i).x][cheeze.get(i).y]=0;
			}
		}
		

	}

	private static void bfs(int[][] pan, int num) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		air_pan[0][0]=1;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x+dx[dir];
				int ny = cur.y+dy[dir];
				
				if(nx<0||ny<0||nx>=H||ny>=W)continue;
				if(air_pan[nx][ny]>0) continue;
				if(pan[nx][ny]==1) {cheeze.add(new Pair(nx,ny));continue;}
				air_pan[nx][ny]=num;
				q.add(new Pair(nx,ny));
				
			}
		}
		
		
	}

}
