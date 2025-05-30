package com.deepkverma.main.di.component


import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.main.di.module.ActivityModule
import dagger.Component
import com.deepkverma.core.di.qualifier.ActivityScope
import com.deepkverma.main.MainActivity

@ActivityScope
@Component(modules = [ActivityModule::class] ,dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject(activity: MainActivity)

}