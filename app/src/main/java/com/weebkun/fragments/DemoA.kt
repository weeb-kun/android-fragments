package com.weebkun.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [DemoA.newInstance] factory method to
 * create an instance of this fragment.
 */
class DemoA : Fragment() {

    private lateinit var sumDisplay:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_demo_a, container, false)
        sumDisplay = v.findViewById(R.id.sum)
        sumDisplay.visibility = View.INVISIBLE
        sumDisplay.text = "current sum is ${(activity as MainActivity).sum}"
        // Inflate the layout for this fragment
        return v
    }

    /**
     * toggles whether the sum is visible or not.
     */
    fun toggleSumVisibility() {
        if(sumDisplay.visibility == View.VISIBLE) sumDisplay.visibility = View.INVISIBLE
        else sumDisplay.visibility = View.VISIBLE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DemoA.
         */
        @JvmStatic
        fun newInstance() = DemoA()
    }
}