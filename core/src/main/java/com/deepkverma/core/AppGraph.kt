package com.deepkverma.core

import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.core.utils.MemoryLooger

interface AppGraph {
    val appDatabaseService: DataBaseService
    val appMemoryLogger: MemoryLooger
    val applicationComponent: ApplicationComponent // 👈 YOU MUST ADD THIS

}