package com.manager.lastfm.view

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.manager.lastfm.R
import com.manager.lastfm.model.Album
import com.manager.lastfm.view.adapter.Adapter
import com.manager.lastfm.viewmodel.RequestViewModel
import com.manager.myapplication.utils.Status
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    @BindView(R.id.input_search)
    lateinit var inputSearch: SearchView

    @BindView(R.id.recycler_view)
    lateinit var recyclerView: RecyclerView

    private lateinit var adapter: Adapter
    private val albumList = ArrayList<Album>()
    private lateinit var unbinder: Unbinder
    private lateinit var requestViewModel: RequestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this);

        initViewModel()
        initViews()
        initSearchObservable()
    }

    private fun initViews() {
        adapter = Adapter(albumList, this)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        requestViewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
    }

    private fun initSearchObservable() {
        Observable.create<String> {
            inputSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    it.onNext(newText!!)
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    it.onNext(query!!)
                    return false
                }
            })
        }.map { text -> text }
            .debounce(250, TimeUnit.MILLISECONDS)
            .distinct()
            .filter { text -> text.isNotBlank() }
            .subscribe { text ->
                runOnUiThread { initApiCall(text) }
            }
    }

    private fun initApiCall(text: String) {
        requestViewModel.getResult().observe(this, androidx.lifecycle.Observer {
            when(it.status){
                Status.SUCCESS -> {
                    albumList.clear()
                    it?.let { it1 -> it1.data?.let { it2 -> albumList.addAll(it2) } }
                    adapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //do nothing for now.
                }
            }

        })
        //fetch results
        requestViewModel.fetchResult(text)
    }

    override fun onDestroy() {
        unbinder.unbind()
        super.onDestroy()
    }
}