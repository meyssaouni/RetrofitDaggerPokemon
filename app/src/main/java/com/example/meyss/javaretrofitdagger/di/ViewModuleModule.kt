package com.example.meyss.javaretrofitdagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.meyss.javaretrofitdagger.viewModel.ActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModuleModule {

    @Binds
     abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(ActivityViewModel::class)
    abstract  fun bindsActivityViewModel( actViewModel: ActivityViewModel): ViewModel


}