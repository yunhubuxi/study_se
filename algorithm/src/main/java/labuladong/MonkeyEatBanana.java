package labuladong;

/**
 * 吃香蕉问题
 */
public class MonkeyEatBanana {
    public static void main(String[] args) {
        int[] piles = {3, 5, 3, 8, 9, 12};
        System.out.println(minEatingSpeed(piles, 10));


    }

    private static int minEatingSpeed(int[] piles, int H) {
        if (H < piles.length) {
            return -1;
        }
        int max = getMax(piles);
        for (int speed = 1; speed < max; speed++) {
            if (canFinish(piles, speed, H)) {
                return speed;
            }
        }
        return max;
    }

    private static int minEatingSpeed2(int[] piles, int H) {
        if (H < piles.length) {
            return -1;
        }
        int max = getMax(piles);
        int left = 1, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return max;
    }

    private static int getMax(int[] pilse) {
        int max = Integer.MIN_VALUE;
        for (int i : pilse) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, speed);
        }
        return time <= H;
    }

    private static int timeOf(int n, int speed) {
        return n / speed + (n % speed > 0 ? 1 : 0);
    }
}
