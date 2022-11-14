import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {
    static int L, R, C;
    static int[][][] building;

public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(in.readLine());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    building = new int[C+1][R+1][L+1];

    for (int z = 1; z <= L; z++) {
        for (int y = 1; y <= R; y++) {
            for (int x = 1; x <= C; x++) {
                building[x][y][z];
            
            }
        }
    }
}
}