package tech.igrant.no761

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    data class T (val s: String, val exp: String)

    private val ts: List<T> = listOf(
        T(s = "101010", exp = "101010"),
        T(s = "11011000", exp = "11100100")
    )

    val s = Solution()
    val sJava = SolutionJava()

    @Test
    fun makeLargestSpecial() {
        ts.forEach {
            assertEquals(
                it.exp,
                s.makeLargestSpecial(it.s)
            )
        }
    }

    @Test
    fun makeLargestSpecial2() {
        ts.forEach {
            assertEquals(
                it.exp,
                sJava.makeLargestSpecial(it.s)
            )
        }
    }
}