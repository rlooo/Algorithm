import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			String ch = st.nextToken();

			char check = '0';
			int count = 0;
			for (int i = 0; i < ch.length(); i++) {
				if (ch.charAt(i) != check) {
					count++;
					check = (check == '0') ? '1' : '0';
				}
			}
			System.out.println("#" + test_case + " "+count);
		}
	}
}
