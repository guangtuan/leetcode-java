package tech.igrant.no1403;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTest {

    private static final class Ts {
        private int[] input;
        private int[] exp;

        public Ts(int[] input, int[] exp) {
            this.input = input;
            this.exp = exp;
        }
    }

    private final List<Ts> tsList = Arrays.asList(
            new Ts(new int[]{6}, new int[]{6}),
            new Ts(new int[]{4, 3, 10, 9, 8}, new int[]{10, 9})
    );

    private final Solution solution = new Solution();

    @Test
    public void minSubsequence() {
        for (Ts ts : tsList) {
            List<Integer> actual = solution.minSubsequence(ts.input);
            Assert.assertEquals(
                    Arrays.stream(ts.exp).boxed().map(Object::toString).collect(Collectors.joining(",")),
                    actual.stream().map(Object::toString).collect(Collectors.joining(","))
            );
        }

        for (Ts ts : tsList) {
            List<Integer> actual = solution.minSubsequence2(ts.input);
            Assert.assertEquals(
                    Arrays.stream(ts.exp).boxed().map(Object::toString).collect(Collectors.joining(",")),
                    actual.stream().map(Object::toString).collect(Collectors.joining(","))
            );
        }
    }

}