package com.kevinabrioux.mvvmimplementation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.kevinabrioux.mvvmimplementation.R
import com.kevinabrioux.mvvmimplementation.listener.LightListener
import com.kevinabrioux.mvvmimplementation.manager.LightManager


class MainActivity : AppCompatActivity() {

    var lightManager: LightManager? = null
    private var lightTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.lightTextView = this.findViewById(R.id.textView_light)
        this.lightManager = LightManager(this, object : LightListener() {
            override fun onLightChange(light: Int?) {
                this@MainActivity.lightTextView?.text = light.toString()
            }
        })
    }
}
