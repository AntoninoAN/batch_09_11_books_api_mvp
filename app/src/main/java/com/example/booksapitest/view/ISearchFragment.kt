package com.example.booksapitest.view

import com.example.booksapitest.model.BooksResponse

interface ISearchFragment {
    fun displayData(dataSet: BooksResponse)
    fun searchInputs(input: String,
        type: String,
        filter: String)
    fun displayErrorMessage(errorMessage: String)
}