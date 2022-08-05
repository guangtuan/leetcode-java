package tech.igrant.no623;

import org.junit.Assert;
import org.junit.Test;
import tech.igrant.TreeNode;
import tech.igrant.support.HashSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class SolutionTest {
    private final static Function<List<Integer>, String> hash = HashSupport.express(String::valueOf);

    Solution solutionJava = new Solution();
    SolutionWithKt solutionKt = new SolutionWithKt();

    @Test
    public void addOneRow() {
        TreeNode retJava = solutionJava.addOneRow(new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(1)
                ),
                new TreeNode(
                        6,
                        new TreeNode(5),
                        null
                )
        ), 1, 2);
        TreeNode retKt = solutionKt.addOneRow(new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(1)
                ),
                new TreeNode(
                        6,
                        new TreeNode(5),
                        null
                )
        ), 1, 2);
        Assert.assertEquals(
                hash.apply(Arrays.asList(4, 1, 1, 2, null, null, 6, 3, 1, 5)),
                hash.andThen(SolutionTest::removeTrailingNull).apply(bfsCollect(retJava))
        );
        Assert.assertEquals(
                hash.apply(Arrays.asList(4, 1, 1, 2, null, null, 6, 3, 1, 5)),
                hash.andThen(SolutionTest::removeTrailingNull).apply(bfsCollect(retKt))
        );
    }


    @Test
    public void addOneRow2() {
        TreeNode retJava = solutionJava.addOneRow(new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        ), 10, 1);
        TreeNode retKt = solutionKt.addOneRow(new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        ), 10, 1);
        List<Integer> holderJava = bfsCollect(retJava);
        List<Integer> holderKt = bfsCollect(retKt);
        Assert.assertEquals(
                hash.apply(Arrays.asList(10, 1, null, 2, 3)),
                hash.andThen(SolutionTest::removeTrailingNull).apply(holderJava)
        );
        Assert.assertEquals(
                hash.apply(Arrays.asList(10, 1, null, 2, 3)),
                hash.andThen(SolutionTest::removeTrailingNull).apply(holderKt)
        );
    }

    private List<Integer> bfsCollect(TreeNode ret) {
        List<Integer> holder = new ArrayList<>();
        bfsWalk(List.of(ret), holder);
        return holder;
    }

    private static String removeTrailingNull(String str) {
        String ret = removeSuffix(str, ",null");
        if (ret.length() == str.length()) {
            return ret;
        } else {
            return removeSuffix(ret, ",null");
        }
    }

    private static String removeSuffix(String str, String suffix) {
        if (str.endsWith(suffix)) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    private void bfsWalk(List<TreeNode> node, List<Integer> visit) {
        List<TreeNode> curr = new ArrayList<>();
        for (TreeNode treeNode : node) {
            if (treeNode == null) {
                visit.add(null);
            } else {
                visit.add(treeNode.val);
                curr.add(treeNode.left);
                curr.add(treeNode.right);
            }
        }
        if (curr.isEmpty() || curr.stream().allMatch(Objects::isNull)) {
            return;
        }
        bfsWalk(curr, visit);
    }

}