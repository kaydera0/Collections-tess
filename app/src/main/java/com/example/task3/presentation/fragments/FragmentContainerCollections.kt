package com.example.task3.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.task3.R
import com.example.task3.databinding.FragmentContainerCollectionsBinding

class FragmentContainerCollections : Fragment() {
    private lateinit var binding: FragmentContainerCollectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContainerCollectionsBinding.inflate(layoutInflater)
        val view: View = binding.root
        val pfm: FragmentManager = childFragmentManager
        val ft: FragmentTransaction = pfm.beginTransaction()
        ft.add(R.id.collectionsContainer, CollectionsFragmentSize())
        ft.commit()
        return view
    }
}