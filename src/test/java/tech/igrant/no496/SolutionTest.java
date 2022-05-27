package tech.igrant.no496;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[] nums1, int[] nums2, int[] exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(
                    new int[]{3, 1, 5, 7, 9, 2, 6},
                    new int[]{1, 2, 3, 5, 6, 7, 9, 11},
                    new int[]{5, 2, 6, 9, 11, 3, 7}
            ),
            new TestCase(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
            new TestCase(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
    );

    private static final Solution solution = new Solution();

    @Test
    public void nextGreaterElement() {
        for (TestCase testCase : testCases) {
            int[] act = solution.nextGreaterElement(testCase.nums1, testCase.nums2);
            Assert.assertArrayEquals(testCase.exp, act);
        }
    }
}