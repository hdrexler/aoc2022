package day04

import java.io.File


class Day04 {
    fun day0401(fileName: String) {
        val lines = File(fileName).readLines()
        val overlapCount = lines
            .map { line -> parseToAssignments(line) }
            .filter { pair -> contains(pair.first, pair.second) }
        println(String.format("Overlapping assignment count day 4 part 1: %d", overlapCount.size))
    }

    fun day0402(fileName: String) {
        val lines = File(fileName).readLines()
        val overlapCount = lines
            .map { line -> parseToAssignments(line) }
            .filter { pair -> overlaps(pair.first, pair.second) }
        println(String.format("Overlapping assignment count day 4 part 2: %d", overlapCount.size))
    }

    fun parseToAssignments(line: String) : Pair<IntRange, IntRange> {
        val parts = line.split(",")
        val range1 = parts.first().split("-")
        val range2 = parts.get(1).split("-")
        return Pair(
            IntRange(range1.get(0).toInt(),range1.get(1).toInt()),
            IntRange(range2.get(0).toInt(),range2.get(1).toInt()))
    }
    fun contains(assignment1: IntRange, assignment2: IntRange) : Boolean {
        return (assignment1.first <= assignment2.first && assignment1.last >= assignment2.last)
                || (assignment2.first <= assignment1.first && assignment2.last >= assignment1.last)
    }

    fun overlaps(assignment1: IntRange, assignment2: IntRange) : Boolean {
        return !assignment1.toSet().intersect(assignment2.toSet()).isEmpty()
    }
}