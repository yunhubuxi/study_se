package dp;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class MinCoin {

    static int dep = 0;
    static Map<Integer, Integer> dict = new HashMap<>();

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int m = 5004;
        long start = System.currentTimeMillis();
        System.out.println("结果是：" + coinCoin(a, m));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println("结果是：" + coinCoin_new(a, m));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    private static int coinCoin(int[] a, int m) {
        if (dict.get(m) != null) {
            return dict.get(m);
        }
        // System.out.println(dep++);
        if (m == 0) {
            return 0;
        }
        if (m < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i : a) {
            int x = coinCoin(a, m - i);
            if (x == -1) {
                continue;
            }
            res = Integer.min(res, x + 1);
        }
        if (res != Integer.MAX_VALUE) {
            dict.put(m, res);
            return res;
        } else {
            return -1;
        }
    }

    private static int coinCoin_new(int[] array, int m) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = m + 1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int a : array) {
                if (i - a < 0) {
                    continue;
                }
                dp[i] = Integer.min(dp[i], 1 + dp[i - a]);
            }
        }
        // for (int i : dp) {
        //     System.out.println(i);
        // }
        return dp[m] == m + 1 ? -1 : dp[m];
    }

}
