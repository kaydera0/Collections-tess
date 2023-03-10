package com.example.task3.presentation.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.repositorys.ListRepository
import com.example.task3.data.utilits.ListOperations
import com.example.task3.presentation.uiElements.UICellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectionsViewModel(
    private val listRepository: ListRepository,
    private val adapterHelper: AdapterHelper
) : ViewModel() {

    val liveDataArray = MutableLiveData<ArrayList<UICellModel>>()
    val inProcess = MutableLiveData<Boolean>()

    fun operationsTimeCalculate(elementsAmount: Int, listRepository: ListRepository) {

        val cellList = adapterHelper.getCellsList()
        for (i in 0..20) {
            cellList[i].visibility = View.VISIBLE
        }

        for (i in 0..20) {

            viewModelScope.launch(Dispatchers.IO) {
                val result: Long = when (i) {
                    0 -> ListOperations(listRepository.arrayListsArray[0]).addInBegin(elementsAmount)
                    3 -> ListOperations(listRepository.arrayListsArray[1]).addInMiddle(
                        elementsAmount
                    )
                    6 -> ListOperations(listRepository.arrayListsArray[2]).addInEnd(elementsAmount)
                    9 -> ListOperations(listRepository.arrayListsArray[3]).search()
                    12 -> ListOperations(listRepository.arrayListsArray[4]).removeInBegin(
                        elementsAmount
                    )
                    15 -> ListOperations(listRepository.arrayListsArray[5]).removeInMiddle(
                        elementsAmount
                    )
                    18 -> ListOperations(listRepository.arrayListsArray[6]).removeInEnd(
                        elementsAmount
                    )

                    1 -> ListOperations(listRepository.linkedListsArray[0]).addInBegin(
                        elementsAmount
                    )
                    4 -> ListOperations(listRepository.linkedListsArray[1]).addInMiddle(
                        elementsAmount
                    )
                    7 -> ListOperations(listRepository.linkedListsArray[2]).addInEnd(elementsAmount)
                    10 -> ListOperations(listRepository.linkedListsArray[3]).search()
                    13 -> ListOperations(listRepository.linkedListsArray[4]).removeInBegin(
                        elementsAmount
                    )
                    16 -> ListOperations(listRepository.linkedListsArray[5]).removeInMiddle(
                        elementsAmount
                    )
                    19 -> ListOperations(listRepository.linkedListsArray[6]).removeInEnd(
                        elementsAmount
                    )

                    2 -> ListOperations(listRepository.copyListsArray[0]).addInBegin(elementsAmount)
                    5 -> ListOperations(listRepository.copyListsArray[1]).addInMiddle(elementsAmount)
                    8 -> ListOperations(listRepository.copyListsArray[2]).addInEnd(elementsAmount)
                    11 -> ListOperations(listRepository.copyListsArray[3]).search()
                    14 -> ListOperations(listRepository.copyListsArray[4]).removeInBegin(
                        elementsAmount
                    )
                    17 -> ListOperations(listRepository.copyListsArray[5]).removeInMiddle(
                        elementsAmount
                    )
                    20 -> ListOperations(listRepository.copyListsArray[6]).removeInEnd(
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

    fun initListRepository(size: Int): ListRepository {

        viewModelScope.launch(Dispatchers.IO) {
            val arrayLists = listRepository.initArrayLists(size)
            listRepository.setArrLists(arrayLists)
        }
        viewModelScope.launch(Dispatchers.IO) {
            val linkedLists = listRepository.initLinkedLists(size)
            listRepository.setLinkedLists(linkedLists)
        }
        viewModelScope.launch(Dispatchers.IO) {
            val copyLists = listRepository.initCopyLists(size)
            listRepository.setCopyLists(copyLists)
        }
        return listRepository
    }

}