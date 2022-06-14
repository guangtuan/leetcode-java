package tech.igrant.no647;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void removeHeadAndTail() {
        Assert.assertEquals(
                "2", s.removeHeadAndTail("123")
        );
    }

    private record TestCase(String s, int exp) {}

    private List<TestCase> testCaseList = Arrays.asList(
            new TestCase("abc", 3),
            new TestCase("aaa", 6)
    );

    private Solution s = new Solution();

    @Test
    public void countPalindromicSubsequences() {
        for (TestCase testCase : testCaseList) {
            System.out.println("input is " + testCase.s);
            int act = s.countSubstrings(testCase.s);
            Assert.assertEquals(testCase.exp, act);
        }
    }
}