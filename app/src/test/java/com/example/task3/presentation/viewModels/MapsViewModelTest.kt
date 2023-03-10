package com.example.task3.presentation.viewModels

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.task3.R
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.repositories.MapRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertTrue

@RunWith(AndroidJUnit4::class)
class MapsViewModelTest {
    private lateinit var viewModel: MapsFragmentViewModel
    private lateinit var adapterHelper: AdapterHelper

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    val mapRepository = mockk<MapRepository> {
        coEvery { initTreeMapLists(any()) } returns arrayListOf()
        coEvery { initHashMapLists(any()) } returns arrayListOf()
        every { setTreeMapLists(any()) } just runs
        every { setHashMapLists(any()) } just runs
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
        viewModel = MapsFragmentViewModel(mapRepository, adapterHelper)
    }

    @Test
    fun initMapRepository() {
        val collectionSize = 1
        val result = viewModel.initMapRepository(collectionSize)
        coVerify { mapRepository.initTreeMapLists(collectionSize) }
        coVerify { mapRepository.initHashMapLists(collectionSize) }
        verify { mapRepository.setTreeMapLists(any()) }
        verify { mapRepository.setHashMapLists(any()) }
        Assert.assertEquals(result, mapRepository)
    }

    @Test
    fun operationsTimeCalculate() = runBlocking {
        val liveDataArrayBefore = viewModel.liveDataArray.value
        val collectionSize = 1000
        val mapRepository = MapRepository()
        mapRepository.treeMapsRepository = mapRepository.initTreeMapLists(collectionSize)
        mapRepository.hashMapsRepository = mapRepository.initHashMapLists(collectionSize)
        viewModel.operationsTimeCalculate(1000, mapRepository)
        Thread.sleep(1000)
        assertTrue(liveDataArrayBefore != viewModel.liveDataArray.value)
    }
}