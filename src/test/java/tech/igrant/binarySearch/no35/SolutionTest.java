package tech.igrant.binarySearch.no35;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[] nums, int target, int exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{1, 3, 5, 6}, 5, 2),
            new TestCase(new int[]{1, 3, 5, 6}, 2, 1),
            new TestCase(new int[]{1, 3, 5, 6}, 7, 4)
    );

    private static final Solution solution = new Solution();

    @Test
    public void searchInsert() {
        for (TestCase testCase : testCases) {
            int actual = solution.searchInsert(testCase.nums, testCase.target);
            Assert.assertEquals(testCase.exp, actual);
        }
    }

}