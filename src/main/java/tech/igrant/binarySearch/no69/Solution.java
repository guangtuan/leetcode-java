package tech.igrant.binarySearch.no69;

class Solution {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            long curr = (long) middle * middle;
            if (curr <= x) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ans;
    }

}
