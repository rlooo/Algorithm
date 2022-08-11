import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case=1;test_case<=10;test_case++) {
			int len = Integer.parseInt(bf.readLine());
			
			Stack<String> stack = new Stack();
			
			String str = bf.readLine();
			char[] ch = str.toCharArray();
			
			boolean check=true;
			for(char c:ch) {
				if(c=='{'||c=='['||c=='('||c=='<') {
					stack.add(c+"");
				}
				else if(c=='}') {
					if(stack.peek().equals("{")) {
						stack.pop();
					}
					else {
						check=false;
						break;
					}
				}
				else if(c==']') {
					if(stack.peek().equals("[")) {
						stack.pop();
					}
					else {
						check=false;
						break;
					}
				}
				else if(c==')') {
					if(stack.peek().equals("(")) {
						stack.pop();
					}
					else {
						check=false;
						break;
					}
				}
				else if(c=='>') {
					if(stack.peek().equals("<")) {
						stack.pop();
					}
					else {
						check=false;
						break;
					}
				}
			}
			if(stack.size()!=0||check==false) {
				System.out.println("#"+test_case+" "+0);
			}
			else {
				System.out.println("#"+test_case+" "+1);
			}

		}
	}

}
