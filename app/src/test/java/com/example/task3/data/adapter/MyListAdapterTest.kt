package com.example.task3.data.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.task3.presentation.fragments.DoubleFragment
import com.example.task3.presentation.fragments.FragmentContainerCollections
import com.example.task3.presentation.uiElements.UICellModel
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyListAdapterTest {

    private lateinit var myListAdapter: MyListAdapter

    @Before
    fun init() {
        myListAdapter = MyListAdapter()
    }

    @Test
    fun getCellList() {
        assertEquals(myListAdapter.getCellList().javaClass, ArrayList<UICellModel>().javaClass)

    }

    @Test
    fun addCell() {
        val cell = UICellModel("", "", "", 1, 1)
        myListAdapter.addCell(cell)
        val testCell = myListAdapter.getCellList()[0]
        assertEquals(cell, testCell)
    }
}

