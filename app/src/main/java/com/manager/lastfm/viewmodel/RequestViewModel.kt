package com.manager.lastfm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manager.lastfm.model.Album
import com.manager.lastfm.model.Albums
import com.manager.lastfm.model.api.ApiHelperImpl
import com.manager.lastfm.model.api.RetrofitBuilder
import com.manager.lastfm.util.Constants
import com.manager.myapplication.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestViewModel : ViewModel() {

    private val result = MutableLiveData<Resource<List<Album>?>>()

    fun fetchResult(text: String) {
        val apiHelper = ApiHelperImpl(RetrofitBuilder.apiInterface)
        apiHelper.getAlbumsDetails(
            Constants.ALBUM_SEARCH,
            text,
            Constants.API_KEY,
            Constants.FORMAT
        )
            .enqueue(object : Callback<Albums> {
                override fun onFailure(call: Call<Albums>, t: Throwable) {
                    result.postValue(Resource.error("Something went wrong!",null))
                }

                override fun onResponse(call: Call<Albums>, response: Response<Albums>) {
                    result.postValue(Resource.success(response.body()?.results?.albummatches?.album?.toList()))
                }
            })
    }

    fun getResult(): LiveData<Resource<List<Album>?>> {
        return result
    }
}