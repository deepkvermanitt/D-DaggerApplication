package com.deepkverma.core.di.qualifier

import javax.inject.Qualifier

class qualifiers {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApplicationContext

    @Qualifier
    @Retention
    annotation class DataBaseName


    @Qualifier
    @Retention
    annotation class DataBaseVersion
}