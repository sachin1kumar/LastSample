package com.manager.lastfm.model.api

import com.manager.lastfm.model.Album
import com.manager.lastfm.model.Albummatches
import com.manager.lastfm.model.Albums
import com.manager.lastfm.model.Results
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Path

class ApiHelperImpl(private val apiInterface: ApiInterface) : ApiHelper {

    override fun getAlbumsDetails(
        albumSearch: String,
        albumName: String,
        apiKey: String,
        format: String
    ): Call<Albums> = apiInterface.getAlbumsDetails(albumSearch, albumName, apiKey, format)

}