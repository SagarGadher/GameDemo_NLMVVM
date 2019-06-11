package com.example.gamedemo.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gamedemo.R
import com.example.gamedemo.databinding.LayoutActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :LayoutActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.layout_activity_main)
    }
}
