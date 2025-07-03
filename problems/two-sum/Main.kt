package com.github.kasnil.leetcode.problems.two_sum

/** 
 * https://leetcode.com/problems/two-sum/
 */
fun main() {
    val solution = Solution()

    println("Example 1: ${solution.twoSum(intArrayOf(2,7,11,15), 9).contentEquals(intArrayOf(0, 1))}")
    println("Example 2: ${solution.twoSum(intArrayOf(3,2,4), 6).contentEquals(intArrayOf(1, 2))}")
    println("Example 3: ${solution.twoSum(intArrayOf(3,3), 6).contentEquals(intArrayOf(0, 1))}")
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num -> 
            if (map.containsKey(target - num)) {
                return intArrayOf(map.getValue(target - num), index)
            }
            map += num to index
        }

        return intArrayOf(-1, -1)
    }
}