package com.sugarspoon.kotlinflow.ui.feed

import androidx.lifecycle.ViewModel
import com.sugarspoon.kotlinflow.data.FeedResponse
import com.sugarspoon.kotlinflow.repository.RepositoryFeed
import kotlinx.coroutines.flow.*

class FeedViewModel(private val repositoryFeed: RepositoryFeed): ViewModel() {

    lateinit var feed: Flow<FeedResponse>

    init {
        loadFeed()
    }

    private fun loadFeed() {
        feed = repositoryFeed.fetchFeedOnApi()
    }
}