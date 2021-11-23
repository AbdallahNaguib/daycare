package com.example.daycare.ui.parent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daycare.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainParentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_parent)
    }

}