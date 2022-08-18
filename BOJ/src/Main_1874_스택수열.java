import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		} // 입력

		Stack<Integer> s = new Stack();

		int index = 0;
		int num = 1;
		s.add(0);
		while (index < n) {
			if (s.peek() <= arr[index]) {
				s.push(num++);
				sb.append("+");
			}
			if (s.peek() > arr[index]) {
				s.pop();
				sb.append("-");
			
			}
			index++;
			
			
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

}
