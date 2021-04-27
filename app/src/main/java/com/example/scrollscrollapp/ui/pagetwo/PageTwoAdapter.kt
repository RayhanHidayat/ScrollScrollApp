package com.example.scrollscrollapp.ui.pagetwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scrollscrollapp.data.Produk
import com.example.scrollscrollapp.databinding.ItemProdukBinding

class PageTwoAdapter(private val list: MutableList<Produk>) :
    RecyclerView.Adapter<PageTwoAdapter.ViewHolder>() {
    lateinit var listener: PageTwoRecyclerViewClickListener

    inner class ViewHolder(private val binding: ItemProdukBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(produk: Produk) {
            with(binding) {
                civProduk.load(produk.image)
                mtvTitle.text = produk.title
                mtvDesc.text = produk.miniDesc
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProdukBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            listener.onItemClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}