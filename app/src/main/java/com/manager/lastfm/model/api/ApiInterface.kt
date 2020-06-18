package com.manager.lastfm.model.api

import com.manager.lastfm.model.Album
import com.manager.lastfm.model.Albummatches
import com.manager.lastfm.model.Albums
import com.manager.lastfm.model.Results
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    //@GET("/2.0/?method={albumSearch}&album={albumName}&api_key={apiKey}&format={forMat}")
    @GET("/2.0/")
    fun getAlbumsDetails(
        @Query("method") albumSearch: String,
        @Query("album") albumName: String,
        @Query("api_key") apiKey: String,
        @Query("format") forMat: String
    ): Call<Albums>
}