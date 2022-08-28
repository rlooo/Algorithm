import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class Pair implements Comparable<Pair>{
		int node;
		int weight;

		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			return this.weight-o.weight; //가중치에 대한 오름차순 정렬
		}
	}
	
	static boolean[] visited;
	static ArrayList<Pair>[] arr;
	static long res=0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			res=0;
			st = new StringTokenizer(in.readLine(), " ");

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			visited = new boolean[V+1];
			arr = new ArrayList[V+1];
			
			for(int i=1;i<=V;i++) {
				arr[i] = new ArrayList<>();
			} //할당
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine(), " ");

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				arr[A].add(new Pair(B,C));
				arr[B].add(new Pair(A,C));
			}
			
			prim(1);
			sb.append(res+"\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void prim(int start) {
		Queue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(start,0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(visited[p.node]) continue;
			
			visited[p.node]=true;
			res+=p.weight;
			pq.add(p);
			
			for(int i=0 ; i<arr[p.node].size();i++) {
				Pair next = arr[p.node].get(i);
				int next_node = arr[p.node].get(i).node;
				if(!visited[next_node]) {
					pq.add(next);
				}
			}
			
		}
		
	}
}
