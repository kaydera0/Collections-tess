package com.example.task3.data.utilits

import com.example.task3.data.repositories.MapRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class TreeMapsOperationsTest {

    @Test
    fun addResultType() = runBlocking {
        val testArr = MapRepository().initTreeMapLists(1000)
        val result = TreeMapsOperations(testArr[0]).add(1000)
        assertTrue(result is Long)
    }

    @Test
    fun searchResultType() = runBlocking {
        val testArr = MapRepository().initTreeMapLists(1000)
        val result = TreeMapsOperations(testArr[0]).search()
        assertTrue(result is Long)
    }

    @Test
    fun removeResultType() = runBlocking {
        val testArr = MapRepository().initTreeMapLists(1000)
        val result = TreeMapsOperations(testArr[0]).remove(1000)
        assertTrue(result is Long)
    }
}