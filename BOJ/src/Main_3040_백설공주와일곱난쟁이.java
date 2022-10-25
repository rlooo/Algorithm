import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[9];
		boolean[] isused = new boolean[9];
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(bf.readLine());
		}
		func(input, isused, 0, 7);

	}

	private static void func(int[] input, boolean[] isused, int start, int r) {
		if (r == 0) {
			int sum=0;
			int cnt=0;
			for (int i = 0; i < 9; i++) {
				if (isused[i] == true) {
					cnt++;
					sum+=input[i];
				}
			}
			if(sum==100&&cnt==7) {
				for (int i = 0; i < 9; i++) {
					if (isused[i] == true) {
						System.out.println(input[i]);
					}
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			isused[i] = true;
			func(input, isused, i+1,r-1);
			isused[i] = false;
		}

	}

}
