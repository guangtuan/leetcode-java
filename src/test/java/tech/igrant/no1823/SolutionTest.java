package tech.igrant.no1823;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private static class TestCase {
        private final int n;
        private final int k;
        private final int expected;

        TestCase(int n, int k, int expected) {
            this.n = n;
            this.k = k;
            this.expected = expected;
        }
    }

    private static List<TestCase> testCaseList = Arrays.asList(
            new TestCase(3, 1, 3),
            new TestCase(5, 2, 3),
            new TestCase(6, 5, 1)
    );
    private static final Solution solution = new Solution();

    @Test
    public void findTheWinner() {
        for (TestCase testCase : testCaseList) {
            int actual = solution.findTheWinner(testCase.n, testCase.k);
            Assert.assertEquals(testCase.expected, actual);
        }
    }
}