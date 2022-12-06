package day03

import java.io.File
import kotlin.reflect.KFunction1

class Day03 {

    fun day0301(fileName: String) {
        val lines = File(fileName).readLines()
        val totalPriority = lines
            .map{ line -> findDoubleItem(line) }
            .map{ c -> priority(c) }
            .reduce(Int::plus)
        println(String.format("Total priority day3 part 1: %d", totalPriority))
    }

    fun day0302(fileName: String) {
        val totalPriority = File(fileName)
            .readLines()
            .windowed(3, 3)
            .map{group -> badgeOf(group)}
            .map{badge -> priority(badge)}
            .reduce(Int::plus)
        println(String.format("Total priority day3 part2: %d", totalPriority))
    }

    fun badgeOf(group: List<String>) : Char {
        return group
            .map { member -> member.toSet() }
            .reduce(Set<Char>::intersect)
            .first()
    }

    fun findDoubleItem(line: String) : Char {
        val chars = line.toList()
        val halfSize = chars.size/2
        val firstCompartment = chars.subList(0, halfSize).toSet()
        val secondCompartment = chars.subList(halfSize, chars.size).toSet()
        return firstCompartment.intersect(secondCompartment).first()
    }

    fun priority(c : Char) : Int {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) + 1
    }
}
