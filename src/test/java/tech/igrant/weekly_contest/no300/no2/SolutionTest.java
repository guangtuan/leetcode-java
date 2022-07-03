package tech.igrant.weekly_contest.no300.no2;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.support.JSON;

import java.util.List;

public class SolutionTest {

    private record TestCase(int m, int n, Solution.ListNode head, int[][] exp) {
    }

    private final List<TestCase> testCaseList = List.of(
            new TestCase(3, 5,
                    new Solution.ListNode(3, new Solution.ListNode(0,
                            new Solution.ListNode(2, new Solution.ListNode(6,
                                    new Solution.ListNode(8, new Solution.ListNode(1,
                                            new Solution.ListNode(7, new Solution.ListNode(9,
                                                    new Solution.ListNode(4, new Solution.ListNode(2,
                                                            new Solution.ListNode(5, new Solution.ListNode(5,
                                                                    new Solution.ListNode(0, null))))))))))))),
                    new int[][]{new int[]{3, 0, 2, 6, 8}, new int[]{5, 0, -1, -1, 1}, new int[]{5, 2, 4, 9, 7}}));

    private final Solution solution = new Solution();

    @Test
    public void spiralMatrix() {
        for (TestCase testCase : testCaseList) {
            int[][] act = solution.spiralMatrix(testCase.m, testCase.n, testCase.head);
            JSON.printJSON(act);
            JSON.printJSON(testCase.exp);

            Assert.assertArrayEquals(
                    testCase.exp,
                    act
            );
        }
    }
}