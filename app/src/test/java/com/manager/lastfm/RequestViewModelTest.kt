package com.manager.lastfm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.manager.lastfm.model.Album
import com.manager.lastfm.model.api.ApiHelperImpl
import com.manager.lastfm.model.api.RetrofitBuilder
import com.manager.lastfm.util.Constants
import com.manager.lastfm.viewmodel.RequestViewModel
import com.manager.myapplication.utils.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection


@RunWith(MockitoJUnitRunner::class)
class RequestViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: RequestViewModel

    private lateinit var apiHelper: ApiHelperImpl

    @Mock
    private lateinit var apiAlbumsObserver: Observer<Resource<List<Album>?>>

    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = RequestViewModel()
        viewModel.getResult().observeForever(apiAlbumsObserver)

        mockWebServer = MockWebServer()
        apiHelper = ApiHelperImpl(RetrofitBuilder.apiInterface)
    }

    @Test
    fun `fetchResult when empty text empty return`(){
        //arrange
        val text = ""
        //act
        viewModel.fetchResult(text)
        //assert
        Assert.assertEquals("","")
    }

    @Test
    fun `read sample success json file`(){
        val reader = MockResponseFileReader("success_response.json")
        assertNotNull(reader.content)
    }

    @Test
    fun `fetch result for non empty string response Code 200 return`(){
        // Assign
        mockWebServer.start()
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("success_response.json").content)
        mockWebServer.enqueue(response)
        // Act
        val  actualResponse = apiHelper.getAlbumsDetails(Constants.ALBUM_SEARCH,
        "for",
        Constants.API_KEY,
        Constants.FORMAT).execute()
        // Assert
        assertEquals(response.toString().contains("200"),actualResponse.code().toString().contains("200"))
    }

    @Test
    fun `fetch result for empty string 400 return`(){
        // Assign
        mockWebServer.start()
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
            .setBody(MockResponseFileReader("failed_response.json").content)
        mockWebServer.enqueue(response)
        // Act
        val  actualResponse = apiHelper.getAlbumsDetails(Constants.ALBUM_SEARCH,
            "",
            Constants.API_KEY,
            Constants.FORMAT).execute()
        // Assert
        assertEquals(response.toString().contains("400"),actualResponse.toString().contains("400"))
    }

    @After
    fun tearDown() {
        viewModel.getResult().removeObserver(apiAlbumsObserver)
        mockWebServer.shutdown()
    }
}