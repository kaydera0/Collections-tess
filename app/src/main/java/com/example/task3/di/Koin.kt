package com.example.task3.di

import com.example.task3.data.adapter.AdapterHelper
import com.example.task3.data.adapter.MyListAdapter
import com.example.task3.data.adapter.PageAdapter
import com.example.task3.data.repositories.MapRepository
import com.example.task3.data.repositorys.ListRepository
import com.example.task3.presentation.viewModels.CollectionsViewModel
import com.example.task3.presentation.viewModels.MapsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { CollectionsViewModel(get(),get()) }
    viewModel { MapsFragmentViewModel(get(),get()) }

    single { ListRepository() }
    single { MapRepository() }
    single { MyListAdapter() }
    single { AdapterHelper(get()) }
    single { PageAdapter(get(),get(),get())}


}






