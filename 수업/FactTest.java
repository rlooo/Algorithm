package bo0811;
// 재귀 - recursion - 자신이 자신을 호출
// for while -end condition!!
// int 2100000000
// long 9000000000000000000
// 10! 
// 1000000000 반복 0.7
// 5! = 5*4!
// f(5)= 5* f(4)
public class FactTest {
	
	public static void main(String[] args) {
		
		for (int i = 0; i <13; i++) {
			System.out.println(fact(i));
		}
	}
	// recursion -> stack dfs -> call stack
	// f(5) -> f(4) -> f(3) -> .... -> f(1)
	private static int fact(int n) {
		if(n==1 || n==0) return 1;
		else return n*fact(n-1);
	}
	
}
