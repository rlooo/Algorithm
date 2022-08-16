import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int ref = Integer.parseInt(in.readLine());
		
		int[] arr = new int[10271];
		for (int i = 0; i < ref; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int min_c = Integer.parseInt(st.nextToken());
			int max_c = Integer.parseInt(st.nextToken());
			
			for(int j=min_c+270;j<=max_c+270;j++) {
				arr[j]++;
			}
		}
		int max_num = Integer.MIN_VALUE;
		for(int i=0;i<10271;i++) {
			max_num = Math.max(max_num,arr[i]);
		}
		
		sb.append(ref-max_num+1);
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}

}
