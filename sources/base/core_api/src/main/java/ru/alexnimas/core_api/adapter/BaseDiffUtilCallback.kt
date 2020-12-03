package ru.alexnimas.core_api.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtilCallback<Model> : DiffUtil.Callback() {

    protected var oldList: List<Model> = mutableListOf()
    protected var newList: List<Model> = mutableListOf()

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    fun setLists(oldList: List<Model>, newList: List<Model>) {
        this.oldList = oldList
        this.newList = newList
    }
}
