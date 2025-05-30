package me.deepkverma.mydaggerapplication.di.component

import com.deepkverma.core.di.qualifier.ActivityScope
import dagger.Component
import me.deepkverma.mydaggerapplication.di.module.ActivityModule
import me.deepkverma.mydaggerapplication.main.MainActivity

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject(activity: MainActivity)

}