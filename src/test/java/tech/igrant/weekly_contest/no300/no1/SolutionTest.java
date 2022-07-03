package tech.igrant.weekly_contest.no300.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(String key, String message, String exp) {}

    private final List<TestCase> testCases = List.of(
            new TestCase(
                    "the quick brown fox jumps over the lazy dog",
                    "vkbs bs t suepuv",
                    "this is a secret"
            ),
            new TestCase(
                    "eljuxhpwnyrdgtqkviszcfmabo",
                    "zwx hnfx lqantp mnoeius ycgk vcnjrdb",
                    "the five boxing wizards jump quickly"
            )
    );

    private final Solution solution = new Solution();

    @Test
    public void decodeMessage() {
        for (TestCase testCase : testCases) {
            String act = solution.decodeMessage(testCase.key, testCase.message);
            Assert.assertEquals(
                    testCase.exp,
                    act
            );
        }
    }
}