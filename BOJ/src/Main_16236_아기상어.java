import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static StringBuilder sb = new StringBuilder();
	static int[] nx = { 0, 0, -1, 1 };
	static int[] ny = { -1, 1, 0, 0 };
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
			arr[i][j]=Integer.parseInt(st.nextToken());
			}			
		} //입력
		
		bfs();
		
		
	}
	private static void bfs() {
		
		
	}

}
