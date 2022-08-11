
public class StackTest {

	public static void main(String[] args) {
		IStack<String> stack = new SsafyStack<String>();
		System.out.println(stack.isEmpty()+ "/"+stack.size());
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println("peek item : "+stack.peek());
		stack.pop();

	}

}
