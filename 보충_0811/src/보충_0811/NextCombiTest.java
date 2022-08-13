package 보충_0811;

import java.util.Arrays;

public class NextCombiTest {

	public static void main(String[] args) {

		static int[] p = { 0, 0, 1, 1, 1 }; //5c3
		static int[] A = { 1, 2, 3, 4, 5 };
		static int N = p.length;
		static int count;

		// dfs + 저장 <--> 원위치+가지치기prunning => 백트래킹
		public static void main(String[] args) {
			do {
				count++;
				for(int i=0;i<N;i++) {
					if(p[i]==1) System.out.print(A[]);
				}
			} while (np(N - 1));

			System.out.println(count);// 깊이

		}

		private static boolean np(int size) {
			int i = size;
			while (i > 0 && p[i - 1] > p[i])
				i--;
			if (i == 0)
				return false;
			int j = size;
			while (p[i - 1] > p[j])
				j--;
			int temp = p[i - 1];
			p[i - 1] = p[j];
			p[j] = temp;
			int k = size;
			while (i < k) {
				temp = p[i];
				p[i] = p[k];
				p[k] = temp;
				i++;
				k--;
			}
			return true;
		}

	}

}
