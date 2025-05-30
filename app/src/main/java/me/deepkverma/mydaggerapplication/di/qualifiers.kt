package me.deepkverma.mydaggerapplication.di

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