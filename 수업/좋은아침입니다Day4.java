import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침입니다Day4 {
	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {

//		1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("\n\n비트 연산을 이용한 모든 부분집합");
		powersetUsingBitMasking();

		System.out.println("\n\n모든 부분집합");
		powerset(0, new boolean[src.length]);

//		2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("\n\nNext Permutation을 이용한 조합");
		int[] numbers = new int[src.length];
		for(int i = src.length - 3; i < src.length; i++) {
			numbers[i] = 1;
		}
		
		char[] result = new char[3];
		Arrays.sort(numbers);
		do {
			int idx = 0;
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[i] != 0) result[idx++] = src[i];
			}
			System.out.print(Arrays.toString(result) + " ");
		} while(nextPermutation(numbers));
		
		System.out.println("\n\n조합");
		combination(3, new char[3], 0);

//		3. src에서 3개를 뽑아서 만들 수 있는 중복조합을 모두 출력하시오.
		System.out.println("\n\n중복조합");
		combinationWithRepetition(3, new char[3], 0);

//		4. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("\n\nNext Permutation을 이용한 순열");
		char[] input = new char[src.length];
		for(int i = 0; i < src.length; i++) {
			input[i] = src[i];
		}
		
		Arrays.sort(input);
		do {
			System.out.print(Arrays.toString(input) + " ");
		} while(nextPermutation(input));
		
		System.out.println("\n\n비트마스킹을 이용한 순열");
		permutationUsingBitMasking(3, new char[3], 0);

		System.out.println("\n\n순열");
		permutation(3, new char[3], new boolean[src.length]);

//		5. src에서 3개를 뽑아서 만들 수 있는 중복순열을 모두 출력하시오.
		System.out.println("\n\n중복순열");
		permutationWithRepetition(3, new char[3]);
	}

	// 비트 연산을 이용한 멱집합 만들기
	private static void powersetUsingBitMasking() {
		for (int i = 0; i < (1 << src.length); i++) {
			List<Character> includes = new ArrayList<>();
			for (int j = 0; j < src.length; j++) {
				if ((i & 1 << j) > 0) {
					includes.add(src[j]);
				}
			}
			System.out.print(includes + " ");
		}
	}

	// 멱집합 만들기
	private static void powerset(int startIdx, boolean[] isSelected) {
		if (startIdx == src.length) {
			List<Character> result = new ArrayList<>();
			for (int i = 0; i < src.length; i++) {
				if (isSelected[i])
					result.add(src[i]);
			}
			System.out.print(result.toString() + " ");
			return;
		}

		isSelected[startIdx] = true;
		powerset(startIdx + 1, isSelected);

		isSelected[startIdx] = false;
		powerset(startIdx + 1, isSelected);
	}

	// 조합 만들기
	private static void combination(int left, char[] c, int startIdx) {
		if (left == 0) {
			System.out.print(Arrays.toString(c) + " ");
			return;
		}

		// 선택
		for (int i = startIdx; i < src.length; i++) {
			c[c.length - left] = src[i];
			combination(left - 1, c, i + 1);
		}
	}

	// 중복 조합 만들기
	private static void combinationWithRepetition(int left, char[] c, int startIdx) {
		if (left == 0) {
			System.out.print(Arrays.toString(c) + " ");
			return;
		}

		for (int i = startIdx; i < src.length; i++) {
			c[c.length - left] = src[i];
			combinationWithRepetition(left - 1, c, i);
		}
	}

	// NextPermutation
	private static boolean nextPermutation(char[] src) {
		int N = src.length;
		
		int i = N - 1;
		while(i > 0 && src[i - 1] >= src[i]) --i;
		
		if(i == 0) return false;  
		
		int j = N - 1;
		while(src[i - 1] >= src[j]) --j;
		
		swap(src, i - 1, j);
		
		int k = N - 1;
		while(i < k) swap(src, i++, k--);
		
		return true;
	}
	
	private static boolean nextPermutation(int[] src) {
		int N = src.length;
		
		int i = N - 1;
		while(i > 0 && src[i - 1] >= src[i]) --i;
		
		if(i == 0) return false;  
		
		int j = N - 1;
		while(src[i - 1] >= src[j]) --j;
		
		swap(src, i - 1, j);
		
		int k = N - 1;
		while(i < k) swap(src, i++, k--);
		
		return true;
	}
	
	// 비트마스킹을 이용한 순열 만들기
	private static void permutationUsingBitMasking(int left, char[] p, int flag) {
		if (left == 0) {
			System.out.print(Arrays.toString(p) + " ");
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			p[p.length - left] = src[i];
			permutationUsingBitMasking(left - 1, p, flag | 1 << i);
		}
	}

	// 순열 만들기
	private static void permutation(int left, char[] p, boolean[] isSelected) {
		if (left == 0) {
			System.out.print(Arrays.toString(p) + " ");
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			p[p.length - left] = src[i];
			permutation(left - 1, p, isSelected);
			isSelected[i] = false;
		}
	}

	// 중복 순열 만들기
	private static void permutationWithRepetition(int left, char[] p) {
		if (left == 0) {
			System.out.print(Arrays.toString(p) + " ");
			return;
		}

		for (int i = 0; i < src.length; i++) {
			p[p.length - left] = src[i];
			permutationWithRepetition(left - 1, p);
		}
	}
	
	private static void swap(char[] src, int i, int j) {
		char temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
	
	private static void swap(int[] src, int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}	
}
