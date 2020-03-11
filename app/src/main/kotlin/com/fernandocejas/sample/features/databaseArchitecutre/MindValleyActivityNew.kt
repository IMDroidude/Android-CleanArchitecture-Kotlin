package com.fernandocejas.sample.features.databaseArchitecutre

import android.content.Context
import android.content.Intent
import com.fernandocejas.sample.core.platform.BaseActivity

class MindValleyActivityNew : BaseActivity(){

    companion object {
        fun callingIntent(context: Context) = Intent(context, MindValleyActivityNew::class.java)
    }

    override fun fragment() = MindValleyFragmentNew()

}