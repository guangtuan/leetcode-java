package tech.igrant.binarySearch.no704;

class Solution {

    // [0,3] m = 1
    // [0,0], [2,3]
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int val = nums[middle];
            if (val == target) {
                return middle;
            } else {
                if (val < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

}
