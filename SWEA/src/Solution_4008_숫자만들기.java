import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	static int[] card = new int[4];
	static int[] number;
	static int N;
	static int min_res;
	static int max_res;
	static int[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/Solution_4008_숫자만들기.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			min_res = Integer.MAX_VALUE;
			max_res = Integer.MIN_VALUE;

			N = Integer.parseInt(in.readLine()); // 숫자의 개수
			number = new int[N];
			isSelected = new int[N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);

			sb.append("#" + test_case + " " + (max_res-min_res) + "\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void perm(int cnt) {
		int cal=number[0];
		if(cnt==N-1) {
			for(int i=1;i<N;i++) {
				if(isSelected[i-1]==0) { // + 일 때
					cal=cal+number[i];
				}else if(isSelected[i-1]==1) { // - 일 때
					cal=cal-number[i];
				}else if(isSelected[i-1]==2) { // * 일 때
					cal=cal*number[i];
				}else { // /일 때
					cal=cal/number[i];
				}
			}
			min_res = Integer.min(min_res, cal);
			max_res = Integer.max(max_res, cal);
			return;
		}
		for(int i=0;i<4;i++) {
			if(card[i]==0)continue;
			card[i]--;
			isSelected[cnt]=i;
			perm(cnt+1);
			card[i]++;
		}
		
	}
}
