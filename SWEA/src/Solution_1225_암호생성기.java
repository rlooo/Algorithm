import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case=1;test_case<=10;test_case++) {
			int test_num = Integer.parseInt(bf.readLine());
			
			String str = bf.readLine();
			st = new StringTokenizer(str," ");
			
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int temp=0;
			int cnt=1;
			while(true) {
				
					temp = q.poll()-cnt;
					if(temp<=0) {q.add(0);break;}
					q.add(temp);
					cnt++;
					if(cnt>5)cnt=1;
				
			}

			
			System.out.print("#"+test_case+" ");
			while(q.size()!=0) {
				System.out.print(q.remove()+" ");
			}
			System.out.println();
			
			
			
		}

	}

}
