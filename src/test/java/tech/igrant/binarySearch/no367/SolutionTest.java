package tech.igrant.binarySearch.no367;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private record TestCase(int num, boolean exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(808201, true),
            new TestCase(1, true),
            new TestCase(16, true),
            new TestCase(25, true),
            new TestCase(14, false)
    );

    private static final Solution solution = new Solution();

    @Test
    public void isPerfectSquare() {
        for (TestCase testCase : testCases) {
            Assert.assertEquals(testCase.exp, solution.isPerfectSquare(testCase.num));
        }
    }
}