import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = in.readLine();

		ArrayList<Integer> arr = new ArrayList<>();
		int num = 0;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '-') {
				sum += num;
				arr.add(sum);

				sum = 0;
				num = 0;

			}
			if (c == '+') {
				sum += num;
				num = 0;

			}
			if (c != '-' && c != '+') {
				num = num * 10 + (c - '0');
			}
		}
		arr.add(sum + num);

		sum = arr.get(0);
		if (arr.size() >= 1) {
			for (int i = 1; i < arr.size(); i++) {
				sum -= arr.get(i);
			}

		}
		System.out.println(sum);

//		for(int i:arr) {
//			System.out.println(i);
//		}
	}

}
