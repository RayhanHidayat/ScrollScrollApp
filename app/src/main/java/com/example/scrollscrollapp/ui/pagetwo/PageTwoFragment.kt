package com.example.scrollscrollapp.ui.pagetwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scrollscrollapp.data.Produk
import com.example.scrollscrollapp.databinding.FragmentPageTwoBinding
import com.example.scrollscrollapp.ui.detail.SecondActivity
import com.example.scrollscrollapp.ui.pageone.PageOneAdapter
import com.example.scrollscrollapp.ui.pageone.PageOneRecyclerViewClickListener
import com.example.scrollscrollapp.utils.DummyDataProduk
import splitties.fragments.start


class PageTwoFragment : Fragment(), PageOneRecyclerViewClickListener {

    private lateinit var binding: FragmentPageTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageTwoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            with(binding) {
                val produkAdapter = PageOneAdapter(DummyDataProduk.getAllUpsideDown())
                rvProduk.setHasFixedSize(true)
                rvProduk.layoutManager = LinearLayoutManager(context)
                rvProduk.adapter = produkAdapter

                produkAdapter.listener = this@PageTwoFragment
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