import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9299_한빈이와SpotMart {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(bf.readLine());
		for(int test_case=1;test_case<=TC;test_case++) {
			st=new StringTokenizer(bf.readLine()," ");
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st=new StringTokenizer(bf.readLine()," ");
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int max_num=-1;
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					if(max_num<arr[i]+arr[j]&&m>=arr[i]+arr[j]) {
						max_num=arr[i]+arr[j];
					}
				}
			}
			System.out.print("#"+test_case+" ");
			System.out.println(max_num);
		}
	}
}
