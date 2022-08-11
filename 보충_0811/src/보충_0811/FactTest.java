package 보충_0811;
// 재귀- recursion - 자신이 자신을 호출
// for while을 사용하지 않은 반복문 - end condition!!
// int 2100000000
// long 9000000000000000000
// 정수의 기본은 int이기 때문에 long 쓰려면 l을 써야 함.
// 10!
// 1000000000 반복 0.7초
// 5! = 5*4!
//f(5) = 5*f(4) 관계식 뽑아내기
public class FactTest {

	public static void main(String[] args) {
		
		for(int i=0;i<13;i++) {
			System.out.println(fact(i));
		}	}

	//recursion -> stack dfs -> call stack
	// f(5) -> f(4) -> f(3) -> .... -> f(1)
	// dfs 꼭 알아야 됨
	// dfs의 단점: 터질 수 있다.
	// 갈 수 있는데 그 최단 구할 때는 bfs가 좋다. 갈 수 있냐 없냐 같이 판별하는 문제는 dfs를 쓴다.
	private static int fact(int n) {
		if(n==0||n==1) return 1;
		else return n*fact(n-1);
	}

}
