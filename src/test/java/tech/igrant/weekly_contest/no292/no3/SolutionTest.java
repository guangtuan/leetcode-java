package tech.igrant.weekly_contest.no292.no3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private static class TestCase {
        private String pressedKeys;
        private int exp;

        public TestCase(String pressedKeys, int exp) {
            this.pressedKeys = pressedKeys;
            this.exp = exp;
        }
    }

    private static List<TestCase> testCaseList = Arrays.asList(
            new TestCase("222222222222222222222222222222222222", 82876089),
            new TestCase("22233", 8)
    );

    private static Solution solution = new Solution();

    @Test
    public void countTexts() {
        for (TestCase testCase : testCaseList) {
            int actual = solution.countTexts(testCase.pressedKeys);
            Assert.assertEquals(testCase.exp, actual);
        }
    }
}