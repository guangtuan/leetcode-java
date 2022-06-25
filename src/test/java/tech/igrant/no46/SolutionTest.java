package tech.igrant.no46;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static tech.igrant.AssertSupport.listEquals;

public class SolutionTest {

    @Test
    public void remove() {
        Assert.assertArrayEquals(
                new int[]{2, 3},
                solution.remove(0, new int[]{1, 2, 3})
        );
        Assert.assertArrayEquals(
                new int[]{1, 3},
                solution.remove(1, new int[]{1, 2, 3})
        );
        Assert.assertArrayEquals(
                new int[]{1, 2},
                solution.remove(2, new int[]{1, 2, 3})
        );
    }

    private record TestCase(int[] arr, List<List<Integer>> exp) {
    }

    private final List<TestCase> testCases = Arrays.asList(
            new TestCase(new int[]{1, 2, 3, 4},
                    Arrays.asList(
                            Arrays.asList(1, 2, 3, 4),
                            Arrays.asList(1, 2, 4, 3),
                            Arrays.asList(1, 3, 2, 4),
                            Arrays.asList(1, 3, 4, 2),
                            Arrays.asList(1, 4, 2, 3),
                            Arrays.asList(1, 4, 3, 2),
                            Arrays.asList(2, 1, 3, 4),
                            Arrays.asList(2, 1, 4, 3),
                            Arrays.asList(2, 3, 1, 4),
                            Arrays.asList(2, 3, 4, 1),
                            Arrays.asList(2, 4, 1, 3),
                            Arrays.asList(2, 4, 3, 1),
                            Arrays.asList(3, 1, 2, 4),
                            Arrays.asList(3, 1, 4, 2),
                            Arrays.asList(3, 2, 1, 4),
                            Arrays.asList(3, 2, 4, 1),
                            Arrays.asList(3, 4, 1, 2),
                            Arrays.asList(3, 4, 2, 1),
                            Arrays.asList(4, 1, 2, 3),
                            Arrays.asList(4, 1, 3, 2),
                            Arrays.asList(4, 2, 1, 3),
                            Arrays.asList(4, 2, 3, 1),
                            Arrays.asList(4, 3, 1, 2),
                            Arrays.asList(4, 3, 2, 1)
                    )
            ),
            new TestCase(new int[]{1, 2, 3},
                    Arrays.asList(
                            Arrays.asList(1, 2, 3),
                            Arrays.asList(1, 3, 2),
                            Arrays.asList(2, 1, 3),
                            Arrays.asList(2, 3, 1),
                            Arrays.asList(3, 1, 2),
                            Arrays.asList(3, 2, 1)
                    )
            ),
            new TestCase(new int[]{1, 2},
                    Arrays.asList(
                            Arrays.asList(1, 2),
                            Arrays.asList(2, 1)
                    )
            ),
            new TestCase(new int[]{1},
                    List.of(
                            List.of(1)
                    )
            )
    );


    private final Solution solution = new Solution();


    @Test
    public void permute() {
        for (TestCase testCase : testCases) {
            List<List<Integer>> act = solution.permute(testCase.arr);
            Assert.assertTrue(
                    listEquals(numbers -> numbers.stream().map(String::valueOf).collect(Collectors.joining(",")),
                            testCase.exp,
                            act
                    )
            );
        }
    }
}