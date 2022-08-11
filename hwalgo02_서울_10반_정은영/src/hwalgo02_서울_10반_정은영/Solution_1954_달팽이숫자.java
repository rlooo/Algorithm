package hwalgo02_서울_10반_정은영;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1954_달팽이숫자 {
	static int n=0;
	static int[][] arr;
	
	public static void func(int i, int j) {

		int index=0;
		while(index!=n*n) {
			for(int col=j;col<n-j;col++) {
				arr[i][col]=++index;
			}
			for(int row=i+1;row<n-i;row++) {
				arr[row][n-j-1]=++index;
			}
			for(int col=n-j-2;col>=j;col--) {
				arr[n-i-1][col]=++index;
			}
			for(int row=n-i-2;row>i;row--) {
				arr[row][j]=++index;
			}
			i++;
			j++;

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(bf.readLine());
			arr= new int[n][n];
			func(0,0);
			System.out.println("#"+test_case);
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}

