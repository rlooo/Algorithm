import java.awt.image.SinglePixelPackedSampleModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int S,N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		func();
		
	}
	private static void func(int cnt) {
		if(cnt==)
		
	}
}
