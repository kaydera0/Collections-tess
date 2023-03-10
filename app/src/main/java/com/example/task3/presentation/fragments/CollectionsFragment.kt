package com.example.task3.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.task3.R
import com.example.task3.databinding.FragmentCollectionsBinding
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.adapter.MyListAdapter
import com.example.task3.presentation.viewModels.CollectionsViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CollectionsFragment : Fragment() {
    private val viewModel by viewModel<CollectionsViewModel>()
    private var binding: FragmentCollectionsBinding? = null
    private val myListAdapter: MyListAdapter by inject()
    private val adapterHelper: AdapterHelper by inject()
    private var collectionSize = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCollectionsBinding.inflate(layoutInflater)

        val view: FrameLayout? = binding?.root

        setAdapter()

        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()

        setFragmentResultListener("collections") { key, bundle ->
            collectionSize = bundle.getInt("name")
        }
        Log.d("collection", collectionSize.toString())

        val listRepository = viewModel.initListRepository(collectionSize)

        binding?.startBtnColl?.setOnClickListener {

            viewModel.inProcess.value = true

            binding?.recycleCollections?.adapter = myListAdapter

            if (binding?.elementAmount?.length() == 0) {
                binding?.elementAmount?.error = "input amount"
            } else {

                val elementsAmount: Int = binding?.elementAmount?.text.toString().toInt()

                viewModel.operationsTimeCalculate(elementsAmount, listRepository)

            }

        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun btnCondition(isPressed: Boolean) {
        binding?.startBtnColl?.setText(if (isPressed) R.string.stop else R.string.start)
        binding?.startBtnColl?.background =
            if (isPressed) resources.getDrawable(R.drawable.stop_btn) else resources.getDrawable(
                R.drawable.start_btn
            )
    }

    private fun setAdapter() = with(binding) {

        this?.recycleCollections?.layoutManager = GridLayoutManager(context, 3)
        myListAdapter.submitList(adapterHelper.getCellsList())


        setObservers()


        this?.recycleCollections?.adapter = myListAdapter
    }

    private fun setObservers() {
        var counter = 0

        viewModel.liveDataArray.observe(
            viewLifecycleOwner,
            Observer {
                myListAdapter.submitList(it)

                counter++
                Log.d("qwe", counter.toString())
                if (counter == 20) {
                    counter = 0
                    viewModel.inProcess.postValue(false)
                }
            }
        )
        viewModel.inProcess.observe(viewLifecycleOwner, Observer {
            btnCondition(it)
            Log.d("observer", it.toString())
        })
    }
}