package tech.igrant.weekly_contest.no297.no4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(String[] ideas, long exp) {
    }

    private static final List<TestCase> testCaseList = Arrays.asList(
            new TestCase(new String[]{"ps", "yn", "eciuehjexw", "pdesv", "e", "dz", "xxdnk", "vdqjhncfj"}, 52),
            new TestCase(new String[]{"aaa", "baa", "caa", "bbb", "cbb", "dbb"}, 2),
            new TestCase(new String[]{"coffee", "donuts", "time", "toffee"}, 6),
            new TestCase(new String[]{"lack", "back"}, 0)
    );

    private static final Solution s = new Solution();

    @Test
    public void distinctNames() {
        for (TestCase testCase : testCaseList) {
            System.out.println("a case run @@@@@@@@@@@@@@@@@@@@@");
            long act = s.distinctNames(testCase.ideas);
            Assert.assertEquals(testCase.exp, act);
        }
    }
}