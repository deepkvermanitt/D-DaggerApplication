package me.deepkverma.mydaggerapplication.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import me.deepkverma.mydaggerapplication.App
import me.deepkverma.mydaggerapplication.di.ActivityScope
import me.deepkverma.mydaggerapplication.main.MainActivity
import me.deepkverma.mydaggerapplication.main.MainViewModel
import me.deepkverma.mydaggerapplication.main.MainViewModelFactory

@Module
class ActivityModule(val activity: MainActivity) {
    @ActivityScope
    @Provides
    fun provideActivity(): MainActivity {
        return activity
    }

    @Provides
    @ActivityScope
    fun provideMainViewModel(): MainViewModel {
        return MainViewModel((activity.application as App).applicationComponent.getDatabaseService())
    }

    @Provides
    @ActivityScope
    fun provideViewModelFactory(mainViewModel: MainViewModel): MainViewModelFactory {
        return MainViewModelFactory(mainViewModel)
    }
}