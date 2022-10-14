import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
    static int[][] map;
    static Shark[] sharks;
    static int res = 0;
    static int person = 0;
    static int R, C, M;
    static Queue<Shark> q = new PriorityQueue<>();

    static class Shark implements Comparable<Shark> {
        int r;
        int c;
        int s;
        int d;
        int z;
        int index;

        Shark(int r, int c, int s, int d, int z, int index) {
            this.r = r; // 상어 위치
            this.c = c; // 상어 위치
            this.s = s; // 속력
            this.d = d; // 이동 방향
            this.z = z; // 크기
            this.index = index;
        }

        @Override
        public int compareTo(Shark s) {
            if (this.c == s.c) {
                if (this.r == s.r) {
                    if (this.z > s.z) {
                        s.index = -1;
                        System.out.println("먹힘>>" + this.r + " " + s.z);
                    } else if (this.z < s.z) {
                        this.index = -1;
                        System.out.println("먹힘>>" + s.r + " " + this.z);
                    }
                }
                return this.r - s.r;
            }
            return this.c - s.c;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z, i);
        }

        while (person <= C) {
            person++;
            bfs();
        }

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs() {

        for (int i = 0; i < sharks.length; i++) {
            if (sharks[i].c == person) {
                if (sharks[i].index == -1)
                    continue;
                q.add(new Shark(sharks[i].r, sharks[i].c, sharks[i].s, sharks[i].d, sharks[i].z, i));
            }
        }

        Shark cur = q.poll();

        while (cur.index == -1) {
            System.out.println("죽은 상어");
            System.out.println(cur.r + " " + cur.c + " " + cur.s + " " + cur.index);
            cur = q.poll();
        }

        res += cur.z;
        System.out.println("res " + res + " cur.z " + cur.z);
        System.out.println(cur.r + " " + cur.c + " " + cur.s + " " + cur.index);
        sharks[cur.index].index = -1;

        for (int i = 0; i < sharks.length; i++) {
            if (sharks[i].index == -1)
                continue;

            int nr = sharks[i].r;
            int nc = sharks[i].c;

            if (sharks[i].d == 1) { // 위
                nr = sharks[i].r - sharks[i].s;
                System.out.println("위 " + nr);
            } else if (sharks[i].d == 2) { // 아래
                nr = sharks[i].r + sharks[i].s;
                System.out.println("아래 " + nr);
            } else if (sharks[i].d == 3) { // 오른쪽
                nc = sharks[i].c + sharks[i].s;
                System.out.println("오른쪽 " + nc);
            } else if (sharks[i].d == 4) { // 왼쪽
                nc = sharks[i].c - sharks[i].s;
                System.out.println("왼쪽 " + nc);
            }

            if (nr < 1) {
                sharks[i].d = -sharks[i].d;
                nr = 1 - (sharks[i].r - sharks[i].s);
                System.out.println("nr<1 " + nr);
            } else if (nc < 1) {
                sharks[i].d = -sharks[i].d;
                nc = 1 - (sharks[i].r - sharks[i].c);
                System.out.println("nc<1 " + nr);
            } else if (nr > R) {
                sharks[i].d = -sharks[i].d;
                nr = 2 * R - sharks[i].r - sharks[i].c;
                System.out.println("nr<R " + nr);
            } else if (nc > C) {
                sharks[i].d = -sharks[i].d;
                nc = 2 * C - sharks[i].c - sharks[i].c;
                System.out.println("nr>C " + nc);
            }

            q.add(new Shark(nr, nc, sharks[i].s, sharks[i].d, sharks[i].z, i));

        }

    }

}
