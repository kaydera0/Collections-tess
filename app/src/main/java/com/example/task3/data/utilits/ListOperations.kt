package com.example.task3.data.utilits


import java.util.List
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis

class ListOperations<T>(private val numbers: T) where T : List<Any?> {


    suspend fun addInBegin(elementsAmount: Int) = suspendCoroutine {

        val arr = List(elementsAmount) { null }
        val timeInMillis = measureTimeMillis {
            numbers.add(0, arr)
        }
        it.resume(timeInMillis)

    }

    suspend fun addInMiddle(elementsAmount: Int) = suspendCoroutine {
        val arr = List(elementsAmount) { null }
        val timeInMillis = measureTimeMillis {
            numbers.add(numbers.size / 2, arr)
        }
        it.resume(timeInMillis)
    }

    suspend fun addInEnd(elementsAmount: Int) = suspendCoroutine {
        val timeInMillis = measureTimeMillis {
            val arr = List(elementsAmount) { null }
            numbers.add(numbers.size, arr)
        }
        it.resume(timeInMillis)
    }

    suspend fun search() = suspendCoroutine {
        val timeInMillis = measureTimeMillis {
            numbers.find { number ->
                number == null
            }
        }
        it.resume(timeInMillis)
    }

    suspend fun removeInBegin(elementsAmount: Int) = suspendCoroutine {
        val finalSize = numbers.size - elementsAmount
        val timeInMillis = measureTimeMillis {
            while (numbers.size > finalSize && numbers.size > 0) {
                numbers.remove(0)
            }
        }
        it.resume(timeInMillis)
    }

    suspend fun removeInMiddle(elementsAmount: Int) = suspendCoroutine {
        val finalSize = numbers.size - elementsAmount
        val timeInMillis = measureTimeMillis {
            while (numbers.size > finalSize && numbers.size > 0) {
                numbers.remove(numbers.size / 2)
            }
        }
        it.resume(timeInMillis)
    }

    suspend fun removeInEnd(elementsAmount: Int) = suspendCoroutine {
        val finalSize = numbers.size - elementsAmount
        val timeInMillis = measureTimeMillis {
            while (numbers.size > finalSize && numbers.size > 0) {
                numbers.remove(numbers.size - 1)
            }
        }
        it.resume(timeInMillis)
    }
}