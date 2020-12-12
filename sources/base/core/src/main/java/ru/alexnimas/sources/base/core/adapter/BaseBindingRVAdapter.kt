package ru.alexnimas.sources.base.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil

abstract class BaseBindingRVAdapter<Model, VH : BaseBindingRVAdapter.BaseBindingViewHolder<Model>>(
    var items: MutableList<Model> = mutableListOf()
) : LiveDataBindingRecyclerViewAdapter<VH>() {

    private var diffUtilCallback: BaseDiffUtilCallback<Model>? = null

    abstract fun createViewHolderInstance(parent: ViewGroup, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolderInstance(parent, viewType).apply {
            binding.lifecycleOwner = this
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    fun addDiffUtilCallback(diffUtilCallback: BaseDiffUtilCallback<Model>) {
        this.diffUtilCallback = diffUtilCallback
    }

    fun getItem(position: Int): Model {
        return items[position]
    }

    fun inflate(parent: ViewGroup, layoutResId: Int): ViewDataBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )

    open fun updateItems(items: MutableList<Model>) {
        diffUtilCallback?.let {
            val diffResult = DiffUtil.calculateDiff(it.apply {
                setLists(this@BaseBindingRVAdapter.items, items)
            })
            this.items = items
            diffResult.dispatchUpdatesTo(this)
        } ?: run {
            this.items = items
            notifyDataSetChanged()
        }
    }

    open class BaseBindingViewHolder<Model>(val binding: ViewDataBinding) :
        LiveDataBindingViewHolder(binding.root) {
        open fun bind(model: Model, variableId: Int = 0) {}
    }
}
