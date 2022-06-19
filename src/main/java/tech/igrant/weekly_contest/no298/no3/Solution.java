package tech.igrant.weekly_contest.no298.no3;

import java.util.Arrays;

class Solution {

    public int longestSubsequence(String s, int k) {
        int kLen = Integer.toString(k, 2).length();
        int sLen = s.length();
        if (sLen < kLen) {
            return sLen;
        }
        // 110 比 00/01/10/11 等大，也可能比三位的二进制数(101)大
        // 要么是长度比 输入的 k 小的数字
        // 要么是长度和 输入的 k 相等的数字
        int ret = getNumberInSuffix(s, kLen, sLen) <= k ? kLen : kLen - 1;
        return ret + Math.toIntExact(Arrays.stream(s.substring(0, sLen - kLen).split("")).filter("0"::equals).count());
    }

    private static int getNumberInSuffix(String s, int kLen, int sLen) {
        // 111000110
        // 从 k 的长度倒着取
        String str = s.substring(sLen - kLen);
        if (str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str, 2);
    }

}
