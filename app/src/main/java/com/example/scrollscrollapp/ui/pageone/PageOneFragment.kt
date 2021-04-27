package com.example.scrollscrollapp.ui.pageone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scrollscrollapp.data.Produk
import com.example.scrollscrollapp.databinding.FragmentPageOneBinding
import com.example.scrollscrollapp.ui.detail.SecondActivity
import com.example.scrollscrollapp.utils.DummyDataProduk
import splitties.fragments.start

class PageOneFragment : Fragment(), PageOneRecyclerViewClickListener {

    private lateinit var binding: FragmentPageOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            with(binding) {
                val produkAdapter = PageOneAdapter(DummyDataProduk.getAll())
                rvProduk.setHasFixedSize(true)
                rvProduk.layoutManager = LinearLayoutManager(context)
                rvProduk.adapter = produkAdapter

                produkAdapter.listener = this@PageOneFragment
            }
        }
    }

    private fun showSelectedProduk(produk: Produk){
        start<SecondActivity> {
            putExtra(SecondActivity.EXTRA_PRODUK, produk)
        }
    }

    override fun onItemClicked(produk: Produk) {
        showSelectedProduk(produk)
    }
}