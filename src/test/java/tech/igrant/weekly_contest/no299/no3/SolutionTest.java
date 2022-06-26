package tech.igrant.weekly_contest.no299.no3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record Tc(int[] arr1, int[] arr2, int exp) {
    }

    private final List<Tc> tcList = List.of(
            new Tc(new int[]{10, 20, 50, 15, 30, 10}, new int[]{40, 20, 10, 100, 10, 10}, 230),
            new Tc(new int[]{20, 40, 20, 70, 30}, new int[]{50, 20, 50, 40, 20}, 220),
            new Tc(new int[]{60, 60, 60}, new int[]{10, 90, 10}, 210),
            new Tc(new int[]{7, 11, 13}, new int[]{1, 1, 1}, 31)
    );

    private final Solution solution = new Solution();

    @Test
    public void maximumsSplicedArray() {
        for (Tc tc : tcList) {
            System.out.println(Arrays.toString(tc.arr1));
            System.out.println(Arrays.toString(tc.arr2));
            System.out.println(tc.exp);
            int act = solution.maximumsSplicedArray(tc.arr1, tc.arr2);
            Assert.assertEquals(tc.exp, act);
            System.out.println("pass 1");
        }
    }
}