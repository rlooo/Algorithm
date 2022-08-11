import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	static int input;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(bf.readLine());

		func(1, 2);
		func(1, 3);
		func(1, 5);
		func(1, 7);

	}

	public static void func(int cnt, long num) {
		if (cnt == input) {
			if (isPrime(num) == true) {
				System.out.println(num);
			}
			return;
		}
		
		int[] arr = { 1, 3, 7, 9 };
		
		for(int i=0;i<4;i++) {
			if(isPrime(10*num+arr[i])==true) {
//				num=10*num+arr[i];
//				cnt++;
//				func(cnt,num);	
				func(cnt+1,10*num+arr[i]);	
			}
		}

		
	}

	public static boolean isPrime(long n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
