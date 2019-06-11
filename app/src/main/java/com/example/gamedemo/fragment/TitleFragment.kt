package com.example.gamedemo.fragment


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.gamedemo.R
import com.example.gamedemo.databinding.LayoutFragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding:LayoutFragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.layout_fragment_title, container, false)
        binding.btnPlay.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        return binding.root
    }
}
