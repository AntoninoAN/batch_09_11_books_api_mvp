package com.example.booksapitest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booksapitest.R
import com.example.booksapitest.model.BooksResponse

class MainActivity : AppCompatActivity(), HostActivityListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inflateTopFragment()
    }

    private fun inflateTopFragment(){

    }

    private fun inflateBottomFragment(dataSet: BooksResponse){

    }

    override fun displayData(dataSet: BooksResponse) {
        inflateBottomFragment(dataSet)
    }

    override fun displayErrorMessage(errorMessage: String) {
        TODO("Not yet implemented")
    }
}