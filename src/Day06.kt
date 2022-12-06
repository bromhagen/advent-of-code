
fun main() {

    fun positionAfterDistinctChars(input: String, num: Int): Int {
        return input.asSequence().windowed(num).withIndex().first { it.value.distinct().size == num }.index + num
    }

    fun part1(input: List<String>): Int = positionAfterDistinctChars(input.first(), 4)

    fun part2(input: List<String>): Int = positionAfterDistinctChars(input.first(), 14)

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
