import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(bf.readLine());
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
//			int n = Integer.parseInt(bf.readLine());
//			char[][] str = new char[n][n];
//			
//			for (int i = 0; i < n; i++) { // 입력
//				str[i] = bf.readLine().toCharArray();
//			}
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					arr[i][j]=str.charAt(j)-'0';
				}
			}
					
			int sum=0;
			for(int i=0;i<n/2;i--) {
				for(int j=n/2-i;j<=n/2+i;j++) {
//					sum+=Integer.parseInt(str[i][j]+"");
					sum+=arr[i][j];
				}
			}

			for(int i=n/2;i>=0;i--) {
				for(int j=n/2-i;j<=n/2+i;j++) {
//					sum+=Integer.parseInt(str[i][j]+"");
					sum+=arr[i][j];
				}
			}
			System.out.println("#"+test_case+" "+sum);

			
		}
		
	}

}