import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
    static ArrayList<Integer>[] pre;
    static ArrayList<Integer>[] nxt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int M = Integer.parseInt(in.readLine());
            pre = new ArrayList[N + 1];
            nxt = new ArrayList[N + 1];
            for (int i = 0; i < N; i++) {
                pre[i] = new ArrayList<>();
                nxt[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int from =Integer.parseInt(st.nextToken();
                int to = Integer.parseInt(st.nextToken();
             pre[from].add(to);
             nxt[to].add(from);
            }

            for(int i=1;i<=N;i++){
                boolean[] check = new boolean[N+1];
                for(int j=0;j<pre[i].size();j++){
                    check[pre[i].get(j)]=true;
                }
                for(int j=0;j<nxt[i].size();j++){
                    check[nxt[i].get(j)]=true;
                }
            }
           
            sb.append("#" + tc + " " + tc);
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
