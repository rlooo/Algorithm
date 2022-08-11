import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			char[][] arr = new char[h][w];

			for (int i = 0; i < h; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			int n = Integer.parseInt(br.readLine());

			char[] input = new char[n];
			input = br.readLine().toCharArray();

			char status = '^';
			int row = -1;
			int col = -1;
			for (int i = 0; i < h; i++) { // 초기화
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
						status = arr[i][j];
						row = i;
						col = j;
						break;
					}
				}
			}
			int shot_row = row;
			int shot_col = col;

			for (int i = 0; i < n; i++) {

				if (input[i] == 'U') {
					status = '^';
					if (row > 0 && arr[row - 1][col] == '.') {
						arr[row][col] = '.';
						row = row - 1;
						
						
					}
				} else if (input[i] == 'D') {
					status = 'v';
					if (row < h - 1 && arr[row + 1][col] == '.') {
						arr[row][col] = '.';
						row = row + 1;
						
					}

				} else if (input[i] == 'L') {
					status = '<';
					if (col > 0 && arr[row][col - 1] == '.') {
						arr[row][col] = '.';
						col = col - 1;
						
					}

				} else if (input[i] == 'R') {
					status = '>';
					if (col < w - 1 && arr[row][col + 1] == '.') {
						arr[row][col] = '.';
						col = col + 1;
						
					}
				}
				else if (input[i] == 'S') {
					shot_row = row;
					shot_col=col;
					if (status == '^') {
						while (true) {
							shot_row--;
							if(shot_row < 0) break;
							
							if (arr[shot_row][shot_col] == '*') {
								arr[shot_row][shot_col] = '.';
								
								break;
							}
							if (arr[shot_row][shot_col] == '#') {
								break;
							}
						}

					} else if (status == 'v') {
						while (true) {
							shot_row++;
							if(shot_row >= h) break;
							
							if (arr[shot_row][shot_col] == '*') {
								arr[shot_row][shot_col] = '.';
				
								break;
							}
							if (arr[shot_row][shot_col] == '#') {
								break;
							}
						}

					} else if (status == '<') {
						while (true) {
							shot_col--;
							if(shot_col < 0) break;
							
							if (arr[shot_row][shot_col] == '*') {
								arr[shot_row][shot_col] = '.';
								
								break;
							}
							if (arr[shot_row][shot_col] == '#') {
								break;
							}
						}

					} else if (status == '>') {
						while (true) {
							shot_col++;
							if(shot_col >= w) break;
						
							if (arr[shot_row][shot_col] == '*') {
								arr[shot_row][shot_col] = '.';
								break;
							}
							if (arr[shot_row][shot_col] == '#') {
								break;
							}
						}

					}
					shot_row=row;
					shot_col=col;

				}
			}
			arr[row][col]=status;
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < h; i++) { 
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

}
