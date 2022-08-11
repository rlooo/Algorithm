import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] gyu = new int[9];
	static int[] in = new int[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			g_win_cnt=0;
			g_lose_cnt=0;
			boolean[] check_gyu = new boolean[19];

			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				check_gyu[gyu[i]] = true;
			}
			
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (check_gyu[i] != true) {
					in[index++] = i;
				}
			}
			
			func(0);
			System.out.println("#"+test_case+" "+g_win_cnt+" "+g_lose_cnt);

		}

	}

	static int[] arr = new int[9];
	static boolean[] isused=new boolean[19];
	static int g_sum=0;
	static int i_sum=0;
	static int g_win_cnt=0;
	static int g_lose_cnt=0;
	
	static void func(int k) { // 현재 k개까지 수를 택했음
		if (k == 9) {// 9개를 모두 택했으면
			g_sum=0;
			i_sum=0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > arr[i]) {
					g_sum += gyu[i] + arr[i];
					
				} else {
					i_sum += gyu[i] + arr[i];
				}
			}
			if(g_sum>i_sum) {g_win_cnt++;}
			else if((g_sum<i_sum)){g_lose_cnt++;}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(!isused[in[i]]) { //아직 in[i]가 사용되지 않았으면
				arr[k]=in[i]; //k번째 수를 in[i]로 정함
				isused[in[i]]=true; //in[i]를 사용되었다고 표시
				func(k+1); // 다음 수를 정하러 한 단계 더 들어감
				isused[in[i]]=false; //k번째 수를 i로 정한 모든 경우에 대해 다 확인했으니 in[i]를 이제 사용되지 않았다고 명시함.
				
			}
		}
	}

}
