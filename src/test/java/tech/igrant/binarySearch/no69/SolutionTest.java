package tech.igrant.binarySearch.no69;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int num, int exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(1, 1),
            new TestCase(0, 0),
            new TestCase(4, 2),
            new TestCase(8, 2)
    );

    private static final Solution s = new Solution();

    @Test
    public void mySqrt() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            int act = s.mySqrt(testCase.num);
            Assert.assertEquals(testCase.exp, act);
        }
    }

}