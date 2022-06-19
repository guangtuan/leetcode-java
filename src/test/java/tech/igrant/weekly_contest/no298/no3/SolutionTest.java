package tech.igrant.weekly_contest.no298.no3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(String s, int k, int exp) {
    }

    private final List<TestCase> testCases = Arrays.asList(
            new TestCase(
                    "111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101",
                    11713332,
                    96
            ),
            new TestCase("1001010", 5, 5),
            new TestCase("00101001", 1, 6)
    );

    private final Solution s = new Solution();

    @Test
    public void longestSubsequence() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            int act = s.longestSubsequence(testCase.s, testCase.k);
            Assert.assertEquals(testCase.exp, act);
        }
    }
}