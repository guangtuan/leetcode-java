package tech.igrant.weekly_contest.no298.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(String s, String exp) {}

    private final List<TestCase> testCaseList = Arrays.asList(
            new TestCase("lEeTcOdE", "E"),
            new TestCase("arRAzFif", "R"),
            new TestCase("AbCdEfGhIjK", "")
    );

    private final Solution s = new Solution();

    @Test
    public void greatestLetter() {
        for (TestCase testCase : testCaseList) {
            String act = s.greatestLetter(testCase.s);
            Assert.assertEquals(testCase.exp, act);
        }
    }
}