package com.example.simple_notepads.examples.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simple_notepads.R


class CalculatorFragment : Fragment() {

    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        val numberView = view?.findViewById<TextView>(R.id.textScreen)
        //val actualValue = numberView?.text.toString()
        val button1 = view?.findViewById<Button>(R.id.button2)
        /*val button2 = view?.findViewById<Button>(R.id.button3)
        val button3 = view?.findViewById<Button>(R.id.button4)
        val button4 = view?.findViewById<Button>(R.id.button5)
        val button5 = view?.findViewById<Button>(R.id.button6)
        val button6 = view?.findViewById<Button>(R.id.button7)
        val button7 = view?.findViewById<Button>(R.id.button8)
        val button8 = view?.findViewById<Button>(R.id.button9)
        val button9 = view?.findViewById<Button>(R.id.button10)
        val button0 = view?.findViewById<Button>(R.id.button14)
        val buttonPlus = view?.findViewById<Button>(R.id.button11)
        val buttonMinus = view?.findViewById<Button>(R.id.button12)
        val buttonMulti = view?.findViewById<Button>(R.id.button13)
        val buttonDiv = view?.findViewById<Button>(R.id.button15)
        val buttonEquals = view?.findViewById<Button>(R.id.button16)*/

        button1?.setOnClickListener {
            numberView?.text = "1"
        }
    }

}