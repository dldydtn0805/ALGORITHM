import java.io.*;
import java.util.*;

public class Main {
    static int[] buildPi (String pattern) {
        int M = pattern.length();
        int[] pi = new int[M];
        int j = 0;
        for (int i = 1; i < M; i ++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static List<Integer> kmp (String text, String pattern) {
        int[] pi = buildPi(pattern);
        List<Integer> result = new ArrayList<>();
        int N = text.length(), M = pattern.length();
        int j = 0;
        for (int i = 0; i < N; i ++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (++j == M) {
                    result.add(i - M + 1);
                    j = pi[j-1];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        List<Integer> results = kmp(text, pattern);
        StringBuilder ans = new StringBuilder();
        ans.append(results.size()).append('\n');
        for (int result : results) {
            ans.append(result+1).append(' ');
        }
        System.out.println(ans.toString().trim());

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
