package com.deepkverma.core.utils


import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoryLooger @Inject constructor() {
    fun logD(message:String){

        Timber.d(message)
    }
    fun logI(message:String){
        Timber.i(message)
    }
}