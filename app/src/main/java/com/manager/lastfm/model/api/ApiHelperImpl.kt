package com.manager.lastfm.model.api

import com.manager.lastfm.model.Album
import retrofit2.http.Path

class ApiHelperImpl(private val apiInterface: ApiInterface) : ApiHelper {

    override fun getAlbumsDetails(
        albumSearch: String,
        albumName: String,
        apiKey: String,
        format: String
    ): List<Album> = apiInterface.getAlbumsDetails(albumSearch, albumName, apiKey, format)

}