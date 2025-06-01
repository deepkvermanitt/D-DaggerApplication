package com.deepkverma.core.utils


import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoryLogger @Inject constructor() : AppMemoryLogger {
    @Override
    override fun logD(message: String) {

        Timber.d(message)
    }

    @Override
    override fun logI(message: String) {
        Timber.i(message)
    }
}