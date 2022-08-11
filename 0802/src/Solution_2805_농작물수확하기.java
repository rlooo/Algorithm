import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(bf.readLine());
			char[][] str = new char[n][n];
			
			for (int i = 0; i < n; i++) { // 입력
				str[i] = bf.readLine().toCharArray();
			}
		
					
			int sum=0;
			for(int i=n/2;i>=0;i--) {
				for(int j=n/2-i;j<2*(n-j);j++) {
					sum+=Integer.parseInt(str[i][j]+"");
					System.out.println(i+" "+j);
				}
			}
			System.out.println(sum);
//			
////			for(int i=n/2+1;i<n;i++) {
////				for(int j=1;j<i+(n/2-2);j++) {
////					sum+=arr[i][j];
////				}
////			}
//			System.out.println(sum);
			
		}
		
	}

}