package com.example.task3

import org.junit.Test
import java.util.*
import kotlin.system.measureTimeMillis

class TestLinked {
    @Test
    fun createLinkedListandadd1000000elementsatstart() {
        val time = measureTimeMillis {
            val mln = 1_000_000
//            val mln = 10000000
            val list = LinkedList<Int>().apply {
                while (this.size < mln) {
                    this.listIterator().add(0)
                }
            }
            while (list.size < mln * 2) {
                list.listIterator().add(0)
            }
            assert(list.size == mln * 2)
        }
        println("add at start time took $time")
    }

    @Test
    fun createLinkedListandadd1000000elementsatend() {
        val time = measureTimeMillis {
            val mln = 1_000_000
            val list = LinkedList<Int>().apply {
                while (this.size < mln) {
                    this.listIterator().add(0)
                }
            }
            while (list.size < mln * 2) {
                list.listIterator(list.lastIndex).add(0)
            }
            assert(list.size == mln * 2)
        }
        println("add at end time took $time")
    }

    @Test
    fun createLinkedListandadd1000000elementsatmiddle() {
        val time = measureTimeMillis {
            val mln = 1_000_000
            val list = LinkedList<Int>().apply {
                while (this.size < mln) {
                    this.listIterator().add(0)
                }
            }
            val list1 = LinkedList<Int>().apply {
                while (this.size < mln) {
                    this.listIterator().add(0)
                }
            }
            while (list.size < mln * 2) {
                list.addAll(list.size/2, list1)
            }
            assert(list.size == mln * 2)
        }
        println("add at middle time took $time")
    }
}

