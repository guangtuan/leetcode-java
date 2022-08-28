package tech.igrant.weekly_contest.no308.no4;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.support.JSON;

import java.util.List;

public class SolutionTest {

    private record TestCase(int k, int[][] rowConditions, int[][] colConditions, int[][] exp) {
    }

    private final List<TestCase> testCaseList = List.of(
            new TestCase(
                    3,
                    new int[][]{new int[]{1, 2}, new int[]{2, 3}},
                    new int[][]{new int[]{2, 1}, new int[]{3, 2}},
                    new int[][]{
                            new int[]{3, 0, 0},
                            new int[]{0, 0, 1},
                            new int[]{0, 2, 0},
                    }
            )
    );

    private final Solution solution = new Solution();

    @Test
    public void buildMatrix() {
        for (TestCase testCase : testCaseList) {
            JSON.printJSON(testCase);
            int[][] actual = solution.buildMatrix(testCase.k, testCase.rowConditions, testCase.colConditions);
            Assert.assertArrayEquals(
                    testCase.exp,
                    actual
            );
        }
    }

}