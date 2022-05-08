package tech.igrant.weekly_contest.no292.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private static class TestCase {
        private String num;
        private String exp;

        public TestCase(String num, String exp) {
            this.num = num;
            this.exp = exp;
        }
    }

    private static List<TestCase> testCaseList = Arrays.asList(
            new TestCase("711133310755088231390684011112227777007142226669892017313336662051880002555771116", "777"),
            new TestCase("6777133339", "777"),
            new TestCase("2300019", "000"),
            new TestCase("42352338", "")
    );

    private Solution solution = new Solution();

    @Test
    public void largestGoodInteger() {
        for (TestCase testCase : testCaseList) {
            String actual = solution.largestGoodInteger(testCase.num);
            Assert.assertEquals(testCase.exp, actual);
        }
    }
}