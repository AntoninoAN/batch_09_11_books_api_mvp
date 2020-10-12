package com.example.booksapitest.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout_error.view.*

class BooksVHError(val view: View):
    RecyclerView.ViewHolder(view){

    fun onBind(errorMessage: String){
        this.view.tv_item_layout_error.text = errorMessage
    }
}
/*
public class BokVHERR{
private View viewGlobal
public BokVHERR(View view){
    this.viewGlobal = view
}
public void doSomething(){
    view
}
}
 */

