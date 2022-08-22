import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static int L;
	static int C;
	static char[] input;
	static char[] choosed;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 문자 종류

		input = new char[C];
		choosed = new char[L];

		st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(input);

		comb(L, 0);

		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void comb(int toChoose, int startIdx) {
		if (toChoose == 0) {
			int c = 0;// 자음
			int v = 0;// 모음
			for (int i = 0; i < choosed.length; i++) {

				if (choosed[i] == 'a' || choosed[i] == 'e' || choosed[i] == 'i' || choosed[i] == 'o'
						|| choosed[i] == 'u') {
					c++;
				} else {
					v++;
				}

			}

			if (c >= 1 && v >= 2) {
				for (int i = 0; i < choosed.length; i++) {
					sb.append(choosed[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = startIdx; i < input.length; i++) {
			choosed[choosed.length - toChoose] = input[i];
			comb(toChoose - 1, i + 1);
		}

	}

}
