package tech.igrant.weekly_contest.no292.no3;

class Solution {
    public int countTexts(String pressedKeys) {
        int ret = 1;
        int mod = (int) (Math.pow(10, 9) + 7);
        int i = 0;
        int j = 1;
        String s1 = null;
        String s2 = null;
        while (true) {
            s1 = String.valueOf(pressedKeys.charAt(i));
            if (j == pressedKeys.length()) {
                System.out.println("last one");
                ret = cal(ret, j - i + 1, s1, mod);
                return ret;
            } else {
                s2 = String.valueOf(pressedKeys.charAt(j));
            }
            if (!s1.equals(s2)) {
                ret = cal(ret, j - i, s1, mod);
                i = j + 1;
                j = i + 1;
                System.out.println("start with " + i);
            } else {
                j = j + 1;
            }
        }
    }

    private int cal(int ret, int i, String number, int mod) {
        System.out.println("count is " + i);
        System.out.println("number is " + number);
        System.out.println("done");
        // 1 -> 1
        // 1

        // 2 -> 2
        // 1+1, 2

        // 3 -> 4
        // 1+1+1,
        // 1+2, 2+1
        // 3

        // 4 -> 7
        // 1+1+1+1,
        // 1+1+2, 1+2+1, 2+1+1,
        // 2+2,
        // 3+1, 1+3

        // 5 -> 13
        // 1+1+1+1+1,
        // 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1
        // 1+2+2, 2+1+2, 2+2+1
        // 1+1+3, 1+3+1, 3+1+1
        // 2+3, 3+2
        // 4+1, 1+4

        // f(n, 3)
        // f(n, 4)

        return 0;
    }
}
