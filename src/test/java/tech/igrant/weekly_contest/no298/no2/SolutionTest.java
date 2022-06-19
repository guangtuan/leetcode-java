package tech.igrant.weekly_contest.no298.no2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int num, int k, int exp) {}

    private final List<TestCase> testCases = Arrays.asList(
            new TestCase(2, 8, -1),
            new TestCase(4, 0, -1),
            new TestCase(8, 4, 2),
            new TestCase(5, 1, 5),
            new TestCase(58, 9, 2),
            new TestCase(37, 2, -1),
            new TestCase(0, 7, 0)
    );

    private static final Solution s
             = new Solution();

    @Test
    public void minimumNumbers() {
        for (TestCase testCase : testCases) {
            int act = s.minimumNumbers(testCase.num, testCase.k);
            System.out.println(testCase);
            Assert.assertEquals(testCase.exp, act);
        }
    }
}