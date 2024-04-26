package com.example.testcimb



fun main() {
    //Q1
    val prices1 = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Max profit is: ${maxProfit(prices1)}")

    val prices2 = intArrayOf(7, 6, 4, 3, 1)
    println("Max profit is: ${maxProfit(prices2)}")

    //Q2
    val version1 = "1.01"
    val version2 = "1.001"
    println("Comparison result: ${compareVersion(version1, version2)}")

    val version3 = "1.0"
    val version4 = "1.0.0"
    println("Comparison result: ${compareVersion(version3, version4)}")

    val version5 = "0.1"
    val version6 = "1.1"
    println("Comparison result: ${compareVersion(version5, version6)}")

    //Q3
    val n1 = 1
    println("n1: ${climbStairs(n1)}")

    val n2 = 3
    println("n2: ${climbStairs(n2)}")
}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }

    return maxProfit
}

fun compareVersion(version1: String, version2: String): Int {
    val v1 = version1.split('.')
    val v2 = version2.split('.')
    val n = maxOf(v1.size, v2.size)

    for (i in 0 until n) {
        val num1 = if (i < v1.size) v1[i].toInt() else 0
        val num2 = if (i < v2.size) v2[i].toInt() else 0

        if (num1 < num2) return -1
        else if (num1 > num2) return 1
    }

    return 0
}

fun climbStairs(n: Int): Int {
    if (n < -1 || n > 45) return 0
    if (n == 1 || n == -1) return 1

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}
