package com.example.booksapitest.presenter

import com.example.booksapitest.model.BooksApi
import com.example.booksapitest.model.BooksResponse
import com.example.booksapitest.view.ISearchFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragmentPresenter {
    private var view: ISearchFragment? = null

    fun onBind(view: ISearchFragment){
        this.view = view
    }

    /**
     * This will be called from
     * the onStop of the View
     */
    fun unBind(){
        view = null
    }

    fun searchQueryParams(input: String,
    type: String,
    filter: String){
        BooksApi.initRetrofit()
            .getThemBooks(input,
            filter,
            type)
            .enqueue(object: Callback<BooksResponse>{
                override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                    view?.displayErrorMessage(t.message ?: "Something Failed")
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<BooksResponse>,
                    response: Response<BooksResponse>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            view?.displayData(it)
                        }
                    }
                }
            })
    }
}

