import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " "); // 첫번째 줄
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		String str = bf.readLine(); // 두번째 줄
		char[] ch = new char[s]; //CCTGGATTG
		ch = str.toCharArray();

		int[] cnt = new int[4];
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
		
		int num=0;
		int type=4;
		int type2=0;
		st = new StringTokenizer(bf.readLine(), " ");
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]!=0)type2++;
			cnt[i]-=arr[i];
			if(cnt[i]==0)type--;
			num+=arr[i];
		}
		
		p-=num;
		int result = Math.pow(type, p)*
		
		
		

	}

}
