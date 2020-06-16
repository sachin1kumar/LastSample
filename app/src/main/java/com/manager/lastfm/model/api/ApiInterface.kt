package com.manager.lastfm.model.api

import com.manager.lastfm.model.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("method={album_search}&album={album_name}&api_key={api_key}&format={format}")
    fun getAlbumsDetails(
        @Path("album_search") albumSearch: String,
        @Path("album_name") albumName: String,
        @Path("api_key") apiKey: String,
        @Path("format") format: String
    ): List<Album>
}