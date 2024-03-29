package com.example.test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.CountriesRvBinding
import com.example.test.model.entities.api.Countries
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class UserAdapter() :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var dataList: List<Countries> = emptyList()
    lateinit var ItemClick: ((Countries) -> Unit)
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: CountriesRvBinding = CountriesRvBinding.bind(view)

        fun render(item: Countries, ItemClick: (Countries) -> Unit) {
            binding.txtV1.text = item.alternateName
            binding.txtV2.text = item.country
            Picasso.get().load("https://countryflagsapi.com/png/" + item.alternateName)
                .into(binding.countryImage);
            itemView.setOnClickListener() {
                ItemClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater.inflate(R.layout.countries_rv, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(dataList[position], ItemClick)
    }

    override fun getItemCount(): Int = dataList.size

}