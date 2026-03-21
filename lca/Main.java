import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int MAX = 18;
    static int[] depth;
    static int[][] parents;
    static List<List<Integer>> graph;
    static void build (int idx, int prev) {
        for (int next : graph.get(idx)) {
            if (next != prev) {
                depth[next] = depth[idx] + 1;
                parents[next][0] = idx;
                build(next, idx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = read();
        graph = new ArrayList<>();
        depth = new int[N+1];
        parents = new int[N+1][MAX];
        for (int i = 0; i < N+1; i ++) {
            for (int j = 0; j < MAX; j ++) {
                parents[i][j] = -1;
            }
        }
        for (int i = 0; i < N+1; i ++) {
            graph.add(new ArrayList<>());
        }
        parents[1][0] = 0;
        for (int i = 0 ; i < N-1; i ++) {
            int from = read();
            int to = read();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        build(1, 0);
        // parents 배열 전이
        for (int j = 0; j < MAX; j ++) {
            for (int i = 1; i < N+1; i ++) {
                if (parents[i][j] != -1) {
                    parents[i][j+1] = parents[parents[i][j]][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int query = read();
        for (int i = 0; i < query; i ++) {
            int u = read();
            int v = read();
            if (depth[u] < depth[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            int diff = depth[u] - depth[v];
            // 깊이 차이를 없애며 u를 이동 시키기
            for (int j = 0; diff > 0; j ++) {
                if (diff % 2 == 1) u = parents[u][j];
                diff /= 2;
            }
            if (u != v) {
                // 높이 2^17 , 2^16 ... , 1 순으로 시도
                for (int j = MAX-1; j >= 0; j --) {
                    if (parents[u][j] != -1 && parents[u][j] != parents[v][j]) {
                        u = parents[u][j];
                        v = parents[v][j];
                    }
                }
                // 두 정점 u, vd의 부모가 같으므로 한번 더 올리기
                u = parents[u][0];
            }
            sb.append(u).append('\n');
        }
        System.out.println(sb.toString().trim());
    }

    // fast reader
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}