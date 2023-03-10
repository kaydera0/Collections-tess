package com.example.task3.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.task3.R
import com.example.task3.databinding.FragmentDoubleBinding

class DoubleFragment : Fragment() {
    private lateinit var binding: FragmentDoubleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoubleBinding.inflate(layoutInflater)
        val view: View = binding.root
        val pfm: FragmentManager = childFragmentManager
        val ft: FragmentTransaction = pfm.beginTransaction()
        ft.add(R.id.doubleFragmentContainer, MapsFragmentSize())
        ft.commit()
        return view
    }
}