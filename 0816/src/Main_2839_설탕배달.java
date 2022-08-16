import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int res = 0;
		while (n >= 0) {
			if (n % 5 == 0) {
				res += n / 5;
				n = n % 5;
				break;
			}

			res += 1;
			n -= 3;

		}

		if (n == 0) {
			sb.append(res);
		} else {
			sb.append(-1);
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

}
