package com.stockbit.hiring.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.AdapterCryptoBinding
import com.stockbit.model.DataCrypto

class CryptoAdapter : PagedListAdapter<DataCrypto, CryptoAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            tvName.text = getItem(position)?.CoinInfo?.Name
            tvFullName.text = getItem(position)?.CoinInfo?.FullName
            tvPrice.text = getItem(position)?.DISPLAY?.IDR?.PRICE

            tvChangePrice.text = getItem(position)?.DISPLAY?.IDR?.CHANGE24HOUR + "(${getItem(position)?.DISPLAY?.IDR?.CHANGEPCT24HOUR})"
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataCrypto>() {
            override fun areItemsTheSame(oldItem: DataCrypto, newItem: DataCrypto): Boolean {
                return oldItem.CoinInfo.Id == newItem.CoinInfo.Id
            }

            override fun areContentsTheSame(oldItem: DataCrypto, newItem: DataCrypto): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ViewHolder(val view: AdapterCryptoBinding) : RecyclerView.ViewHolder(view.root)
}