package com.example.task3.presentation.viewModels

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task3.R
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.repositorys.ListRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertTrue


@RunWith(AndroidJUnit4::class)
class CollectionsViewModelTest {

    private lateinit var viewModel: CollectionsViewModel
    private lateinit var adapterHelper: AdapterHelper

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    val listRepository = mockk<ListRepository> {
        coEvery { initArrayLists(any()) } returns arrayListOf()
        coEvery { initCopyLists(any()) } returns arrayListOf()
        coEvery { initLinkedLists(any()) } returns arrayListOf()
        every { setArrLists(any()) } just runs
        every { setCopyLists(any()) } just runs
        every { setLinkedLists(any()) } just runs
    }

    @Before
    fun setupViewModel() {
        val context = mockk<Context>()
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
        viewModel = CollectionsViewModel(listRepository, adapterHelper)
    }

    @Test
    fun initListRepository() {
        val collectionSize = 1
        val result = viewModel.initListRepository(collectionSize)
        coVerify { listRepository.initArrayLists(collectionSize) }
        coVerify { listRepository.initCopyLists(collectionSize) }
        coVerify { listRepository.initLinkedLists(collectionSize) }
        verify { listRepository.setArrLists(any()) }
        verify { listRepository.setLinkedLists(any()) }
        verify { listRepository.setCopyLists(any()) }
        assertEquals(result, listRepository)
    }

    @Test
    fun operationsTimeCalculate() = runBlocking {
        val liveDataArrayBefore = viewModel.liveDataArray.value
        val collectionSize = 1000
        val listRepository = ListRepository()
        listRepository.arrayListsArray = listRepository.initArrayLists(collectionSize)
        listRepository.copyListsArray = listRepository.initCopyLists(collectionSize)
        listRepository.linkedListsArray = listRepository.initLinkedLists(collectionSize)
        viewModel.operationsTimeCalculate(1000, listRepository)
        Thread.sleep(1000)
        assertTrue(liveDataArrayBefore != viewModel.liveDataArray.value)
    }
}