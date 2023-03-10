package com.example.task3.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.task3.R
import com.example.task3.databinding.FragmentMapsBinding
import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.adapter.MyListAdapter
import com.example.task3.presentation.viewModels.MapsFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject

class MapsFragment : Fragment() {
    private var binding: FragmentMapsBinding? = null
    private var collectionSize = 0
    private val viewModel by viewModel<MapsFragmentViewModel>()
    private val myListAdapter: MyListAdapter by inject()
    private val adapterHelper: AdapterHelper by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(layoutInflater)
        val view = binding?.root

        setAdapter()

        return view
    }

    override fun onResume() {
        super.onResume()

        setFragmentResultListener("keyMap") { key, bundle ->
            collectionSize = bundle.getInt("name")
        }

        val mapRepository = viewModel.initMapRepository(collectionSize)

        binding?.startBtnMap?.setOnClickListener {

            viewModel.inProcess.value = true

            binding?.recycleMaps?.adapter = myListAdapter

            if (binding?.elementAmountMaps?.length() == 0) {
                binding?.elementAmountMaps?.error = "input amount"
            } else {

                val elementsAmount: Int = binding?.elementAmountMaps?.text.toString().toInt()

                viewModel.operationsTimeCalculate(elementsAmount, mapRepository)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun btnCondition(isPressed: Boolean) {
        binding?.startBtnMap?.setText(if (isPressed) R.string.stop else R.string.start)
        binding?.startBtnMap?.background =
            if (isPressed) resources.getDrawable(R.drawable.stop_btn) else resources.getDrawable(
                R.drawable.start_btn
            )
    }

    private fun setAdapter() = with(binding) {

        this?.recycleMaps?.layoutManager = GridLayoutManager(context, 3)
        myListAdapter.submitList(adapterHelper.getCellsListMap())

        setObservers()

        this?.recycleMaps?.adapter = myListAdapter
    }

    private fun setObservers() {
        var counter = 0

        viewModel.liveDataArray.observe(
            viewLifecycleOwner,
            Observer {
                myListAdapter.submitList(it)

                counter++
                Log.d("qwe", counter.toString())
                if (counter == 5) {
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