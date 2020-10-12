package com.example.booksapitest.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.booksapitest.R
import com.example.booksapitest.model.BooksResponse
import com.example.booksapitest.presenter.SearchFragmentPresenter
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment: Fragment(), ISearchFragment {

    companion object{
        fun searchFragmentFactory() =
            SearchFragment()
    }

    lateinit var listener: HostActivityListener
    lateinit var searchPresenter: SearchFragmentPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is HostActivityListener)
            listener = context
        searchPresenter = SearchFragmentPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_search,
        container, false)

        createSpinnerAdapter(view)

        view.btn_search.setOnClickListener {
            val queryInput =
                view.til_fragment_search.editText?.text.toString()
            val spinnerInput =
                view.sp_filter_fragment_search.selectedItem.toString()
            val rbInput =
                view.findViewById<RadioButton>(
                view.rg_fragment_search.checkedRadioButtonId).text.toString()
            searchInputs(queryInput, rbInput, spinnerInput)
        }
        return view
    }

    override fun displayData(dataSet: BooksResponse) {
        listener.displayData(dataSet)
    }

    override fun displayErrorMessage(errorMessage: String) {
        listener.displayErrorMessage(errorMessage)
    }

    override fun searchInputs(input: String, type: String, filter: String) {
        searchPresenter.searchQueryParams(input, type, filter)
    }

    private fun createSpinnerAdapter(view: View){
        activity?.let {
            val adapter = ArrayAdapter<String>(
                activity as Context,
                android.R.layout.simple_list_item_1,
                it.resources.getStringArray(R.array.filter_options)
            )
            view.sp_filter_fragment_search.adapter =
                adapter
        }
    }
}