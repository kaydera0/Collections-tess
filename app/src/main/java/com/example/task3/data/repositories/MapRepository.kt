package com.example.task3.data.repositories

import androidx.annotation.Nullable
import java.util.*

class MapRepository {

    var treeMapsRepository = ArrayList<TreeMap<Int, Any?>>()
    var hashMapsRepository = ArrayList<HashMap<Int, Any?>>()

    suspend fun initTreeMapLists(size: Int): ArrayList<TreeMap<Int, Any?>> {
        val mapList = arrayListOf<TreeMap<Int, Any?>>()
        val treeMap = TreeMap<Int,  Any?>()
        val treeMap1 = TreeMap<Int, Any?>()
        val treeMap2 = TreeMap<Int, Any?>()

        for (i in 0 until size) {
            treeMap[i] = null
            treeMap1[i] = null
            treeMap2[i] = null
        }
        mapList.add(treeMap)
        mapList.add(treeMap1)
        mapList.add(treeMap2)

        return mapList
    }

    fun setTreeMapLists(treeMapList: ArrayList<TreeMap<Int, Any?>>) {
        this.treeMapsRepository = treeMapList
    }

    suspend fun initHashMapLists(size: Int): ArrayList<HashMap<Int, Any?>> {
        val mapList = arrayListOf<HashMap<Int, Any?>>()
        val hashMap = HashMap<Int,  Any?>()
        val hashMap1 = HashMap<Int, Any?>()
        val hashMap2 = HashMap<Int, Any?>()

        for (i in 0 until size) {
            hashMap[i] = null
            hashMap1[i] = null
            hashMap2[i] = null
        }
        mapList.add(hashMap)
        mapList.add(hashMap1)
        mapList.add(hashMap2)

        return mapList
    }

    fun setHashMapLists(hashMapList: ArrayList<HashMap<Int, Any?>>) {
        this.hashMapsRepository = hashMapList
    }
}