package com.example.task3.data.adapter

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task3.R
import com.example.task3.presentation.uiElements.UICellModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AdapterHelperTest {

    private lateinit var adapterHelper: AdapterHelper
    private lateinit var context: Context

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        context = mockk<Context>()
        every { context.resources.getStringArray(R.array.collection_operations) } returns arrayOf(
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
        every { context.resources.getStringArray(R.array.map_operations) } returns arrayOf(
            "",
            "",
            ""
        )
        adapterHelper = AdapterHelper(context)
    }

    @Test
    fun createCellsListMaps(){
        val mapsList = listOf("TreeMap", "HashMap")
        val operationsList = listOf("add","search","remove")
        adapterHelper.createCellsListMaps( mapsList,operationsList)
        val cellListMap = adapterHelper.getCellsListMap()
        assertEquals(cellListMap.size,12)
        assertEquals(cellListMap[11].operation,"remove")
        assertEquals(cellListMap[11].listName,"HashMap")
    }
    @Test
    fun createCellsList(){
        val collectionList = listOf("ArrayList", "LinkedList", "CopyOnWriteArrayList")
        val operationsList = listOf("adding in the beginning",
        "adding in the middle",
        "adding in the end",
        "search by value",
        "removing in the beginning",
        "removing in the middle",
        "removing in the end")
        adapterHelper.createCellsList(collectionList,operationsList)
        val collectionsCellList = adapterHelper.getCellsList()
        assertEquals(collectionsCellList.size,42)
        assertEquals(collectionsCellList[41].operation,"removing in the end")
        assertEquals(collectionsCellList[41].listName,"CopyOnWriteArrayList")
    }
}