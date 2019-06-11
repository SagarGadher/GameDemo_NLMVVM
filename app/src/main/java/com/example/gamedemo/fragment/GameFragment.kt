package com.example.gamedemo.fragment


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gamedemo.R
import com.example.gamedemo.databinding.LayoutFragmentGameBinding
import com.example.gamedemo.model.GameViewModel

class GameFragment : Fragment() {
    lateinit var viewModel: GameViewModel
    lateinit var binding: LayoutFragmentGameBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_game, container, false)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.lifecycleOwner = this
        /*viewModel.score.observe(this, Observer {
            binding.tvScore.text = "Current Score is $it"
        })
        viewModel.word.observe(this, Observer {
            binding.tvQuestion.text = it
        })
        viewModel.count.observe(this, Observer {
             binding.tvTimer.text = DateUtils.formatElapsedTime(it!!)
        })*/
        viewModel.eventGameFinish.observe(this, Observer {
            if (it ?: false) {
                gameFinish()
                viewModel.onGameFinishComplete()
            }
        })
        binding.gameViewModel = viewModel
        return binding.root
    }

    fun gameFinish() {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToScoreFragment(
                viewModel.score.value ?: 0
            )
        )
    }
}