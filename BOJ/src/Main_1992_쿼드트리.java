import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static char[][] ch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		boolean flag = false;

		ch = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				ch[i][j] = str.charAt(j);
			}
		}

		func(0,0,N);

		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void func(int x, int y, int size) {
		if(isPossible(x, y, size)) {
			sb.append(ch[x][y]);
			return;
		}

		sb.append("(");
		//1사각형
		func(x,y,size/2);
		//2사각형
		func(x,y+size/2,size/2);
		//3사각형
		func(x+size/2,y,size/2);
		//4사각형
		func(x+size/2,y+size/2,size/2);

		sb.append(")");

	}
	private static boolean isPossible(int x, int y, int size) {
		int val = ch[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(val!=ch[i][j]) return false;
			}
		}
		return true;
	}

}
