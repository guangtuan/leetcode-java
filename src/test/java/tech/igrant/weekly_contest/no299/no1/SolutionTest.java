package tech.igrant.weekly_contest.no299.no1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record Tc(int[][] m, boolean exp) {}

    private final List<Tc> tcList = Arrays.asList(
            new Tc(new int[][] {
                    new int[] {2,0,0,1},
                    new int[] {0,3,1,0},
                    new int[] {0,5,2,0},
                    new int[] {4,0,0,2}
            }, true),
            new Tc(new int[][] {
                    new int[] {5,7,0},
                    new int[] {0,3,1},
                    new int[] {0,5,0}
            }, false)
    );

    private final Solution solution = new Solution();

    @Test
    public void checkXMatrix() {
        for (Tc tc : tcList) {
            System.out.println(tc);
            boolean act = solution.checkXMatrix(tc.m);
            Assert.assertEquals(tc.exp, act);
        }
    }
}