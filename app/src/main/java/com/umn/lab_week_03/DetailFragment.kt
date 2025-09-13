package com.umn.lab_week_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeId = arguments?.getInt(ListFragment.COFFEE_ID, -1) ?: -1

        val coffeeTitleResId: Int
        val coffeeDescResId: Int

        when (coffeeId) {
            R.id.affogato -> {
                coffeeTitleResId = R.string.affogato_title
                coffeeDescResId = R.string.affogato_desc
            }
            R.id.americano -> {
                coffeeTitleResId = R.string.americano_title
                coffeeDescResId = R.string.americano_desc
            }
            R.id.latte -> {
                coffeeTitleResId = R.string.latte_title
                coffeeDescResId = R.string.latte_desc
            }
            R.id.cappuccino -> {
                coffeeTitleResId = R.string.cappuccino_title
                coffeeDescResId = R.string.cappuccino_desc
            }
            R.id.mocha -> {
                coffeeTitleResId = R.string.mocha_title
                coffeeDescResId = R.string.mocha_desc
            }
            else -> {
                coffeeTitleResId = R.string.app_name // Using app_name as a placeholder for "Unknown Coffee"
                coffeeDescResId = R.string.hello_blank_fragment // Using a placeholder for "Details not available."
            }
        }

        view.findViewById<TextView>(R.id.coffee_title).text = getString(coffeeTitleResId)
        view.findViewById<TextView>(R.id.coffee_desc).text = getString(coffeeDescResId)

        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
