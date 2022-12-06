import kotlin.math.min

fun main() {

    fun splitToIntRanges(pair: String): Pair<IntRange, IntRange> {
        val ranges = pair.split(",").map {
            val start = it.split("-")[0]
            val end = it.split("-")[1]
            IntRange(start.toInt(), end.toInt())
        }
        val first = ranges[0]
        val second = ranges[1]
        return Pair(first, second)
    }

    fun part1(input: List<String>): Int {
        return input.count { pair ->
            val (first, second) = splitToIntRanges(pair)
            first.intersect(second).size >= min(first.count(), second.count())
        }
    }

    fun part2(input: List<String>): Int {
        return input.count { pair ->
            val (first, second) = splitToIntRanges(pair)
            first.intersect(second).isNotEmpty()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
