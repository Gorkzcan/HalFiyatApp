package com.gorkem.halfiyatlar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.gorkem.halfiyatlar.R
import com.gorkem.halfiyatlar.databinding.FragmentHomepageBinding
import com.gorkem.halfiyatlar.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    lateinit var binding : FragmentSearchBinding
    private val navController by lazy{findNavController()}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        val searchButton = binding.searchButton
        val cityEditText = binding.editSearch

        searchButton.setOnClickListener {
            val city = cityEditText.text.toString()
            val action = SearchFragmentDirections.actionSearchFragmentToHomepageFragment(city)
            navController.navigate(action)
        }
        return binding.root
    }
}