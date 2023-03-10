package com.example.task3.data.repositories

import com.example.task3.data.repositorys.ListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ListRepositoryTest {

    @Test
    fun initArrayListsTestCheckSizeArray() = runBlocking {
        val testArrayLists = ListRepository().initArrayLists(1000)
        assertEquals(7, testArrayLists.size)
    }

    @Test
    fun initArrayListsTestCheckSizeArrayElement() = runBlocking {
        val testArrayLists = ListRepository().initArrayLists(1000)
        assertEquals(1000, testArrayLists[0].size)
    }

    @Test
    fun initLinkedListsCheckSizeArray() = runBlocking {
        val testLinkedLists = ListRepository().initLinkedLists(1000)
        assertEquals(7, testLinkedLists.size)
    }

    @Test
    fun initLinkedListsCheckSizeArrayElement() = runBlocking {
        val testLinkedLists = ListRepository().initLinkedLists(1000)
        assertEquals(1000, testLinkedLists[0].size)
    }

    @Test
    fun initCopyListsCheckArraySize() = runBlocking {
        val testCopyLists = ListRepository().initCopyLists(1000)
        assertEquals(7, testCopyLists.size)
    }

    @Test
    fun initCopyListsCheckArraySizeElement() = runBlocking {
        val testCopyLists = ListRepository().initCopyLists(1000)
        assertEquals(1000, testCopyLists[0].size)
    }
}