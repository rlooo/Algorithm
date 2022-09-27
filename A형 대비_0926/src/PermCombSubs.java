
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

//nPr, nCr, 2^n
public class PermCombSubs {

	static int N=4, R=3, C=0; //C는 count 할 때
	static int[] a = {1,2,3,4}, b=new int[R];
	static boolean[] v = new boolean[N];
	public static void main(String[] args) {
		perm(0); //순열 4P3=4*3*2*1

	}
	private static void perm(int depth) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i]=true;
			b[depth]=a[i];
			perm(depth+1);
			v[i]=false;
		}
		
	}

}
