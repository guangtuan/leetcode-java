package tech.igrant.weekly_contest.no297.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record T(int[][] brackets, int income, double exp) {
    }

    static final List<T> ts = Arrays.asList(
            new T(new int[][]{
                    new int[]{3, 50},
                    new int[]{7, 10},
                    new int[]{15, 25},
            }, 10, 2.65),
            new T(new int[][]{
                    new int[]{1, 0},
                    new int[]{4, 25},
                    new int[]{5, 50},
            }, 2, 0.25000),
            new T(new int[][]{
                    new int[]{2, 50},
            }, 0, 0)
    );

    private static final Solution s = new Solution();

    @Test
    public void calculateTax() {
        for (T t : ts) {
            double actual = s.calculateTax(t.brackets, t.income);
            Assert.assertEquals(t.exp, actual, Math.pow(10, -5));
        }
    }
}