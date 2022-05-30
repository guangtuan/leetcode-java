package tech.igrant.binarySearch.no1385;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private record TestCase(int[] arr1, int[] arr2, int d, int exp) {
    }

    private static final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6, 1),
//            new TestCase(
//                    new int[]{
//                            -803, 715, -224, 909, 121, -296, 872, 807, 715, 407, 94, -8, 572, 90, -520, -867, 485, -918, -827, -728, -653, -659, 865, 102, -564, -452, 554, -320, 229, 36, 722, -478, -247, -307, -304, -767, -404, -519, 776, 933, 236, 596, 954, 464
//                    },
//                    new int[]{
//                            817, 1, -723, 187, 128, 577, -787, -344, -920, -168, -851, -222, 773, 614, -699, 696, -744, -302, -766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950, -454, -253, 824, -395, 155, 94, 894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373, -971, -813, -154, -765, 691, 812, 617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394, -506, -675, 523, 730, -790, -109, 865, 975, -226, 651, 987, 111, 862, 675, -398, 126, -482, 457, -24, -356, -795, -575, 335, -350, -919, -945, -979, 611
//                    },
//                    37,
//                    0
//            ),
            new TestCase(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2, 2),
            new TestCase(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3, 2)
    );

    private static final Solution solution = new Solution();

    @Test
    public void findTheDistanceValue() {
        for (TestCase testCase : testCases) {
            int act = solution.findTheDistanceValue(testCase.arr1, testCase.arr2, testCase.d);
            Assert.assertEquals(act, testCase.exp);
        }
    }

}