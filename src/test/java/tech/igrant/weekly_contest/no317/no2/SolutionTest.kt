package tech.igrant.weekly_contest.no317.no2

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(
            val creators: Array<String>,
            val ids: Array<String>,
            val views: IntArray,
            val exp: List<List<String>>
    )

    val testCases = listOf(
            TestCase(
                    creators = arrayOf("a", "b"),
                    ids = arrayOf("a", "a"),
                    views = intArrayOf(1, 0),
                    exp = listOf(
                            listOf("a", "a")
                    )
            ),
            TestCase(
                    creators = arrayOf("alice", "bob", "alice", "chris"),
                    ids = arrayOf("one", "two", "three", "four"),
                    views = intArrayOf(5, 10, 5, 4),
                    exp = listOf(
                            listOf("alice", "one"),
                            listOf("bob", "two")
                    )
            ),
            TestCase(
                    creators = arrayOf("alice", "alice", "alice"),
                    ids = arrayOf("a", "b", "c"),
                    views = intArrayOf(1, 2, 2),
                    exp = listOf(
                            listOf("alice", "b")
                    )
            ),

    )

    val solution = Solution()

    @Test
    fun mostPopularCreator() {
        testCases.forEach {
            val act = solution.mostPopularCreator(it.creators, it.ids, it.views)
            Assert.assertEquals(
                    JSON.toJSON(it.exp),
                    JSON.toJSON(act),
            )
        }
    }
}