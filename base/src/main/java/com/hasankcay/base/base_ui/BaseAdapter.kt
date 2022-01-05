package com.hasankcay.base.base_ui

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hasankcay.base.base_entity.BaseDataModel

abstract class BaseAdapter<data : BaseDataModel> : ListAdapter<data, BaseViewHolder<data>>(
    ItemDiffCallback<data>()
) {

    private var onItemClick: ((data, position: Int, layoutId: Int) -> Unit) = { _, _, _ -> }

    // Leaking 'this' in constructor of non-final class BaseAdapter
    private val asyncListDiffer = AsyncListDiffer<data>(this, ItemDiffCallback())

    var items: List<data>
        get() = asyncListDiffer.currentList
        set(value) = asyncListDiffer.submitList(value)

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<data>

    override fun onBindViewHolder(holder: BaseViewHolder<data>, position: Int) {
        holder.bindItem(items[position], onItemClick)
    }

    override fun getItemViewType(position: Int) = getItem(position).layoutId

    fun setOnItemClick(onClick: ((data, position: Int, layoutId: Int) -> Unit)) {
        this.onItemClick = onClick
    }

    class ItemDiffCallback<T : BaseDataModel> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }

}