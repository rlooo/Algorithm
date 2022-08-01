import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTest {
	
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(in.readLine()); //원판의 개수
		hanoi(cnt, 1, 2, 3);
		System.out.println(result);
	}
	private static void hanoi(int cnt, int from, int temp, int to) {
		hanoi(cnt-1, from, to, temp);
		result.append(cnt + " : " + from + "-->"+to+"\n");
		hanoi(cnt-1, temp, from, to);
	}

}
