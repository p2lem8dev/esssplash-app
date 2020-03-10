package com.p2lem8dev.esssplash.photos.paging

import androidx.paging.PositionalDataSource
import com.p2lem8dev.esssplash.photos.PhotosRepository
import com.p2lem8dev.unsplashapi.models.Photo

class PhotosDataSource(
    private val repository: PhotosRepository
) : PositionalDataSource<Photo>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Photo>) =
        callback.onResult(repository.getCached(0, repository.loadedSize), 0)

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Photo>) =
        callback.onResult(repository.getCached(params.startPosition, params.loadSize))
}