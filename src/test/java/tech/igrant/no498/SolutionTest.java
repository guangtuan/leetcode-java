package tech.igrant.no498;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[][] matrix, int[] exp) {
    }

    private List<TestCase> testCases = Arrays.asList(
            new TestCase(
                    new int[][]{
                            new int[]{1, 2, 3, 4},
                            new int[]{5, 6, 7, 8},
                            new int[]{9, 10, 11, 12}
                    },
                    new int[]{1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12}
            ),
            new TestCase(
                    new int[][]{
                            new int[]{1, 2, 3},
                            new int[]{4, 5, 6},
                            new int[]{7, 8, 9}
                    },
                    new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}
            ),
            new TestCase(
                    new int[][]{
                            new int[]{1, 2},
                            new int[]{3, 4}
                    },
                    new int[]{1, 2, 3, 4}
            )
    );

    private static final Solution s = new Solution();

    @Test
    public void findDiagonalOrder() {
        for (TestCase testCase : testCases) {
            int[] act = s.findDiagonalOrder(testCase.matrix);
            Assert.assertArrayEquals(testCase.exp, act);
        }
    }
}