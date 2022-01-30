package com.mrflaitx.taskapp35.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrflaitx.taskapp35.R
import com.mrflaitx.taskapp35.domain.ShopItem

class ShopListAdapter :
    RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var onItemClick: ((ShopItem) -> Unit)? = null

    var list = listOf<ShopItem>()
        set(value) {
            field = value
        }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0

    }

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        var layout: Int

        if (viewType == VIEW_TYPE_ENABLED) {
            layout = R.layout.item_shop_enabled
        } else {
            layout = R.layout.item_shop_disabled
        }
        return ShopItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(list[position])


    }

    override fun getItemCount(): Int = list.size

    inner class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        val tvCount = itemView.findViewById<TextView>(R.id.tv_count)

        fun onBind(shopItem: ShopItem) {
            tvName.text = shopItem.name
            tvCount.text = shopItem.id.toString()
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[absoluteAdapterPosition])
            }
        }


    }
}