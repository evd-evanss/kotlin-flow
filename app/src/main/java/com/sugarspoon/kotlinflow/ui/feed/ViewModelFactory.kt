package com.sugarspoon.kotlinflow.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sugarspoon.kotlinflow.repository.RepositoryFeed


class ViewModelFactory(private val repositoryFeed: RepositoryFeed) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return FeedViewModel(repositoryFeed) as T
  }

}