package com.kevinabrioux.mvvmimplementation.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kevinabrioux.mvvmimplementation.BR
import com.kevinabrioux.mvvmimplementation.R
import com.kevinabrioux.mvvmimplementation.databinding.ActivityMainBinding
import com.kevinabrioux.mvvmimplementation.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        this.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = this.viewModel
        binding.setVariable(BR.viewModel, this.viewModel)
        this.viewModel.bind(binding)
        binding.executePendingBindings()
    }
}
