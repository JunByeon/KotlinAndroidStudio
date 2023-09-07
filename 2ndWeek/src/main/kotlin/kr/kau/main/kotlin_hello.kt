package kr.kau.main

fun parseIntNumberInBinary(s: String): Int {
    var num = 0

    println("Resource Allocated")
    try {
        if (s.length !in 1..31) throw NumberFormatException("Not a Number: $s")

        for (c in s) {
            if (c !in '0'..'1') throw NumberFormatException("Not a Number: $s")
            num = num * 2 + (c - '0')
        }
    } finally {
        println("Resource Cleared")
    }
    return num
}

fun main() {
    val s = readLine()!!

    val num = try {
        parseIntNumberInBinary(s)
    } catch ( e : NumberFormatException) {
        -1
    }
    println("Number is $num")
}