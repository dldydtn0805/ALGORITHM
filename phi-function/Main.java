import java.io.*;
import java.util.*;

public class Main {

    static long phi (long n) {
        long result = n;
        for (long p = 2; p*p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) n /= p;
                // 오일로 피 함수 : 전체 개수에서 p의 배수들을 제거한다. : 시간복잡도 : 소인수 분해 시간과 같다
                // result = result * (1-1/p);
                // ex) 12의 경우
                // 12의 배수 중에서 2의 배수는 6개, 12 - 6(12/2) = 6
                // 6의 배수 중에서 3의 배수는 2개, 6 - 2(6/3) = 4
                result = result - result/p;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(phi(N));
    }
}

