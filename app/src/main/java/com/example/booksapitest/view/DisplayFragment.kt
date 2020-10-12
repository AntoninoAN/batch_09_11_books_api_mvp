package com.example.booksapitest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapitest.R
import com.example.booksapitest.presenter.BooksAdapter
import com.example.booksapitest.presenter.BooksDataTypes
import kotlinx.android.synthetic.main.fragment_display.view.*

class DisplayFragment : Fragment(){
    val something = "dddd"
    companion object{
        val KEY_EXTRA_SUCCESS = "KEY_EXTRA_SUCCESS"
        val KEY_EXTRA_ERROR = "KEY_EXTRA_ERROR"

        fun newInstance(booksDataTypes: BooksDataTypes):
            DisplayFragment{
            val fragment = DisplayFragment()
            val bundle = Bundle()
            when(booksDataTypes){
                is BooksDataTypes.DataSuccess->
                    bundle.putParcelable(KEY_EXTRA_SUCCESS,
                        booksDataTypes.dataSet)
                is BooksDataTypes.DataError->
                    bundle.putString(KEY_EXTRA_ERROR,
                    booksDataTypes.errorMessage)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_display,
            container,
            false
        )
        var booksDataTypes: BooksDataTypes? = null
        arguments?.let {bundle->
            bundle.get(KEY_EXTRA_SUCCESS)?.let { dataSuccess ->
                booksDataTypes = dataSuccess as BooksDataTypes.DataSuccess
            }
            bundle.get(KEY_EXTRA_ERROR)?.let { dataError ->
                booksDataTypes = dataError as BooksDataTypes.DataError
            }

            view.recyclerview.layoutManager =
                LinearLayoutManager(activity)
            view.recyclerview.adapter = BooksAdapter(booksDataTypes!!)
        }
        return view
    }
}