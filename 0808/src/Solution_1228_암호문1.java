import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int test_case=1;test_case<=10;test_case++) {
			int n = Integer.parseInt(bf.readLine()); //원본 암호문의 길이 n
			LinkedList<String> list = new LinkedList<String>(); //원본 암호문
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i=1;i<=n;i++) {
				list.add(st.nextToken());
			}
			
			int num = Integer.parseInt(bf.readLine()); // 명령어의 개수
			st = new StringTokenizer(bf.readLine(), " "); // 명령어
			
			for(int i=1;i<=num;i++) {
				st.nextToken(); // I문자
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int j=0;j<y;j++) {
					list.add(x+j, st.nextToken());
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
			
		}
		

	}

}
