import java.util.Arrays;

public class DiceTest {
	public static void main(String[] args) {
		static int N, totalCnt;
		static int[] numbers;
		

	}
		//주사위 던지기1: 중복순열
				private static void dice1(int cnt) {
					if(cnt==N) {
						System.out.println(Arrays.toString(numbers));
						return;
					}
					// 가능한 모든 수 시도(주사위는 1~6)
					for (int i = 1; i <= 6; i++) {
						//수의 중복선택이 가능하므로 중복체크 필요없음
						//해당 수 선택
						numbers[cnt]=i;
						//다음 주사위던지러 가기
						dice1(cnt+1);
						
					}
				}
		
	}
	

}
