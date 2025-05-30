package me.deepkverma.mydaggerapplication.data.local

import android.content.Context
import me.deepkverma.mydaggerapplication.di.qualifiers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseService @Inject constructor(@qualifiers.ApplicationContext val  context: Context,@qualifiers.DataBaseName val dbName: String = "MyDB "){

}