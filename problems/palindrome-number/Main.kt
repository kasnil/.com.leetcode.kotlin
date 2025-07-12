package com.github.kasnil.leetcode.problems.palindromenumber

/**
 * https://leetcode.com/problems/palindrome-number/
 */
fun main() {
    val solution = Solution()

    println("Example 1: ${solution.isPalindrome(121) == true}")
    println("Example 2: ${solution.isPalindrome(-121) == false}")
    println("Example 3: ${solution.isPalindrome(10) == false}")
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var reverse = x % 10;
        var copyX = x / 10
        while(copyX > 0) {
            reverse = reverse * 10 + copyX % 10
            copyX /= 10
        }
        return x == copyX
    }
}