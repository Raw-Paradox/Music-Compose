package com.cyb.musicplayer

import kotlinx.coroutines.runBlocking

/**
 * Created by Paradoox on 2020/12/22.
 */
class A(str: String) {
    var toBeModified: String = str
}

class Test {
    fun test(a: A) {
        println("origin a: ${a.toBeModified}")
        Thread {
//            Thread.sleep(5000)
            a.toBeModified = "modified"
            println("new Thread a: ${a.toBeModified}")
        }.start()
        Thread.sleep(2000)
        println("origin Thread a: ${a.toBeModified}")
        println("origin Thread dead")
    }
}

fun main() = runBlocking<Unit> {
//    Test().test(A("origin"))
    var string = "origin"
    println(string.hashCode())
    Thread {
        string = "hhh"
        println("new thread:${string.hashCode()}")
    }.start()
    Thread.sleep(2000)
    println("origin thread:${string.hashCode()}")
}