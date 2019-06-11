package com.example.gamedemo.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.os.CountDownTimer
import android.text.format.DateUtils

class GameViewModel : ViewModel() {

    companion object {
        const val DONE = 0L
        const val ONE_SECOND = 1000L
        const val COUNTDOWN_TIME = 10000L
    }

    private val timer: CountDownTimer

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _count = MutableLiveData<Long>()
    val count: LiveData<Long>
        get() = _count

    val countString: LiveData<String> = Transformations.map(count) {
        DateUtils.formatElapsedTime(it)
    }
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    lateinit var wordList: MutableList<String>

    init {
        _eventGameFinish.value = false
        _score.value = 0
        _word.value = ""
        _count.value = DONE
        resetList()
        nextWord()

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onFinish() {
                _count.value = DONE
                _eventGameFinish.value = true
            }

            override fun onTick(p0: Long) {
                _count.value = p0 / 1000
            }
        }
        timer.start()
    }

    fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)
    }

    fun onSkip() {
        _score.value = score.value!!.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = score.value!!.plus(1)
        nextWord()
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

}