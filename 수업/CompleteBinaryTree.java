import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int SIZE;

	public CompleteBinaryTree(int size) {

		SIZE = size;
		nodes = new char[size + 1]; // 1 인덱스부터 사용
	}

	public boolean add(char e) { // 완전이진트리에 맞게 추가
		if (lastIndex == SIZE) {
			return false;
		}
		nodes[lastIndex++] = e;
		return true;
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트 노드 인덱스 부터

		while (!queue.isEmpty()) { // 방문대상이 있을 때까지 반복
			int current = queue.poll(); // 방문자라면 대상 정보 꺼내기
			System.out.println(nodes[current] + 'A');

			// 현재 방문 노드의 자식 노드들을 대기열에 넣기
			if (current * 2 <= lastIndex) {
				queue.offer(current * 2);
			} // 왼쪽 자식
			if (current * 2 + 1 <= lastIndex) {
				queue.offer(current * 2 + 1);
			} // 오른쪽 자식
		}
		System.out.println();

	}

	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트 노드 인덱스 부터

		while (!queue.isEmpty()) { // 방문대상이 있을 때까지 반복
			int size = queue.size();
			
			while (--size >= 0) {
				int current = queue.poll(); // 방문자라면 대상 정보 꺼내기
				System.out.println(nodes[current] + 'A');

				// 현재 방문 노드의 자식 노드들을 대기열에 넣기
				if (current * 2 <= lastIndex) {
					queue.offer(current * 2);
				} // 왼쪽 자식
				if (current * 2 + 1 <= lastIndex) {
					queue.offer(current * 2 + 1);
				} // 오른쪽 자식
			}
			System.out.println();
		}
		System.out.println();

	}

	public void dfs() {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(1); // 루트 노드 인덱스 부터

		while (!stack.isEmpty()) { // 방문대상이 있을 때까지 반복
			int current = stack.pop(); // 방문자라면 대상 정보 꺼내기
			System.out.println(nodes[current] + 'A');

			// 현재 방문 노드의 자식 노드들을 대기열에 넣기
			if (current * 2 <= lastIndex) {
				stack.push(current * 2);
			} // 왼쪽 자식
			if (current * 2 + 1 <= lastIndex) {
				stack.push(current * 2 + 1);
			} // 오른쪽 자식
		}
		System.out.println();

	}

}
