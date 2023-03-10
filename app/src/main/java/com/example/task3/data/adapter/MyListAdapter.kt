package com.example.task3.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.databinding.CellBinding
import com.example.task3.presentation.uiElements.UICellModel


class MyListAdapter : ListAdapter<UICellModel, MyListAdapter.ViewHolder>(UICellsDiff()) {

    private lateinit var binding: CellBinding
    private var UICellModelList = ArrayList<UICellModel>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = CellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: CellBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cell: UICellModel) = with(binding) {
            textViewCell1.text = cell.listName
            textViewCell2.text = cell.operation
            resultSec.text = cell.result
            progressBar.visibility = cell.visibility
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCell(UICellModelTest: UICellModel) {
        UICellModelList.add(UICellModelTest)
    }
    fun getCellList() : ArrayList<UICellModel>{
        return UICellModelList
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }
}

class UICellsDiff : DiffUtil.ItemCallback<UICellModel>() {

    override fun areItemsTheSame(oldItem: UICellModel, newItem: UICellModel): Boolean {
        return oldItem.cellId == newItem.cellId
    }

    override fun areContentsTheSame(oldItem: UICellModel, newItem: UICellModel): Boolean {
        return oldItem == newItem
    }
}