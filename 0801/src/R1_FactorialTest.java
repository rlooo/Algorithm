
public class R1_FactorialTest {
	//loop
	static void factorial(int n) {
		//(1)*5*4*3*2*1
		int res=1;
		for(int i=n;i>=1;i--) {
			res*=i; // 반복적인 일
		}
		System.out.println(res);
	}
	
	static int res=1;
	static void factorial2(int n) {
		if(n==1) {System.out.println(res); return;}
		res*=n;
		factorial2(n-1);
	}
	
	public static void main(String[] args) {
		factorial(5);
		factorial2(5);
	}
}
