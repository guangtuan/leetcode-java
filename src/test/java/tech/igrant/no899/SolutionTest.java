package tech.igrant.no899;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    record TestCase (String str, int k, String exp) {}

    private final List<TestCase> testCaseList = List.of(
            new TestCase("kuh", 1, "hku"),
            new TestCase("tk", 1, "kt"),
            new TestCase("v", 1, "v"),
            new TestCase("cba", 1, "acb"),
            new TestCase("baaca", 3, "aaabc")
    );

    private final Solution solution = new Solution();

    @Test
    public void orderlyQueue() {
        testCaseList.forEach(testCase -> {
            var actual = solution.orderlyQueue(testCase.str, testCase.k);
            Assert.assertEquals(testCase.exp, actual);
        });
    }

}