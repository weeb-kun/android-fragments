package com.weebkun.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.RuntimeException
import kotlinx.android.synthetic.main.fragment_demo_b.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [DemoB.newInstance] factory method to
 * create an instance of this fragment.
 */
class DemoB : Fragment() {

    private lateinit var listener: ButtonListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_demo_b, container, false)
        v.findViewById<Button>(R.id.submit).setOnClickListener {
            listener.onButtonClick(number.text.toString().toInt())
        }
        // Inflate the layout for this fragment
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ButtonListener) listener = context
        else throw RuntimeException("$context must implement ButtonListener.")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DemoB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = DemoB()
    }
}