import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();

		int n = Integer.parseInt(bf.readLine());
		int[] result = new int[n];

		st = new StringTokenizer(bf.readLine(), " ");
		s.push(Integer.parseInt(st.nextToken()));
		result[0] = 0;
		int index = 1;
		for (int i = 1; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			while (!s.empty()) {
				if (s.peek() < input) {
					s.pop();
					index--;
				}

				s.push(input);
				result[i] = index;
				index++;
			}

		}

		for (int i = n - 1; i >= 0; i--) {
			System.out.print(result[i] + " ");
		}

	}

}
