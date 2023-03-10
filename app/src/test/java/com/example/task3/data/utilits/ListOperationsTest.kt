package com.example.task3.data.utilits

import com.example.task3.data.repositorys.ListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class ListOperationsTest {
    @Test
    fun addInBeginResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).addInBegin(1000)
        assertTrue(result is Long)
    }

    @Test
    fun addInMiddleResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).addInBegin(1000)
        assertTrue(result is Long)
    }

    @Test
    fun addInEndResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).addInMiddle(1000)
        assertTrue(result is Long)
    }

    @Test
    fun searchResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).search()
        assertTrue(result is Long)
    }

    @Test
    fun removeInBeginResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).removeInBegin(1000)
        assertTrue(result is Long)
    }

    @Test
    fun removeInMiddleResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).removeInMiddle(1000)
        assertTrue(result is Long)
    }

    @Test
    fun removeInEndResultType() = runBlocking {
        val testArr = ListRepository().initArrayLists(1000)
        val result = ListOperations(testArr[0]).removeInEnd(1000)
        assertTrue(result is Long)
    }
}