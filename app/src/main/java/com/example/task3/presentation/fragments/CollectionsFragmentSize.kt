package com.example.task3.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import com.example.task3.R
import com.example.task3.databinding.FragmentCollectionsSizeBinding

class CollectionsFragmentSize : Fragment() {

    private lateinit var binding: FragmentCollectionsSizeBinding
    private var collectionSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCollectionsSizeBinding.inflate(layoutInflater)
        val view: View = binding.root

        binding.calculate.setOnClickListener {
            val pfm: FragmentManager = parentFragmentManager
            val ft: FragmentTransaction = pfm.beginTransaction()
            ft.replace(R.id.collectionsContainer, CollectionsFragment())

            if (binding.collectionSize.length() == 0) {
                binding.textInputLayoutCollSize?.error = "input field is empty"
                binding.textInputLayoutCollSize?.boxStrokeWidth = 2
                binding.errorLayout?.visibility = View.VISIBLE

            } else {
                collectionSize = binding.collectionSize.text.toString().toInt()
                val result = collectionSize
                Log.d("viewM", collectionSize.toString())
                setFragmentResult("collections", bundleOf("name" to result))
                ft.commit()
            }
        }
        return view
    }
}