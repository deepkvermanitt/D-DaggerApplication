package com.deepkverma.feature_user

import android.content.Context
import com.deepkverma.core.di.qualifier.UserScope
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@UserScope
class UserManager @Inject constructor(@ApplicationContext private val context: Context) {
    fun login(user: String) { /* logic */
    }

    fun logout() { /* logic */
    }
}
