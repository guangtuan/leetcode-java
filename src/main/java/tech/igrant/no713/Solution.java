package tech.igrant.no713;

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            count = count + right - left + 1;
            right = right + 1;
        }
        return count;
    }

}
