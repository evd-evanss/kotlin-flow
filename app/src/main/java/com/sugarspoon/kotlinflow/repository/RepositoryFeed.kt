package com.sugarspoon.kotlinflow.repository

import com.sugarspoon.kotlinflow.data.FeedResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class RepositoryFeed {

//    private val likes = listOf(FeedResponse(1), FeedResponse(2), FeedResponse(3),FeedResponse(4),)
//
//    fun fetchLikesWithFlowOf(): Flow<FeedResponse> =
//        flowOf(FeedResponse((1)), FeedResponse(22), FeedResponse(35)).flowOn(Dispatchers.IO)

//    fun fetchLikesAsFlow(): Flow<FeedResponse> =
//        likes.asFlow().flowOn(Dispatchers.IO)

    fun fetchFeedOnApi(): Flow<FeedResponse> = flow {
        for (count in 1..1000000000) {
            delay(300) // tempo de resposta
            emit(FeedResponse(likes = count, comments = count*2, shares = count+3))
        }
    }.flowOn(Dispatchers.IO)

}