package com.example.codingtest.Programmers.level1.가장가까운글자

import org.junit.jupiter.api.Test

class Kotlin {

    @Test()
    fun main() {
        var result = solution("banana")
        println(result);
    }

    /**
     * 효율성은 별로.
     */
    fun solution(s: String): List<Int> =
            s.withIndex().map {
                s.slice(0 until it.index)
                        .lastIndexOf(it.value)
                        .let { lastIndex -> if (lastIndex >= 0) it.index - lastIndex else -1 }
            }
}