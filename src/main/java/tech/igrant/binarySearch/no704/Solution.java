package tech.igrant.binarySearch.no704;

class Solution {

    // [0,3] m = 1
    // [0,0], [2,3]
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1, nums.length / 2);
    }

    private int search(int[] nums, int target, int left, int right, int mid) {
        return left > right ? -1 :
                nums[mid] == target ?
                        mid :
                        nums[mid] < target ?
                                search(nums, target, mid + 1, right, (mid + 1 + right) / 2) :
                                search(nums, target, left, mid - 1, (left + mid - 1) / 2);
    }

}
