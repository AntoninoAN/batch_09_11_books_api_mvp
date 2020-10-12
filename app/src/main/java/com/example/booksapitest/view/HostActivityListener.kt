package com.example.booksapitest.view

import com.example.booksapitest.model.BooksResponse

interface HostActivityListener {
    fun displayData(dataSet: BooksResponse)
    fun displayErrorMessage(errorMessage: String)
}
