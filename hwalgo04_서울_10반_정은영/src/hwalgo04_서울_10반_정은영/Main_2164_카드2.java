package hwalgo04_서울_10반_정은영;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main_2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(bf.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.remove();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
		

	}

}
