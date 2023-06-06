package com.gorkem.halfiyatlar.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gorkem.halfiyatlar.data.model.Bazaar
import com.gorkem.halfiyatlar.databinding.ItemHomepageBinding

class HomepageAdapter (private var bazaarList: List<Bazaar>): RecyclerView.Adapter<HomepageAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemHomepageBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomepageBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = bazaarList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bazaar = bazaarList[position]

        holder.binding.halName.text = bazaar.hal
        holder.binding.maxPrice.text = "En yüksek fiyat: ${bazaar.max}"
        holder.binding.minPrice.text = "En düşük fiyat: ${bazaar.min}"
        holder.binding.productUnit.text = "Ürün birimi: ${bazaar.birim}"
        holder.binding.productName.text = "Ürün Adı: ${bazaar.isim}"
    }


    fun updateData(newList: List<Bazaar>){
        bazaarList = newList
        notifyDataSetChanged()
    }


}