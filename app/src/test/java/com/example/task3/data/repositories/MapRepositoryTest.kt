package com.example.task3.data.repositories

import androidx.annotation.Nullable
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class MapRepositoryTest {

    @Test
    fun initTreeMapLists() = runBlocking {
        val testTreeMapArray = MapRepository().initTreeMapLists(1000)
        assertEquals(3, testTreeMapArray.size)
        assertEquals(1000, testTreeMapArray[0].size)
        assertEquals(TreeMap<Int, Nullable?>().javaClass, testTreeMapArray[0].javaClass)
    }

    @Test
    fun initTreeMapListsCheckArraySize() = runBlocking {
        val testTreeMapArray = MapRepository().initTreeMapLists(1000)
        assertEquals(3, testTreeMapArray.size)
    }

    @Test
    fun initTreeMapListsCheckArraySizeElement() = runBlocking {
        val testTreeMapArray = MapRepository().initTreeMapLists(1000)
        assertEquals(1000, testTreeMapArray[0].size)
    }

    @Test
    fun initTreeMapListsCheckArrayClass() = runBlocking {
        val testTreeMapArray = MapRepository().initTreeMapLists(1000)
        assertEquals(TreeMap<Int, Nullable?>().javaClass, testTreeMapArray[0].javaClass)
    }

    @Test
    fun initHashMapListsArraySize() = runBlocking {
        val testHashMapArray = MapRepository().initHashMapLists(1000)
        assertEquals(3, testHashMapArray.size)
    }

    @Test
    fun initHashMapListsArraySizeElement() = runBlocking {
        val testHashMapArray = MapRepository().initHashMapLists(1000)
        assertEquals(1000, testHashMapArray[0].size)
    }

    @Test
    fun initHashMapListsArrayClass() = runBlocking {
        val testHashMapArray = MapRepository().initHashMapLists(1000)
        assertEquals(HashMap<Int, Nullable?>().javaClass, testHashMapArray[0].javaClass)
    }
}