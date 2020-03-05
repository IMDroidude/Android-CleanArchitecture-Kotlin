package com.fernandocejas.sample.features.mindvalleys

import android.content.Context
import android.content.Intent
import com.fernandocejas.sample.core.platform.BaseActivity

class MindValleyActivity : BaseActivity(){

    companion object {
        fun callingIntent(context: Context) = Intent(context, MindValleyActivity::class.java)
    }

    override fun fragment() = MindValleyFragment()

}