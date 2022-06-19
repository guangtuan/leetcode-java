package tech.igrant.weekly_contest.no298.no1;

class Solution {

    public String greatestLetter(String s) {
        int mask1 = 0x10;
        int mask2 = 0x01;
        int start1 = "a".charAt(0);
        int start2 = "A".charAt(0);
        int[] st = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                st[c - start1] = st[c - start1] | mask1;
            } else if (Character.isUpperCase(c)) {
                st[c - start2] = st[c - start2] | mask2;
            }
        }
        int result = getResult(st, mask1 | mask2);
        return result == -1 ? "" : Character.toString(result + start2);
    }

    int getResult(int[] st, int mask) {
        for (int i = 25; i >= 0; i--) {
            if (st[i] == mask) {
                return i;
            }
        }
        return -1;
    }

}
