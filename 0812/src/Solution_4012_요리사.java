import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(in.readLine());

			int[][] arr = new int[N + 1][N + 1];
			
			for (int i = 1; i <= N; i++) {
				
				st = new StringTokenizer(in.readLine(), " ");
				
				for (int j = 1; j <= N; j++) {
					
					arr[i][j] = Integer.parseInt(st.nextToken());
				
				}
			}//입력
			permutation(arr);
			
			
			
			

		}
	}

	private static void permutation(int[][] arr, int cnt) {
		if(cnt==2) {
			
		}
		
		for() {
			
		}
		
	}

}
