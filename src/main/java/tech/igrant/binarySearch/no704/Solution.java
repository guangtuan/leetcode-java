package tech.igrant.binarySearch.no704;

class Solution {

    // [0,3] m = 1
    // [0,0], [2,3]
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2 + left;
        return nums[middle] == target ?
                middle :
                nums[middle] < target ?
                        search(nums, middle + 1, right, target) :
                        search(nums, left, middle - 1, target);
    }

}
