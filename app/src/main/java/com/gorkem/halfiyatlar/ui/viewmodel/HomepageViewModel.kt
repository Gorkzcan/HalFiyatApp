package com.gorkem.halfiyatlar.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gorkem.halfiyatlar.data.model.Bazaar
import com.gorkem.halfiyatlar.data.repository.BazaarRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(private var bRepo:BazaarRepo): ViewModel() {
    private val _productList = MutableLiveData<List<Bazaar>?>()
    val productList: LiveData<List<Bazaar>?> = _productList

    fun searchProduct(city: String) {
        bRepo.getPrice(city)
    }

    init {
        bRepo.bazaarList.observeForever { bazaarList ->
            _productList.value = bazaarList
        }
    }

    override fun onCleared() {
        super.onCleared()
        bRepo.bazaarList.removeObserver { }
    }


    fun clearProductList(){
        _productList.value = null
    }
}