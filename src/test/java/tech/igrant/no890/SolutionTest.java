package tech.igrant.no890;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTest {

    private record TestCase(String[] words, String pattern, List<String> exp) {
    }

    private static final List<TestCase> testCase = Arrays.asList(
            new TestCase(new String[]{"abc", "cba", "xyx", "yxx", "yyx"}, "abc", Arrays.asList("abc", "cba")),
            new TestCase(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb", Arrays.asList("mee", "aqq"))
    );

    private static final Solution s = new Solution();

    @Test
    public void findAndReplacePattern() {
        for (TestCase aCase : testCase) {
            List<String> act = s.findAndReplacePattern(aCase.words, aCase.pattern);
            Assert.assertEquals(
                    aCase.exp.stream().sorted().collect(Collectors.joining(", ")),
                    act.stream().sorted().collect(Collectors.joining(", "))
            );
        }
    }
}