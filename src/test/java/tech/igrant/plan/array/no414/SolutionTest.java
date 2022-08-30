package tech.igrant.plan.array.no414;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.support.JSON;

import java.util.List;

public class SolutionTest {

    private record TestCase(int[] nums, int exp) {
    }

    private final List<TestCase> testCaseList = List.of(
            new TestCase(new int[]{1, 1, 2}, 2),
            new TestCase(new int[]{3, 2, 1}, 1),
            new TestCase(new int[]{1, 2}, 2),
            new TestCase(new int[]{2, 2, 3, 1}, 1)
    );

    private final Solution solution = new Solution();

    @Test
    public void thirdMax() {
        for (TestCase testCase : testCaseList) {
            JSON.printJSONALine(testCase);
            Assert.assertEquals(
                    testCase.exp,
                    solution.thirdMax(testCase.nums)
            );
        }
    }
}
