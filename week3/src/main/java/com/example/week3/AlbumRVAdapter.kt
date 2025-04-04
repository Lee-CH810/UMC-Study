package com.example.week3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week3.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val albumList: ArrayList<Album>) : RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>() {
    // 뷰 홀더를 생성해줘야 할 때 호출되는 함수.
    // 아이템에 대한 뷰 객체를 만들어서 뷰 홀더에 넣고 그것을 리턴
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // 뷰 홀더에 데이터를 바인딩해줘야 할 때 사용하는 함수
    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, position: Int) {
        holder.bind(albumList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(albumList[position])
        }
        holder.binding.itemAlbumPlayImgIv.setOnClickListener {
            itemClickListener.onPlayAlbum(albumList[position])
        }
    }

    // 데이터 셋 크기를 알려주는 함수
    // 리사이클러뷰가 아이템의 마지막이 언제인지 알게 하기 위해 필요함.
    override fun getItemCount(): Int = albumList.size

    // 뷰 홀더
    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        // item_album.xml에서 구조화한 앨범의 멤버들을 셋팅
        fun bind(album: Album) {
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImage!!)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(album: Album)
        fun onPlayAlbum(album: Album)
    }

    private lateinit var itemClickListener: OnItemClickListener

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}