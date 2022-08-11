import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(bf.readLine()); // 덤프횟수
			int[] arr = new int[100];
			st = new StringTokenizer(bf.readLine(), " ");

			for (int i = 0; i < 100; i++) { // 입력
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = num; i >= 1; i--) {
				Arrays.sort(arr); // 최대값, 최소값을 찾기 위한 정렬
				arr[0]++; // 최소값 ++
				arr[99]--; // 최대값--
			}
			
			Arrays.sort(arr);
			System.out.println("#" + test_case + " " + (arr[99] - arr[0]));

		}

	}

}
