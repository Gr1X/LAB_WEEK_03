package com.umn.lab_week_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {
    private var coffeeTitle: TextView? = null
    private var coffeeDesc: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coffeeTitle = view.findViewById(R.id.coffee_title)
        coffeeDesc = view.findViewById(R.id.coffee_desc)

        val title = arguments?.getString(COFFEE_TITLE)
        val description = arguments?.getString(COFFEE_DESC)

        coffeeTitle?.text = title
        coffeeDesc?.text = description
    }

    companion object {
        private const val COFFEE_TITLE = "COFFEE_TITLE"
        private const val COFFEE_DESC = "COFFEE_DESC"
        fun newInstance(coffeeTitle: String, coffeeDesc: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(COFFEE_TITLE, coffeeTitle)
                    putString(COFFEE_DESC, coffeeDesc)
                }
            }
    }
}