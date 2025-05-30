package me.deepkverma.mydaggerapplication.di.component

import dagger.Component
import me.deepkverma.mydaggerapplication.di.ActivityScope
import me.deepkverma.mydaggerapplication.di.module.ActivityModule
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import me.deepkverma.mydaggerapplication.main.MainActivity

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject(activity: MainActivity)

}