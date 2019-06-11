package com.example.gamedemo.fragment


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.gamedemo.R
import com.example.gamedemo.databinding.LayoutFragmentScoreBinding
import com.example.gamedemo.model.ScoreViewModel
import com.example.gamedemo.model.ScoreViewModelFactory

class ScoreFragment : Fragment() {
private lateinit var viewModel: ScoreViewModel
    private lateinit var  viewModelFactory: ScoreViewModelFactory
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding :LayoutFragmentScoreBinding = DataBindingUtil.inflate(inflater,R.layout.layout_fragment_score, container, false)
        //View Model Class with the custom constructor with arg of int variable score
        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).scoreArgs)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ScoreViewModel::class.java)
        /*val args = ScoreFragmentArgs.fromBundle(arguments!!)
        val score = args.scoreArgs.toString()*/
        binding.scoreViewModel = viewModel
        return binding.root
    }
}
