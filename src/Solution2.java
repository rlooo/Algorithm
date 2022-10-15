import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution2 {
    static ArrayList<Integer>[] list;
    static boolean[] visited = new boolean[13];
    static int[] dist = new int[13];

    public static void main(String[] args) {
        int[] music1 = { 10, 9, 4, 5, 12 };
        int[] music2 = { 6, 4, 2, 11 };
        // System.out.println(solution(music1));
        System.out.println(solution(music2));
    }

    public static int solution(int[] music) {

        list = new ArrayList[13];

        for (int i = 1; i < 13; i++) {
            list[i] = new ArrayList<>();

            if (i == 1) {
                list[i].add(2);
                list[i].add(3);
            }
            if (i == 2) {
                list[i].add(1);
                list[i].add(3);
            }
            if (i == 3) {
                list[i].add(1);
                list[i].add(2);
                list[i].add(4);
                list[i].add(5);
            }
            if (i == 4) {
                list[i].add(3);
                list[i].add(5);
            }
            if (i == 5) {
                list[i].add(3);
                list[i].add(4);
                list[i].add(6);
                list[i].add(7);
            }
            if (i == 6) {
                list[i].add(5);
                list[i].add(7);
            }
            if (i == 7) {
                list[i].add(5);
                list[i].add(6);
                list[i].add(8);
            }
            if (i == 8) {
                list[i].add(7);
                list[i].add(9);
                list[i].add(10);
            }
            if (i == 9) {
                list[i].add(8);
                list[i].add(10);
            }
            if (i == 10) {
                list[i].add(8);
                list[i].add(9);
                list[i].add(11);
                list[i].add(12);
            }
            if (i == 11) {
                list[i].add(10);
                list[i].add(12);
            }
            if (i == 12) {
                list[i].add(10);
                list[i].add(11);
            }
        }

        return bfs(music);
    }

    private static int bfs(int[] music) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        int index = 0;
        int cnt = 0;
        while (!q.isEmpty()) {

            Integer cur = q.poll();

            if (cur == music[index]) {

                cnt += dist[cur];

                for (int i = 0; i < visited.length; i++) {
                    visited[i] = false;
                    dist[i] = 0;
                }

                visited[cur] = true;
                index++;
            }

            if (index == music.length) {
                return cnt;
            }

            for (int i = 0; i < list[cur].size(); i++) {
                System.out.println("cur>>" + cur);
                System.out.println("list[cur].get(i)>>" + list[cur].get(i));
                System.out.println("visited");
                for (int j = 1; j < 13; j++) {

                    System.out.print(visited[j] + " ");
                }

                if (visited[list[cur].get(i)] != false)
                    continue;
                System.out.println("\nlist[cur].get(i)>>>" + list[cur].get(i));
                visited[list[cur].get(i)] = true;
                q.add(list[cur].get(i));
                dist[list[cur].get(i)] = dist[cur] + 1;

                System.out.println();
                System.out.println("dist");
                for (int j = 1; j < 13; j++) {
                    System.out.print(dist[j] + " ");
                }
                System.out.println();

            }
        }
        return cnt;

    }

}
