import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " "); // 첫번째 줄

		int s = Integer.parseInt(st.nextToken()); // dna 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 부분문자열 길이

		String str = bf.readLine(); // 두번째 줄
		char[] ch = new char[s]; // CCTGGATTG
		ch = str.toCharArray();

		int[] cnt = new int[4];
		int[] mycnt = new int[4];
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
		}

		int start = 0;
		int end = ch.length - 1;
		int num = 0;

		
		for(int i=start;i<=end;i++) {
			switch (ch[i]) {
			case 'A':
				mycnt[0]++;
				break;
			case 'C':
				mycnt[1]++;
				break;
			case 'G':
				mycnt[2]++;
				break;
			case 'T':
				mycnt[3]++;
				break;
			}	
		}
		for(int i=0;i<mycnt.length;i++) {
			if(mycnt[i]!=0) {
				start++;
			}
		}
		
		
		
		

		System.out.println(num + " " + start + " " + end);

		if (end - start < p) {
			// 최소 문자열 구해짐
			// 조합 경우의 수 구해야됨

		}

	}

}
