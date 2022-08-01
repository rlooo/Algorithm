import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferdReaderScannerTest {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new FileInputStream("inputTC.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
//		int TC = sc.nextInt();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
//			int N = sc.nextInt();
			int N = Integer.parseInt(in.readLine());
			int sum = 0;
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					sum += sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0+"s");
	}
}
