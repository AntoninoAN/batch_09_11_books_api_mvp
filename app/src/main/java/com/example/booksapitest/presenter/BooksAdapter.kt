package com.example.booksapitest.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapitest.R
import com.example.booksapitest.model.BooksResponse
import com.example.booksapitest.view.BooksVHError
import com.example.booksapitest.view.BooksVHSuccess

sealed class BooksDataTypes{
    class DataSuccess(val dataSet: BooksResponse) : BooksDataTypes()
    class DataError(val errorMessage: String): BooksDataTypes()
}


class BooksAdapter(val booksDataTypes: BooksDataTypes)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class BooksViewHolderTypes{
        SUCCESS, ERROR
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return when(booksDataTypes){
            is BooksDataTypes.DataSuccess-> BooksViewHolderTypes.SUCCESS.ordinal
            else -> BooksViewHolderTypes.ERROR.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            BooksViewHolderTypes.SUCCESS.ordinal->
                BooksVHSuccess(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout_success,
                    parent,
                    false))
            else->
                BooksVHError(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout_error,
                    parent,
                    false))
        }
    }

    override fun getItemCount(): Int {
        return when(booksDataTypes){
            is BooksDataTypes.DataSuccess->
                booksDataTypes.dataSet.items.size
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        when(holder){
            is BooksVHSuccess->
                holder.onBind((booksDataTypes as BooksDataTypes.DataSuccess)
                    .dataSet.items[position])
            is BooksVHError->
                holder.onBind((booksDataTypes as BooksDataTypes.DataError)
                    .errorMessage)
        }
    }
}

//
//class A{
//    val something = "jjfjdkdkdkd"
//    inner class B{
//        fun doSomething(){
//            println(something)
//        }
//    }
//}
//
//
//class An{
//    val something ="dkdkdkdkd"
//
//    class Bn{
//        fun doSomething(){
//            An().something
//        }
//    }
//}
//
//class C{
//    fun boo(){
//        val an = An()
//        val bn = An.Bn()
//        an.something
//        val a = A()
//        val b = A.B()
//        a.B().doSomething()
//    }
//}





