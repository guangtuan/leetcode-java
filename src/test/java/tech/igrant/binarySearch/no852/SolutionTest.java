package tech.igrant.binarySearch.no852;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[] arr, int exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{0, 1, 0}, 1),
            new TestCase(new int[]{0, 2, 1, 0}, 1),
            new TestCase(new int[]{0, 10, 5, 2}, 1),
            new TestCase(new int[]{3, 4, 5, 1}, 2),
            new TestCase(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}, 2)
    );

    private static final Solution solution = new Solution();

    @Test
    public void peakIndexInMountainArray() {
        for (TestCase testCase : testCases) {
            Assert.assertEquals(testCase.exp, solution.peakIndexInMountainArray(testCase.arr));
        }
    }
}