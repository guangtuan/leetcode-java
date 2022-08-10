package tech.igrant.no640;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    private record TestCase(String equation, String exp) {
    }

    private static final List<TestCase> ts = List.of(
            new TestCase("-x=-1", "x=1"),
            new TestCase("x=x+2", "No solution"),
            new TestCase("2x+0=0", "x=0"),
            new TestCase("x=x", "Infinite solutions"),
            new TestCase("1+1=x", "x=2"),
            new TestCase("x+5-3+x=6+x-2", "x=2"),
            new TestCase("0x=0", "Infinite solutions")
    );

    private static final Solution s = new Solution();

    @Test
    public void solveEquation() {
        for (TestCase t : ts) {
            String actual = s.solveEquation(t.equation);
            Assert.assertEquals(
                    t.exp,
                    actual
            );
        }
    }
}