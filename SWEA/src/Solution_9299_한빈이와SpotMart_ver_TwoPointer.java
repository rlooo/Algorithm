
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9299_한빈이와SpotMart_ver_TwoPointer {
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
			Arrays.sort(arr);
			int max_num=-1;
			int end=1;
			for(int start=0;start<n;start++) {
				while(end<n&&arr[start]+arr[end]<=m) end++;
				if(end==n)break;
				System.out.println(arr[start]+" "+arr[end]);
				max_num=Math.max(max_num,arr[start]+arr[end]);
			}
			System.out.print("#"+test_case+" ");
			System.out.println(max_num);
		}
	}
}
