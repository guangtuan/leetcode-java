package tech.igrant.weekly_contest.no308.no2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private record TestCase(String s, String exp) {}

    private final List<TestCase> testCases = List.of(
            new TestCase("leet**cod*e", "lecoe"),
            new TestCase("erase*****", "")
    );

    private final Solution solution = new Solution();

    @Test
    public void removeStars() {
        for (TestCase testCase : testCases) {
            String actual = solution.removeStars(testCase.s);
            Assert.assertEquals(testCase.exp, actual);
        }
    }

}