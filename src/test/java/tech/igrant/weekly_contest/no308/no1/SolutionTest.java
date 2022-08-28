package tech.igrant.weekly_contest.no308.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(int[] nums, int[] queries, int[] exp) {}

    private final List<TestCase> testCaseList = List.of(
            new TestCase(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}, new int[]{2, 3, 4}),
            new TestCase(new int[]{2, 3, 4, 5}, new int[]{1}, new int[]{0})
    );

    private final Solution solution = new Solution();

    @Test
    public void answerQueries() {
        for (TestCase testCase : testCaseList) {
            int[] actual = solution.answerQueries(testCase.nums, testCase.queries);
            Assert.assertArrayEquals(
                    testCase.exp,
                    actual
            );
        }
    }
}