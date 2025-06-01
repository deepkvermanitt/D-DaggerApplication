package com.deepkverma.core.di.qualifier

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class UserScope
