package ru.alexnimas.sources.base.core.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.alexnimas.sources.base.core.adapter.BaseBindingRVAdapter

@BindingAdapter("srcUrl")
fun ImageView.bindImage(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("android:items")
fun <T> RecyclerView.bindItems(items: MutableList<T>?) {
    items?.let {
        @Suppress("UNCHECKED_CAST")
        try {
            if (adapter != null && adapter is BaseBindingRVAdapter<*, *>) {
                (adapter as BaseBindingRVAdapter<T, *>).updateItems(items)
            }
        } catch (t: Throwable) {
            throw IllegalStateException("Incoming adapter is an incompatible type")
        }
    }
}

@BindingAdapter("android:visibility")
fun View.bindVisibility(visible: Boolean?) {
    visibility = if (visible != null && visible) View.VISIBLE else View.GONE
}