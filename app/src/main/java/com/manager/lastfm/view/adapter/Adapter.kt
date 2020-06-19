package com.manager.lastfm.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.manager.lastfm.R
import com.manager.lastfm.model.Album

class Adapter(private val list: List<Album>?, private val context: Context) :
    RecyclerView.Adapter<Adapter.RecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.trending_parent, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val album = list!![position]
        holder.bind(album)
        holder.itemView.setOnClickListener {
            val expanded: Boolean = album.isExpanded
            album.isExpanded = !expanded
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView
        private val artistName: TextView
        private val url: TextView
        private val logo: ImageView
        private val subItem: View
        private val seperator: View

        fun bind(album: Album) {
            val expanded: Boolean = album.isExpanded
            subItem.visibility = if (expanded) View.VISIBLE else View.GONE
            seperator.visibility = if (expanded) View.GONE else View.VISIBLE
            name.text = album.name
            artistName.text = album.artist
            url.text = album.url

            Glide.with(context)
                .load(album.image[0].text)
                .apply(RequestOptions.circleCropTransform())
                .into(logo)
        }

        init {
            name = itemView.findViewById(R.id.album_name)
            artistName = itemView.findViewById(R.id.artist_name)
            url = itemView.findViewById(R.id.url)
            logo = itemView.findViewById(R.id.logo)
            subItem = itemView.findViewById(R.id.child)
            seperator = itemView.findViewById(R.id.seperator)
        }
    }

}