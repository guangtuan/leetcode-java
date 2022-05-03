package tech.igrant.no937;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@State(Scope.Thread)
public class SolutionTest {

    private static class TestCase {
        private final String[] logs;
        private final String[] expected;

        public TestCase(String[] logs, String[] expected) {
            this.logs = logs;
            this.expected = expected;
        }
    }

    static List<TestCase> testCases = Arrays.asList(
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

    static Solution solution = new Solution();

    @Test
    @Benchmark
    public void reorderLogFiles() {
        for (TestCase testCase : testCases) {
            String[] actual = solution.reorderLogFiles(testCase.logs);
            Assert.assertArrayEquals(testCase.expected, actual);
        }
    }

    @Test
    public void launchBenchmark() throws Exception {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName() + ".reorderLogFiles")
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }

}