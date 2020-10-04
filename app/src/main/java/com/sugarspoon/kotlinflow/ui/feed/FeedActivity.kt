package com.sugarspoon.kotlinflow.ui.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sugarspoon.kotlinflow.R
import com.sugarspoon.kotlinflow.data.FeedResponse
import com.sugarspoon.kotlinflow.repository.RepositoryFeed
import com.sugarspoon.kotlinflow.ui.share.ShareActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FeedActivity : AppCompatActivity() {

    private val viewModel: FeedViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(RepositoryFeed())
        ).get(FeedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
        setupView()
    }

    private fun setupListener() {
        shareIv.setOnClickListener {
            startActivity(Intent(this, ShareActivity::class.java))
        }
    }

    private fun setupView() {
        viewModel.run {
            viewModelScope.launch {
                feed.collect { feed ->
                    likesTv.text = "${feed.likes}"
                    commentsTv.text = "${feed.comments}"
                    shareTv.text = "${feed.shares}"
                    logFeed(feed)
                }
            }
        }
    }

    private fun logFeed(feed: FeedResponse) {
        Log.d(TAG, "\nlikes:${feed.likes} comments:${feed.comments} shares:${feed.shares}")
    }

    companion object {
        private const val TAG = "MAIN_TAG"
    }

}