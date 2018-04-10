package com.whatthefar.fungjaihw.feature.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.whatthefar.fungjaihw.R
import com.whatthefar.fungjaihw.feature.DaggerViewModelFactory
import com.whatthefar.fungjaihw.model.Outcome
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this@MainActivity, mainViewModelFactory).get(MainViewModel::class.java)

        initInstances()
        initObservers()
    }

    private fun initInstances() {
        music_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = MusicAdapter()
            addItemDecoration(android.support.v7.widget.DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
        }
    }

    private fun initObservers() {
        mViewModel.musicListObservable.observe(
                this@MainActivity,
                Observer {
                    Timber.i("onChange : MusicListObserver")
                    when (it) {
                        is Outcome.Success -> (music_recycler_view.adapter as MusicAdapter).musicList = it.data
                        is Outcome.Failure -> Timber.e(it.e)
                    }
                }
        )
    }
}
