import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static String solution(String source) {

        String dest = "";
        int[] alphabet = new int[26];

        int cnt = source.length();
        for (int i = 0; i < source.length(); i++) {
            alphabet[source.charAt(i) - 'a']++;

        }

        List<Character> list = new LinkedList<>();
        while (cnt != 0) {

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0) {
                    cnt--;
                    list.add((char) (i + 'a'));
                    alphabet[i]--;
                }
            }

            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                dest += list.get(i);
            }

            list.clear();
        }

        return dest;
    }

    public static void main(String[] args) {

        System.out.println(solution("execute"));
        System.out.println(solution("cucumber"));
        System.out.println(solution("bbaabd"));
    }

}
