package com.deepkverma.main.di.module.subcomponent

import com.deepkverma.core.di.qualifier.UserScope
import com.deepkverma.main.MainActivity
import dagger.Subcomponent

@UserScope
@Subcomponent
interface UserComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }
}