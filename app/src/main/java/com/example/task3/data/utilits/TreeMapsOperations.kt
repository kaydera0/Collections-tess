package com.example.task3.data.utilits

import androidx.annotation.Nullable
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis

class TreeMapsOperations<T>(private val map: T) where T : TreeMap<Int, Any?> {

    suspend fun add(elementsAmount: Int) = suspendCoroutine {

        val timeInMillis = measureTimeMillis {
            for (i in 0 until elementsAmount) {
                map.put(map.size + i, null)
            }
        }
        it.resume(timeInMillis)
    }

    suspend fun search() = suspendCoroutine {
        val timeInMillis = measureTimeMillis {

            map.contains((0..map.size).random())
        }
        it.resume(timeInMillis)
    }

    suspend fun remove(elementsAmount: Int) = suspendCoroutine {

        val timeInMillis = measureTimeMillis {
            repeat(elementsAmount) {
                map.remove(0)
            }
        }
        it.resume(timeInMillis)
    }
}