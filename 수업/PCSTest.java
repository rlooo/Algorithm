import java.util.Scanner;

public class PCSTest {

	static int N,R,input[], numbers[];
	static boolean isSelected[]; //input: 입력 배열, numbers:순열, 조합에 선택된 수 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];

		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		System.out.println("======순열=====");
		System.out.println("======조합=====");
		System.out.println("======부분집합=====");
	}
	public static void perm(int cnt) {
		if(cnt==R) {
			return;
		}
		for(int i=0;i<N;i++) {
			if(!isSelected[i]) {
				isSelected[i]=true;
				numbers[cnt]=input[i];
				perm(cnt+1);
				isSelected[i]=false;
			}
		}
	}
	public static void comb(int start, int cnt) {
		if(cnt==R) {
			return;
		}
		for(int i=start;i<N;i++) {
			numbers[cnt]=input[i];
			comb(i+1,cnt+1);
		}
	}

}
