package tech.igrant.no442;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.support.ListSupport;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private static class TestCase {
        private final int[] nums;
        private final List<Integer> exp;

        private TestCase(int[] nums, List<Integer> exp) {
            this.nums = nums;
            this.exp = exp;
        }
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(2, 3)),
            new TestCase(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}, Arrays.asList(10, 1))
    );

    private static final Solution solution = new Solution();

    @Test
    public void findDuplicates() {
        for (TestCase testCase : testCases) {
            List<Integer> actual = solution.findDuplicates(testCase.nums);
            Assert.assertEquals(ListSupport.hash(testCase.exp), ListSupport.hash(actual));
        }
    }
}