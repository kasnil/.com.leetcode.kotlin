package com.github.kasnil.leetcode.problems.addtwonumbers

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
fun main() {
    val solution = Solution()

    println(
        "Example 1: ${equals(
            solution.addTwoNumbers(arrayToListNode(intArrayOf(2,4,3)), arrayToListNode(intArrayOf(5,6,4))),
            arrayToListNode(intArrayOf(7,0,8)),
        )}",
    )
    println(
        "Example 2: ${equals(
            solution.addTwoNumbers(arrayToListNode(intArrayOf(0)), arrayToListNode(intArrayOf(0))),
            arrayToListNode(intArrayOf(0)),
        )}",
    )
    println(
        "Example 3: ${equals(
            solution.addTwoNumbers(arrayToListNode(intArrayOf(9,9,9,9,9,9,9)), arrayToListNode(intArrayOf(9,9,9,9))),
            arrayToListNode(intArrayOf(8,9,9,9,0,0,0,1)),
        )}",
    )
    println(
        "Example 4: ${equals(
            solution.addTwoNumbers(arrayToListNode(intArrayOf(9)), arrayToListNode(intArrayOf(1,9,9,9,9,9,9,9,9,9))),
            arrayToListNode(intArrayOf(0,0,0,0,0,0,0,0,0,0,1)),
        )}",
    )
    println(
        "Example 5: ${equals(
            solution.addTwoNumbers(arrayToListNode(intArrayOf(5)), arrayToListNode(intArrayOf(5))),
            arrayToListNode(intArrayOf(0,1)),
        )}",
    )
}

fun arrayToListNode(arr: IntArray): ListNode? {
    if (arr.size == 0) {
        return null
    }
    val root = ListNode(arr[0])
    (1..<(arr.size)).map { ListNode(arr[it]) }.fold(root) { acc, next ->
        acc.next = next
        next
    }
    return root
}

fun equals(
    l1: ListNode?,
    l2: ListNode?,
): Boolean {
    if (l1 == null && l2 == null) {
        return true
    }
    if (l1 == null && l2 != null || l1 != null && l2 == null) {
        return false
    }
    if (l1?.`val` != l2?.`val`) {
        return false
    }

    return equals(l1?.next, l2?.next)
}

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(
        l1: ListNode?,
        l2: ListNode?,
    ): ListNode? {
        var l1Current: ListNode? = l1
        var l2Current: ListNode? = l2

        var result: ListNode? = ListNode(0)
        var temp: ListNode? = result

        var carry = 0
        while (l1Current != null || l2Current != null) {
            var number = carry
            number += l1Current?.`val` ?: 0
            number += l2Current?.`val` ?: 0

            l1Current = l1Current?.next
            l2Current = l2Current?.next

            temp?.next = ListNode(number % 10)
            temp = temp?.next

            carry =
                if (number >= 10) {
                    1
                } else {
                    0
                }
        }
        if (carry != 0) {
            temp?.next = ListNode(carry)
        }
        return result?.next
    }
}
