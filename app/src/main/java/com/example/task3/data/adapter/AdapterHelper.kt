package com.example.task3.data.adapter

import android.content.Context
import android.view.View
import androidx.annotation.VisibleForTesting
import com.example.task3.R
import com.example.task3.presentation.uiElements.UICellModel

class AdapterHelper(context: Context?) {

    private val collectionsList = listOf("ArrayList", "LinkedList", "CopyOnWriteArrayList")
    private val mapsList = listOf("TreeMap", "HashMap")
    private val collectionOperations =
        context?.resources?.getStringArray(R.array.collection_operations)
    private val mapOperations = context?.resources?.getStringArray(R.array.map_operations)

    private val UICellModels = arrayListOf<UICellModel>()
    private val cellsMap = arrayListOf<UICellModel>()

    init {
        createCellsList(collectionsList, collectionOperations?.asList() as List<String>)
        createCellsListMaps(mapsList, mapOperations?.asList() as List<String>)
    }

    @VisibleForTesting
    fun createCellsList(collectionsList: List<String>, operations: List<String>) {
        var indexCollections = 0
        var indexOperations = 0
        var id = 0

        repeat(21) {
            val UICellModel =
                UICellModel(
                    collectionsList[indexCollections],
                    operations[indexOperations],
                    "N/A ms",
                    View.INVISIBLE,
                    id
                )
            indexCollections++
            id++

            if (indexCollections == 3) {
                indexOperations++
            }
            if (indexCollections == 3) {
                indexCollections = 0
            }

            UICellModels.add(UICellModel)
        }
    }

    fun getCellByIndex(index: Int): UICellModel {
        return UICellModels[index]
    }
    @VisibleForTesting
    fun createCellsListMaps(mapsList: List<String>, operations: List<String>) {
        var indexCollections = 0
        var indexOperations = 0
        var id = 0

        repeat(6) {
            val UICellModel =
                UICellModel(
                    mapsList[indexCollections],
                    operations[indexOperations],
                    "N/A ms",
                    View.INVISIBLE,
                    id
                )
            indexCollections++
            id++

            if (indexCollections == 2) {
                indexOperations++
            }
            if (indexCollections == 2) {
                indexCollections = 0
            }

            cellsMap.add(UICellModel)
        }
    }

    fun getCellByIndexMap(index: Int): UICellModel {
        return cellsMap[index]
    }

    fun getCellsList(): ArrayList<UICellModel> {
        return UICellModels
    }
    fun getCellsListMap(): ArrayList<UICellModel> {
        return cellsMap
    }

}