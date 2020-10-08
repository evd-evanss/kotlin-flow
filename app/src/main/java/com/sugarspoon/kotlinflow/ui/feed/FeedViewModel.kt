package com.sugarspoon.kotlinflow.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sugarspoon.kotlinflow.data.FeedState
import com.sugarspoon.kotlinflow.repository.RepositoryFeed
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*

class FeedViewModel(private val repositoryFeed: RepositoryFeed): ViewModel() {

    lateinit var feed: Flow<FeedState>

    init {
        loadFeed()
    }

    private fun loadFeed() {
        feed = repositoryFeed.fetchFeedOnApi()
        val livedata = repositoryFeed.fetchFeedOnApi().asLiveData(Main)
//        repositoryFeed.fetchLikesAsFlow()
//        repositoryFeed.fetchLikesWithFlowOf()
//        _state = feed.asLiveData(Dispatchers.Main)
    }
}