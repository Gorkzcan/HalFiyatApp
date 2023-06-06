package com.gorkem.halfiyatlar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gorkem.halfiyatlar.adapter.HomepageAdapter
import com.gorkem.halfiyatlar.databinding.FragmentHomepageBinding
import com.gorkem.halfiyatlar.ui.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private val viewModel: HomepageViewModel by viewModels()
    private lateinit var adapter: HomepageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = arguments?.getString("city")
        city?.let {
            viewModel.searchProduct(it)
        }

        adapter = HomepageAdapter(emptyList())

        binding.rvBazaar.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomepageFragment.adapter
        }

        viewModel.productList.observe(viewLifecycleOwner, Observer { productList ->
            productList?.let {
                adapter.updateData(productList)
                binding.animationError.visibility = View.GONE
                binding.animationLoading.visibility = View.GONE
            }
            if (productList == null){
                binding.animationError.visibility = View.VISIBLE
                binding.animationLoading.visibility = View.GONE
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearProductList() // Veriyi sıfırlamak için viewModel'deki clearProductList fonksiyonunu çağır
    }
}