package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_타겟넘버 {
	static int n;
	static int[] temp_numbers;
	static boolean[] visited;
	static int answer=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr= {1,1,1,1,1};
		int target = 3;
		
		
		System.out.println(solution(arr,target));
	}
	public static int solution(int[] numbers, int target) throws NumberFormatException, IOException {
		n = numbers.length;
		int answer=0;
		temp_numbers = new int[n * 2];
		visited = new boolean[n * 2];

		int[] isSelected = new int[n];

		int index=0;
		for (int i = 0; i < n;i++) {
			temp_numbers[index++] = numbers[i];
			temp_numbers[index++] = -numbers[i];
		}


		answer = dfs(0, isSelected, temp_numbers,target);

		return answer;
	}

	private static int dfs(int cnt, int[] isSelected, int[] temp_numbers, int target) {
		if (cnt == n) {
			int sum = 0;
			for (int i = 0; i < isSelected.length; i++) {
				sum += isSelected[i];
				
			}

			if (sum == target)
				answer++;
			
			return answer;
		}
		for (int i = 0; i < temp_numbers.length; i++) {
			if (visited[i] == true)
				continue;
			if(i%2==1) {
				if(visited[i-1]==true)continue;
			}
			if(i%2==0) {
				if(visited[i+1]==true)continue;
			}
			if(i==2*cnt||i==2*cnt+1) {
			visited[i] = true;
			isSelected[cnt] = temp_numbers[i];
			dfs(cnt + 1, isSelected, temp_numbers, target);
			visited[i] = false;
			}
		}
		return answer;

	}

}
