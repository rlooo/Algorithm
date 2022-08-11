import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(bf.readLine());

			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < n; j++) {

					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] nr = { -1, 0, 1, 0 };
			int[] nc = { 0, -1, 0, 1 };

			int max_room = 0;
			int[][] visit = new int[n][n];
			int num=0;
			visit[0][0]=1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					for (int d = 0; d < 4; d++) {
						int dr = i + nr[d];
						int dc = j + nc[d];

						if (dr < 0 || dc < 0 || dr > n-1 || dc > n-1)
							continue;
						
						if (arr[i][j] + 1 == arr[dr][dc]) {
							System.out.println(arr[i][j]+" "+arr[dr][dc]);
							visit[dr][dc]=visit[i][j]+1;
							if (visit[dr][dc] > max_room) {
								max_room = visit[dr][dc];
								num=arr[i][j];
								System.out.println(num);
							}
							else if(visit[dr][dc]==max_room) {
								if(arr[dr][dc]<num) {
									arr[dr][dc]=num;
								}
							}

						}
					}
				}
			}

			System.out.println("#" + test_case +  " " +num+" "+ max_room);
 
		}

	}

}
