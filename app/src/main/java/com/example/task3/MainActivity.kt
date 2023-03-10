package com.example.task3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.task3.data.adapter.PageAdapter
import com.example.task3.databinding.ActivityMainBinding
import com.example.task3.presentation.fragments.DoubleFragment
import com.example.task3.presentation.fragments.FragmentContainerCollections
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var bindingAdapter: PageAdapter
    private val fragments = mutableListOf(
        FragmentContainerCollections(),
        DoubleFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {

        binding?.ViewPager2?.adapter = PageAdapter(supportFragmentManager, fragments, lifecycle)

        TabLayoutMediator(binding?.tabLayout!!, binding?.ViewPager2!!) { tab, pos ->
            when (pos) {
                0 -> tab.setCustomView(R.layout.collections_tab)
                1 -> tab.setCustomView(R.layout.maps_tab)
            }
        }.attach()
    }
}