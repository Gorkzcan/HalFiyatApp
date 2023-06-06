package com.gorkem.halfiyatlar.data.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.gorkem.halfiyatlar.data.model.Bazaar
import com.gorkem.halfiyatlar.data.model.BazaarResult
import com.gorkem.halfiyatlar.service.HeadersInfo
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.coroutines.coroutineContext

class BazaarRepo(private var bRepo:HeadersInfo) {
    var bazaarList = MutableLiveData<List<Bazaar>?>()


    fun getPrice(textedCity:String){
        bRepo.getPrice(textedCity).enqueue(object : retrofit2.Callback<BazaarResult>{
            override fun onResponse(call: Call<BazaarResult>, response: Response<BazaarResult>) {
                val bazaarResultList = response.body()?.result
                if (bazaarResultList == null){
                    bazaarList.value = null
                }else{
                    bazaarList.value = bazaarResultList
                }
            }

            override fun onFailure(call: Call<BazaarResult>, t: Throwable) {
                bazaarList.value = null

            }

        })
    }

}