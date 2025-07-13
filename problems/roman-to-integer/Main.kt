package com.github.kasnil.leetcode.problems.romantointeger

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
fun main() {
    val solution = Solution()

    println("Example 1: ${solution.romanToInt("III") == 3}")
    println("Example 2: ${solution.romanToInt("LVIII") == 58}")
    println("Example 3: ${solution.romanToInt("MCMXCIV") == 1994}")
}

class Solution {
    fun romanToInt(s: String): Int {
        val romanNumerals =
            mapOf(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000,
            )

        var sum = 0
        var last = 0
        s.forEach {
            val cur = romanNumerals.getValue(it)
            sum += cur
            if (cur > last) {
                sum -= 2 * last
            }
            last = cur
        }
        return sum
    }
}
