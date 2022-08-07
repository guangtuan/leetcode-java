package tech.igrant.weekly_contest.no305.no3;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(int[] nums, boolean exp) {
    }

    private static final List<TestCase> testCases = List.of(
            new TestCase(new int[]{1, 1, 1, 2}, false),
            new TestCase(new int[]{4, 4, 4, 5, 6}, true),
            new TestCase(new int[]{4, 4, 4, 5, 5, 5, 2, 2, 2, 4, 5, 6}, true),
            new TestCase(new int[]{4, 4, 4, 5, 5, 5, 2, 2, 2, 5, 6}, false),
            new TestCase(new int[]{4, 4, 4, 5, 5, 5, 2, 2, 2, 4, 5, 6, 7}, false)
    );

    private static final Solution solution = new Solution();

    @Test
    public void validPartition() {
        for (TestCase testCase : testCases) {
            boolean actual = solution.validPartition(testCase.nums);
            Assert.assertEquals(
                    testCase.exp,
                    actual
            );
        }
    }

}