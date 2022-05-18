package tech.igrant.binarySearch.no704;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(int[] arr, int target, int exp) {
    }

    private final List<TestCase> testCaseList = List.of(
            new TestCase(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
            new TestCase(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),
            new TestCase(new int[]{1}, 2, -1),
            new TestCase(new int[]{1}, 1, 0)
    );

    private static final Solution solution = new Solution();

    @Test
    public void search() {
        for (TestCase testCase : testCaseList) {
            int search = solution.search(testCase.arr, testCase.target);
            Assert.assertEquals(search, testCase.exp);
        }
    }
}