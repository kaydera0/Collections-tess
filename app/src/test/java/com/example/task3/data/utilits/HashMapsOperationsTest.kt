package com.example.task3.data.utilits

import com.example.task3.data.repositories.MapRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class HashMapsOperationsTest {

    @Test
    fun addResultType() = runBlocking {
        val testArr = MapRepository().initHashMapLists(1000)
        val result = HashMapsOperations(testArr[0]).add(1000)
        assertTrue(result is Long)
    }

    @Test
    fun searchResultType() = runBlocking {
        val testArr = MapRepository().initHashMapLists(1000)
        val result = HashMapsOperations(testArr[0]).search()
        assertTrue(result is Long)
    }

    @Test
    fun removeResultType() = runBlocking {
        val testArr = MapRepository().initHashMapLists(1000)
        val result = HashMapsOperations(testArr[0]).remove(1000)
        assertTrue(result is Long)
    }
}