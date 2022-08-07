package tech.igrant.weekly_contest.no305.no2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(int n, int[][] edges, int[] restricted, int exp) {
    }

    private final List<TestCase> c = List.of(
            new TestCase(
                    7,
                    new int[][]{
                            new int[]{0, 1},
                            new int[]{1, 2},
                            new int[]{3, 1},
                            new int[]{4, 0},
                            new int[]{0, 5},
                            new int[]{5, 6}
                    },
                    new int[]{4, 5},
                    4
            ),
            new TestCase(
                    10,
                    new int[][]{
                            new int[]{4, 1},
                            new int[]{1, 3},
                            new int[]{1, 5},
                            new int[]{0, 5},
                            new int[]{3, 6},
                            new int[]{8, 4},
                            new int[]{5, 7},
                            new int[]{6, 9},
                            new int[]{3, 2}
                    },
                    new int[]{2, 7},
                    8
            )
    );
    /**
     * 10
     * [[4,1],[1,3],[1,5],[0,5],[3,6],[8,4],[5,7],[6,9],[3,2]]
     * [2,7]
     */

    private final Solution s = new Solution();

    @Test
    public void reachableNodes() {
        for (TestCase testCase : c) {
            System.out.println(testCase);
            int ret = s.reachableNodes(testCase.n, testCase.edges, testCase.restricted);
            Assert.assertEquals(
                    testCase.exp,
                    ret
            );
        }
    }
}