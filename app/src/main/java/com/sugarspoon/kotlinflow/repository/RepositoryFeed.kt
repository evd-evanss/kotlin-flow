package com.sugarspoon.kotlinflow.repository

import com.sugarspoon.kotlinflow.data.FeedResponse
import com.sugarspoon.kotlinflow.data.FeedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class RepositoryFeed {

    fun fetchFeedOnApi(): Flow<FeedState> = flow {
        for (count in 1..1000000000) {
            val feedResponse = fetchFeedOnApi(likes = count, comments = count*2, shares = count+3)
            delay(1000) // tempo de resposta
            emit(feedResponse)
        }
    }.flowOn(IO).map {
        FeedState(
            it.likes.toString(),
            it.comments.toString(),
            it.shares.toString()
        )
    }.take(10)

    private fun fetchFeedOnApi(likes: Int, comments: Int, shares: Int): FeedResponse {
        return FeedResponse(likes = likes, comments = comments, shares = shares)
    }

    fun fetchLikesWithFlowOf(): Flow<Int> =
        flowOf(1,2,3,4,5,6,7,8,9,10).flowOn(Dispatchers.IO)

    fun fetchLikesAsFlow(): Flow<Int> =
        listOf(1,2,3,4).asFlow().flowOn(Dispatchers.IO)


}