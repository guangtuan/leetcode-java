package tech.igrant.weekly_contest.no308.no3;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.support.JSON;

import java.util.List;

public class SolutionTest {

    private record TestCase(String[] garbage, int[] travel, int exp) {
    }

    private final List<TestCase> testCases = List.of(
            new TestCase(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}, 21),
            new TestCase(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}, 37)
    );

    private final Solution solution = new Solution();

    @Test
    public void garbageCollection() {
        for (TestCase testCase : testCases) {
            JSON.printJSON(testCase);
            int actual = solution.garbageCollection(testCase.garbage, testCase.travel);
            Assert.assertEquals(
                    testCase.exp,
                    actual
            );
        }
    }
}