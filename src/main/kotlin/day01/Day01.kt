package day01

import java.io.File

class Day01 {
    fun day0101(fileName: String) {
        var elfNo = 1
        var highestElf = 0
        var highestCalories = 0
        var thisElfCalories: Int = 0
        val forEachLine = File(fileName).forEachLine {
            if (it.isBlank()) {
                if (thisElfCalories >= highestCalories) {
                    highestElf = elfNo
                    highestCalories = thisElfCalories
                }
                elfNo += 1
                thisElfCalories = 0
            } else {
                var thisLineCalories: Int = it.toInt()
                thisElfCalories += thisLineCalories
            }
        }
        println(String.format("Elf no. %d carries most calories: %d", highestElf, highestCalories))
    }

    fun day0102(fileName: String) {
        val linesString = File(fileName).readLines()
        val result = top3(linesString, Triple(0,0,0))
        println(String.format("Highest calories [%d,%d,%d], total calories %d", result.first, result.second, result.third, result.first + result.second + result.third))
    }

    fun top3(lines: List<String>, top3: Triple<Int, Int, Int>) : Triple<Int, Int, Int> {
        if(lines.isEmpty()) {
            return top3
        }
        val linesThisElfString = lines.takeWhile { it.isNotBlank() }
        val linesOtherElves = lines.dropWhile { it.isNotBlank() }.drop(1)
        val linesThisElf = linesThisElfString.map { line -> line.toInt() }
        val caloriesThisElf = linesThisElf.reduce(Int::plus)
        val newTopThree = mergeInto(caloriesThisElf, top3)
        return top3(linesOtherElves, newTopThree)
    }

    fun mergeInto(elfValue: Int, top3: Triple<Int, Int, Int>) : Triple<Int, Int, Int> {
        if(elfValue >= top3.first) {
            return Triple(elfValue, top3.first, top3.second)
        } else if(elfValue >= top3.second) {
            return Triple(top3.first, elfValue, top3.second)
        } else if(elfValue >= top3.third) {
            return Triple(top3.first, top3.second, elfValue)
        } else {
            return top3
        }
    }

}