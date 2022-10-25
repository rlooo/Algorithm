import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {

	static int N, R, totalCnt;
	static int[] numbers, input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;

		input = new int[N];
		numbers = new int[R];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		comb(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);

	}

	private static void comb(int cnt, int start) { // cnt: 직전까지 뽑은 조합에 포함된 수의 개수, start: 시도할 수의 시작 위치
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도(input 배열의 가능한 수 시도)
		// start 부터 처리해서 중복 수 추출 방지 및 순서가 다른 조합 방지
		for (int i = start; i < N; i++) {
			// start 위치부터 처리했으므로 중복체크 필요없음!!
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1); // start는 반복문을 돌 때 시작만 결정하는 것. start+1이 아닌 i+1을 넘겨주어야 한다.

		}

	}

}
