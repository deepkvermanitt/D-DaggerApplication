package com.deepkverma.core.data.local

import android.content.Context
import com.deepkverma.core.di.qualifier.qualifiers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseService @Inject constructor(@qualifiers.ApplicationContext val  context: Context, @qualifiers.DataBaseName val dbName: String = "MyDB "){

}