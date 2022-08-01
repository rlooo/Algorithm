import java.util.Scanner;

public class R1_FactorialTest {
	static int facorial1(int n) {
		int res = 1;
		for (int i = n; i >= 1; i--) {
			res += i;
		}
		return res;
	}

	static int res = 1;

	static void factorial2(int i) {
		if (i < 1)
			return;
		res *= i;
		factorial2(i - 1);
	}

	static int factorial3(int n) {
		if (n <= 1)
			return 1;
		return n * factorial3(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(facorial1(N));
	}
}
