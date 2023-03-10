package com.example.task3.presentation.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.repositories.MapRepository
import com.example.task3.data.utilits.HashMapsOperations
import com.example.task3.data.utilits.TreeMapsOperations
import com.example.task3.presentation.uiElements.UICellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MapsFragmentViewModel(
    private val mapRepository: MapRepository,
    private val adapterHelper: AdapterHelper
) : ViewModel() {

    val inProcess = MutableLiveData<Boolean>()
    val liveDataArray = MutableLiveData<ArrayList<UICellModel>>()

    fun operationsTimeCalculate(elementsAmount: Int, mapRepository: MapRepository) {

        val cellList = adapterHelper.getCellsListMap()
        for (i in 0..5) {
            cellList[i].visibility = View.VISIBLE
        }

        for (i in 0..5) {

            viewModelScope.launch(Dispatchers.IO) {
                val result: Long = when (i) {
                    0 -> TreeMapsOperations(mapRepository.treeMapsRepository[0]).add(elementsAmount)
                    2 -> TreeMapsOperations(mapRepository.treeMapsRepository[1]).search()
                    4 -> TreeMapsOperations(mapRepository.treeMapsRepository[2]).remove(
                        elementsAmount
                    )
                    1 -> HashMapsOperations(mapRepository.hashMapsRepository[0]).add(elementsAmount)
                    3 -> HashMapsOperations(mapRepository.hashMapsRepository[1]).search()
                    5 -> HashMapsOperations(mapRepository.hashMapsRepository[2]).remove(
                        elementsAmount
                    )

                    else -> 0L
                }
                cellList[i].result = "$result ms"
                cellList[i].visibility = View.INVISIBLE
                liveDataArray.postValue(cellList)
            }
        }
    }

    fun initMapRepository(collectionSize: Int): MapRepository {

        viewModelScope.launch(Dispatchers.IO) {
            val treeMaps = mapRepository.initTreeMapLists(collectionSize)
            mapRepository.setTreeMapLists(treeMaps)
            val hashMaps = mapRepository.initHashMapLists(collectionSize)
            mapRepository.setHashMapLists(hashMaps)
        }
        return mapRepository
    }
}