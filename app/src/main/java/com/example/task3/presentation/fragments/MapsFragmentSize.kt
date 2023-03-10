package com.example.task3.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import com.example.task3.R
import com.example.task3.databinding.FragmentMapsSizeBinding

class MapsFragmentSize : Fragment() {
    private lateinit var binding: FragmentMapsSizeBinding
    private var collectionSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsSizeBinding.inflate(layoutInflater)
        val view: View = binding.root

        binding.calculateMap?.setOnClickListener {
            val pfm: FragmentManager = parentFragmentManager
            val ft: FragmentTransaction = pfm.beginTransaction()
            ft.replace(R.id.doubleFragmentContainer, MapsFragment())

            if (binding.collectionSizeMap?.length() == 0) {
                binding.textInputLayoutMapSize.error = "input field is empty"
                binding.textInputLayoutMapSize.boxStrokeWidth = 2
                binding.errorLayout?.visibility = View.VISIBLE
            } else {
                collectionSize = binding.collectionSizeMap?.text.toString().toInt()
                val result = collectionSize

                setFragmentResult("keyMap", bundleOf("name" to result))

                ft.commit()
            }
        }
        return view
    }
}