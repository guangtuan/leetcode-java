package tech.igrant.weekly_contest.no292.no3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private static class TestCase {
        private final String pressedKeys;
        private final int exp;

        public TestCase(String pressedKeys, int exp) {
            this.pressedKeys = pressedKeys;
            this.exp = exp;
        }
    }

    private static final List<TestCase> testCaseList = Arrays.asList(
            new TestCase("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664", 537551452),
            new TestCase("444479999555588866", 3136),
            new TestCase("22233", 8),
            new TestCase("222222222222222222222222222222222222", 82876089)
    );

    private static final Solution solution = new Solution();

    @Test
    public void countTexts() {
        for (TestCase testCase : testCaseList) {
            int actual = solution.countTexts(testCase.pressedKeys);
            Assert.assertEquals(testCase.exp, actual);
        }
    }
}