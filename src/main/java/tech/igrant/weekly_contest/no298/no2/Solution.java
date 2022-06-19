package tech.igrant.weekly_contest.no298.no2;

class Solution {

    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= 10 && k * i <= num; i++) {
            if ((num - (k * i)) % 10 == 0) {
                return i;
            }
        }
        return -1;
    }

}
