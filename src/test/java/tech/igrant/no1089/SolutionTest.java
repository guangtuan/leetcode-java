package tech.igrant.no1089;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[] arr, int[] exp) {
    }

    private final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{1, 0, 2, 3, 0, 4, 5, 0}, new int[]{1, 0, 0, 2, 3, 0, 0, 4}),
            new TestCase(new int[]{1, 2, 3}, new int[]{1, 2, 3})
    );

    private final Solution solution = new Solution();

    @Test
    public void duplicateZeros() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            solution.duplicateZeros(testCase.arr);
            Assert.assertArrayEquals(
                    testCase.exp,
                    testCase.arr
            );
        }
    }
}