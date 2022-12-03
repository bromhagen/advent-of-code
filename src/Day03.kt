fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            line.substring(0, line.length/2).toSet()
                .intersect(line.substring(line.length/2).toSet())
                .map { char ->
                    char.code - if (char.isUpperCase()) 38 else 96
                }
                .first()
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf {
            it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet()).map { char ->
                char.code - if (char.isUpperCase()) 38 else 96
            }.first()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
