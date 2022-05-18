package tech.igrant.binarySearch.no704;

class Solution {

    // [0,3] m = 1
    // [0,0], [2,3]
    public int search(int[] nums, int target) {
        QuadFunction quadFunction = new QuadFunction() {
            public int search(int[] nums, int target, int left, int right) {
                int mid = (right - left) / 2 + left;
                return left <= right ?
                        nums[mid] != target ?
                                nums[mid] < target ?
                                        search(nums, target, mid + 1, right) :
                                        search(nums, target, left, mid - 1)
                                : mid
                        : -1;
            }
        };
        return quadFunction.search(nums, target, 0, nums.length - 1);
    }

    private interface QuadFunction {
        int search(int[] nums, int target, int left, int right);
    }

}
