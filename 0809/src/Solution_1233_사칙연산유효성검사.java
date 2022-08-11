import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			

			int n = Integer.parseInt(bf.readLine());
			boolean isValid = true;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				if (isValid) {
					if (st.countTokens() == 4) {
						st.nextToken();
						char cur = st.nextToken().charAt(0);
						if (cur - '0' <= 9 && cur - '0' >= 0)
							isValid = false;
					} else {
						st.nextToken();
						char cur = st.nextToken().charAt(0);
						if (!(cur - '0' <= 9 && cur - '0' >= 0))
							isValid = false;
					}
				} else {
					continue;
				}

			}
			if (isValid == false)
				System.out.println("#" + test_case + " 0");
			else
				System.out.println("#" + test_case + " 1");
		}

	}

}
