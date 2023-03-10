package com.example.task3.data.repositorys


import java.util.*
import java.util.List
import java.util.concurrent.CopyOnWriteArrayList

class ListRepository() {

    var arrayListsArray = ArrayList<List<Any?>>()
    var linkedListsArray = ArrayList<List<Any?>>()
    var copyListsArray = ArrayList<List<Any?>>()

    suspend fun initArrayLists(size: Int): ArrayList<List<Any?>> {
        val arrayLists = arrayListOf<List<Any?>>()
        val n: kotlin.collections.List<Any?> = kotlin.collections.List(size) { null }

        repeat(7) {
            val arrayList = ArrayList<Any?>().apply { addAll(n) } as List<Any?>
            arrayLists.add(arrayList)
        }
        return arrayLists
    }

    suspend fun initLinkedLists(size: Int): ArrayList<List<Any?>> {
        val linkedLists = arrayListOf<List<Any?>>()
        val n: kotlin.collections.List<Any?> = kotlin.collections.List(size) { null }

        repeat(7) {
            val linkedList = LinkedList<Any?>().apply { addAll(n) } as List<Any?>
            linkedLists.add(linkedList)
        }
        return linkedLists
    }

    suspend fun initCopyLists(size: Int): ArrayList<List<Any?>> {
        val copyLists = arrayListOf<List<Any?>>()
        val n: kotlin.collections.List<Any?> = kotlin.collections.List(size) { null }

        repeat(7) {
            var copyList = CopyOnWriteArrayList<Any?>().apply { addAll(n) } as List<Any?>
            copyLists.add(copyList)
        }
        return copyLists
    }

    fun setArrLists(arrayLists: ArrayList<List<Any?>>) {
        this.arrayListsArray = arrayLists
    }

    fun setLinkedLists(linkedLists: ArrayList<List<Any?>>) {
        this.linkedListsArray = linkedLists
    }

    fun setCopyLists(copyLists: ArrayList<List<Any?>>) {
        this.copyListsArray = copyLists
    }
}