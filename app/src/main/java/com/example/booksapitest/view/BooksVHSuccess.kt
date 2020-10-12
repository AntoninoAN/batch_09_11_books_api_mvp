package com.example.booksapitest.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksapitest.model.BookItem
import kotlinx.android.synthetic.main.item_layout_success.view.*

class BooksVHSuccess(val view: View)
    : RecyclerView.ViewHolder(view) {

    fun onBind(dataItem: BookItem){
        view.tv_layout_success.text =
            dataItem.volumeInfo.title
        Glide.with(view.context)
            .load(dataItem.volumeInfo.imageLinks.thumbnail)
            .into(view.iv_layout_success)
    }
}