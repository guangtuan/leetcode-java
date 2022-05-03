package tech.igrant.no937;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private static class TestCase {
        private String[] logs;
        private String[] expected;

        public TestCase(String[] logs, String[] expected) {
            this.logs = logs;
            this.expected = expected;
        }
    }

    @Test
    public void reorderLogFiles() {
        Solution solution = new Solution();
        List<TestCase> testCases = Arrays.asList(
                new TestCase(
                        new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"},
                        new String[]{"5 m w", "j mo", "t q h", "g 07", "o 2 0"}
                ),
                new TestCase(
                        new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"},
                        new String[]{"a2 act car", "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"}
                ),
                new TestCase(
                        new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"},
                        new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"}
                ),
                new TestCase(
                        new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"},
                        new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"}
                )
        );
        for (TestCase testCase : testCases) {
            String[] actual = solution.reorderLogFiles(testCase.logs);
            System.out.println(Arrays.toString(actual));
            System.out.println(Arrays.toString(testCase.expected));
            Assert.assertArrayEquals(testCase.expected, actual);
        }
    }
}