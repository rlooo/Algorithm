import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		
		st=new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		st=new StringTokenizer(input, " ");
		
		int[] arr=new int[n+1];
		int[] sum_arr=new int[n+1];
		int sum=0;
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
			sum_arr[i]=sum;
		}

		for(int i=0;i<m;i++) {
			str = br.readLine();
			st=new StringTokenizer(str, " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sum_arr[end]-sum_arr[start-1]);
		}		
	}

}
