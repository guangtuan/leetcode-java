package tech.igrant.no448;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            new TestCase(new int[]{1, 1}, Arrays.asList(2)),
            new TestCase(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(5, 6))
    );

    private static final Solution solution = new Solution();

    @Test
    public void findDisappearedNumbers() {
        for (TestCase testCase : testCases) {
            List<Integer> actual = solution.findDisappearedNumbers(testCase.nums);
            Assert.assertEquals(
                    testCase.exp.stream().map(Object::toString).collect(Collectors.joining(",")),
                    actual.stream().map(Object::toString).collect(Collectors.joining(","))
            );
        }
    }
}