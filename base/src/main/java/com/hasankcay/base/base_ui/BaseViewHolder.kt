package com.hasankcay.base.base_ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.hasankcay.base.base_entity.BaseDataModel

abstract class BaseViewHolder<M: BaseDataModel> : RecyclerView.ViewHolder {

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int): this(
        LayoutInflater.from(parent.context).inflate(
            layoutId,
            parent,
            false
        )
    )

    constructor(itemView: View): super(itemView)

    abstract fun bindItem(item: M)

    internal fun bindItem(item: M, onItemClick: (M, position: Int, layoutId: Int) -> Unit) {
        with(itemView) {
            setOnClickListener { onItemClick(item, layoutPosition, item.layoutId) }
            bindItem(item)
        }
    }

}