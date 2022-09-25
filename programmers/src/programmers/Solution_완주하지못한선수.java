package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Solution_완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		for (String name : participant) {
			if(map.get(name)!=null) {
				map.put(name, map.get(name)+1);
			}
			else {map.put(name,1);}
		}
		
		for (String name : completion) {
			map.put(name, map.get(name)-1);
		}
	
		
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			if(map.get(key)>0) {
				answer=key;
			}
		}
		System.out.println(answer);

		return answer;
	}
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		solution(participant,completion);
		
	}
}
