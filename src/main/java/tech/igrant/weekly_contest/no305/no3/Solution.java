package tech.igrant.weekly_contest.no305.no3;

public class Solution {

    public boolean validPartition(int[] nums) {
        return interval(nums, new Range(0, nums.length));
    }

    private static class Range {
        private final int start;
        private final int endExclusive;
        private final int size;

        public Range(int start, int endExclusive) {
            this.start = start;
            this.endExclusive = endExclusive;
            this.size = endExclusive - start;
        }

        public Range case1Tail() {
            return new Range(endExclusive - 3, endExclusive);
        }

        public Range case1Prev() {
            return new Range(0, endExclusive - 3);
        }

        public Range case2Tail() {
            return new Range(endExclusive - 2, endExclusive);
        }

        public Range case2Prev() {
            return new Range(0, endExclusive - 2);
        }
    }

    private boolean singleValid(int[] nums, Range range) {
        return same(nums, range) || increase(nums, range);
    }

    private boolean interval(int[] nums, Range range) {
        if (range.size <= 3) {
            return singleValid(nums, range);
        } else {
            return singleValid(nums, range.case1Tail()) && interval(nums, range.case1Prev()) ||
                    singleValid(nums, range.case2Tail()) && interval(nums, range.case2Prev());
        }
    }

    private boolean increase(int[] nums, Range range) {
        if (range.size != 3) {
            return false;
        }
        return (nums[range.start + 2] == nums[range.start + 1] + 1)
                && (nums[range.start + 1] == nums[range.start] + 1);
    }

    private boolean same(int[] nums, Range range) {
        if (range.size == 2) {
            return nums[range.start] == nums[range.start + 1];
        }
        if (range.size == 3) {
            return (nums[range.start] == nums[range.start + 1]) &&
                    (nums[range.start + 1] == nums[range.start + 2]);
        }
        return false;
    }

}
