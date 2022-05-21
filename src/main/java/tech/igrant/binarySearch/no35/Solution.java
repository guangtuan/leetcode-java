package tech.igrant.binarySearch.no35;

class Solution {

    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (mid >= nums.length) {
            return mid;
        }
        if (left > right) {
            return mid;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid - 1);
        }
    }

}
