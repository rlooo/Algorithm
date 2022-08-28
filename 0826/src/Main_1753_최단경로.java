import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int from;
	int w;

	Node(int from, int w) {
		this.from = from;
		this.w = w;
	}
}

public class Main_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int INF = Integer.MAX_VALUE;

		st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(in.readLine()); // 시작 정점 번호

		int[] dist = new int[V + 1]; // 최소 거리를 저장할 배열
		boolean[] visited = new boolean[V + 1]; // 방문 여부를 확인할 boolean 배열

		ArrayList<Node>[] nodeList = new ArrayList[V + 1]; // 1-index
		for (int i = 0; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			nodeList[to].add(new Node(from, w));
		} // 입력

		for (int i = 0; i <= V; i++) {
			dist[i] = INF;
		} // 최소 거리 정보를 담을 배열 초기화
		dist[K] = 0; // 출발 지점의 비용은 0으로 시작한다.

		// 다익스트라 알고리즘 진행
		// 모든 노드를 방문하면 종료하기 때문에 노드의 개수만큼만 반복한다.
		for (int i = 0; i < V; i++) {
			// 4-1. 현재 거리 비용 중 최소인 지점을 선택한다.
			// 해당 노드가 가지고 있는 현재 비용
			int nodeValue = Integer.MAX_VALUE;
			// 해당 노드의 번호
			int nodeIdx = 0;
			for (int j = 1; j <= V; j++) { // 1-index
				// 해당 노드를 방문 하지 않았고 현재 모든 거리 비용 중 최솟값을 찾는다.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			//최종 선택된 노드를 방문처리 한다.
			visited[nodeIdx]=true;
			
			//4-2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
			for(int j=0;j<nodeList[nodeIdx].size();j++) {
				//인접 노드를 선택한다.
				Node adjNode = nodeList[nodeIdx].get(j);
				// 인접 노드가 현재 가지는 최소 비용과
				// 현재 선택된 노드의 값  + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
				if(dist[adjNode.from]>dist[nodeIdx]+adjNode.w) {
					dist[adjNode.from]=dist[nodeIdx]+adjNode.w;
				}
			}
		}
		//최종 비용 출력
		for(int i=1;i<V+1;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF"+"\n");
			}
			else {
				sb.append(dist[i]+"\n");
			}
			
		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

}
