package tech.igrant.weekly_contest.no292.no3;

/**
 * 一个 key 可以按三个数字
 * 按一次
 * a
 * 按两次
 * aa, b
 * 按三次
 * aaa, ab, ba, c
 * 第四次，就是在 一/二/三 次的基础上，各 +1，因此
 * f(n) = f(n-1) + f(n-2) + f(n-3)
 */
class Solution {

    static int mod = (int) (Math.pow(10, 9) + 7);
    static char seven = "7".charAt(0);
    static char nine = "9".charAt(0);

    public int countTexts(String pressedKeys) {
        long[] basicArray = new long[]{1, 1, 2, 4};
        long[] arr3 = new long[Math.max(pressedKeys.length() + 1, 4)];
        long[] arr4 = new long[Math.max(pressedKeys.length() + 1, 4)];
        System.arraycopy(basicArray, 0, arr3, 0, 4);
        System.arraycopy(basicArray, 0, arr4, 0, 4);
        for (int i = 4; i < arr3.length; i++) {
            arr3[i] = arr3[i - 1] + arr3[i - 2] + arr3[i - 3];
            arr3[i] = arr3[i] % mod;
        }
        for (int i = 4; i < arr4.length; i++) {
            arr4[i] = arr4[i - 1] + arr4[i - 2] + arr4[i - 3] + arr4[i - 4];
            arr4[i] = arr4[i] % mod;
        }
        int ret = 1;
        int repeatCount = 1;
        char basic = pressedKeys.charAt(0);
        for (int i = 1; i < pressedKeys.length(); i++) {
            char current = pressedKeys.charAt(i);
            if (basic == current) {
                repeatCount += 1;
            } else {
                ret = (int) (ret * cal(repeatCount, basic, arr3, arr4) % mod);
                basic = current;
                repeatCount = 1;
            }
        }
        ret = (int) (ret * cal(repeatCount, basic, arr3, arr4) % mod);
        return ret;
    }

    private long cal(int count, char flag, long[] arr3, long[] arr4) {
        if (flag == seven || flag == nine) {
            return arr4[count];
        } else {
            return arr3[count];
        }
    }

}
