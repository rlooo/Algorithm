import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/Solution_1952_수영장.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			res = Integer.MAX_VALUE;
			int[] priceTable = new int[4];
			st = new StringTokenizer(in.readLine());

			for (int i = 0; i < 4; i++) {
				priceTable[i] = Integer.parseInt(st.nextToken());
			} // 이용권 가격 입력

			int[] usePlan = new int[12];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 12; i++) {
				usePlan[i] = Integer.parseInt(st.nextToken());
			} // 이용계획

			int select = 0; // 1월부터 시작(0-index)
			int totalPrice = 0;
			dfs(priceTable, usePlan, select, totalPrice);

			sb.append("#" + test_case + " " + res + "\n");
			

		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(int[] priceTable, int[] usePlan, int select, int totalPrice) {
		if (select > 11) { // 0-index이므로
			res = Math.min(res, totalPrice);
			res = Math.min(res, priceTable[3]);// 1년 비용과 비교
			return;
		}

		if (usePlan[select] != 0) { // 이용권이 필요할 때 사야됨
			// 1일권일 때
			dfs(priceTable, usePlan, select + 1, totalPrice + (usePlan[select] * priceTable[0]));
			// 1달권일 때
			dfs(priceTable, usePlan, select + 1, totalPrice + priceTable[1]);
			// 3달권일 때
			dfs(priceTable, usePlan, select + 3, totalPrice + priceTable[2]);
		} else {

			dfs(priceTable, usePlan, select + 1, totalPrice);
		}

	}

}
