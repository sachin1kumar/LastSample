package com.manager.lastfm.model.api

import com.manager.lastfm.model.Album

interface ApiHelper {

    fun getAlbumsDetails(albumSearch: String,
                         albumName: String,
                         apiKey: String,
                         format: String): List<Album>
}