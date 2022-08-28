import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static int[] arr;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());

			arr = new int[N];
			st = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // 입력

			powerSet();
			
			sb.append("#"+test_case+" "+ans+"\n");


		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void powerSet() {
		for (int i = 0; i < (1 << arr.length); i++) {
			int right = 0;
			int left = 0;
			List<Integer> includes = new ArrayList<>();
			List<Integer> excludes = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) > 0) {
					includes.add(arr[j]);
					right += arr[j];
				} else {
					excludes.add(arr[j]);
					left += arr[j];
				}
			}
			if (right <= left) {
				ans+=f(includes.size())*f(excludes.size()); //수정
				System.out.println(includes + " : " + excludes);
			}
		}
	}
	
	

}
