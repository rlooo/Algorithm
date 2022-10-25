import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " "); // 첫번째 줄

		int s = Integer.parseInt(st.nextToken()); // dna 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 부분문자열 길이

		String str = bf.readLine(); // 두번째 줄
		char[] ch = new char[s]; // CCTGGATTG
		ch = str.toCharArray();

		int[] cnt = new int[4];
		boolean flag = false;
		int res = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		} // 입력

		for (int i = 0; i < p; i++) {
			switch (ch[i]) {
			case 'A':
				cnt[0]--;
				break;
			case 'C':
				cnt[1]--;
				break;
			case 'G':
				cnt[2]--;
				break;
			case 'T':
				cnt[3]--;
				break;
			}

		}//처음 초기화
		for (int c : cnt) {
			if (c > 0) {
				flag = true; //부분문자열이 아니다
				break;
			}
		}
		res = flag == true ? res : res + 1;
		
		for (int i = 1; i <= s - p; i++) {
			flag=false;
			switch (ch[i - 1]) {
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
			switch (ch[p + i - 1]) {
			case 'A':
				cnt[0]--;
				break;
			case 'C':
				cnt[1]--;
				break;
			case 'G':
				cnt[2]--;
				break;
			case 'T':
				cnt[3]--;
				break;
			}
			for (int c : cnt) {
				if (c > 0) {
					flag = true; //부분문자열이 아니다
					break;
				}
			}
			res = flag == true ? res : res + 1;
		}
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
