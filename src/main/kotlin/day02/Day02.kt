package day02

import java.io.File

class Day02 {
    fun day0201(fileName : String)  {
        val lines = File(fileName).readLines()
        val totalScore = lines.map { line -> rps(line) }.reduce(Int::plus)
        println(String.format("Total score day 2 part 1: %d", totalScore))
    }

    fun day0202(fileName: String) {
        val lines = File(fileName).readLines()
        val totalScore = lines.map{ line -> rps2(line) }.reduce(Int::plus)
        println(String.format("Total score day 2 part 2: %d", totalScore))
    }
    fun rps(line: String) : Int {
        val scores = mapOf(
            "A X" to 4,
            "A Y" to 8,
            "A Z" to 3,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 7,
            "C Y" to 2,
            "C Z" to 6
            )
        return scores.getValue(line)
    }

   fun rps2(line: String) : Int {
       val scores = mapOf(
           "A X" to 3, // Rock - Loose -> Scissors (3 points)
           "A Y" to 4, // Rock - Draw -> Rock (1 point)
           "A Z" to 8, // Rock - Win -> Paper (2 points)
           "B X" to 1, // Paper - Loose -> Rock (1 point)
           "B Y" to 5, // Paper - Draw -> Paper (2 points)
           "B Z" to 9, // Paper - Win -> Scissors (3 points)
           "C X" to 2, // Scissors - Loose -> Paper (2 points)
           "C Y" to 6, // Scissors - Draw -> Scissors (3 points)
           "C Z" to 7, // Scissors - Win -> Rock (1 point)
       )
       return scores.getValue(line)
   }
}