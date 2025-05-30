package com.deepkverma.main.di.module
import com.deepkverma.core.di.qualifier.ActivityScope
import com.deepkverma.main.MainActivity
import com.deepkverma.main.viewmodel.MainViewModel
import com.deepkverma.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(val activity: MainActivity) {
    @ActivityScope
    @Provides
    fun provideActivity(): MainActivity {
        return activity
    }
}
