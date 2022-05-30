package tech.igrant.binarySearch.no367;

class Solution {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (right >= left) {
            int middle = (right - left) / 2 + left;
            long produce = (long) middle * middle;
            if (produce == num) {
                return true;
            }
            if (produce > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

}
