import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17478 {
	 static String[] str = { "\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };
	static String[] str2 = { "\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\"" };

	private static void recursive(int n, int s) {
		if (n == 0) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < s; i++) {
					System.out.print("____");
				}
				System.out.println(str2[j]);

			}
			return;
		}

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < s; i++) {
				System.out.print("____");
			}
			System.out.println(str[j]);
		}
		recursive(n - 1, s + 1);
	}

	private static void recursive2(int n) {
		if (n == 0) {
			System.out.println("라고 답변하였지.");
			return;
		}

		for (int i = n; i > 0; i--) {
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");
		
		recursive2(n - 1);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(N, 0);
		recursive2(N);

	}
}
