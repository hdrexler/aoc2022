import day01.Day01
import day02.Day02
import day03.Day03

fun main(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")
    val day01 = Day01()
    day01.day0101(args[0])
    day01.day0102(args[0])
    val day02 = Day02()
    day02.day0201(args[1])
    day02.day0202(args[1])
    val day03= Day03()
    day03.day0301(args[2])
    day03.day0302(args[2])
}