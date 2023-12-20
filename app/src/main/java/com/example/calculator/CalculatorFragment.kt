package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.calculator.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    var digitsCounter = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAC.setOnClickListener {
            binding.textviewInput.text = ""
            binding.textviewoutput.text = "0"
            digitsCounter = 0
        }
        binding.btn0.setOnClickListener {
            if (digitsCounter < 15) {
                binding.textviewInput.append("0")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn1.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("1")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btnDot.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append(".")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn2.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("2")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn3.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("3")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn4.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("4")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn5.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("5")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn6.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("6")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn7.setOnClickListener {
            if (digitsCounter < 15) {
                binding.textviewInput.append("7")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn8.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("8")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btn9.setOnClickListener {

            if (digitsCounter < 15) {
                binding.textviewInput.append("9")
                digitsCounter++
            } else {
                Toast.makeText(requireContext(), "exceed the limit", Toast.LENGTH_LONG).show()
            }

        }
        binding.btnadd.setOnClickListener {

            binding.textviewInput.append("+")
            Log.i("digits", digitsCounter.toString())
            digitsCounter = 0
        }
        binding.btnsub.setOnClickListener {

            binding.textviewInput.append("-")
            Log.i("digits", digitsCounter.toString())
            digitsCounter = 0
        }
        binding.btnMul.setOnClickListener {

            binding.textviewInput.append("x")
            Log.i("digits", digitsCounter.toString())
            digitsCounter = 0
        }
        binding.btnDiv.setOnClickListener {

            binding.textviewInput.append("÷")
            Log.i("digits", digitsCounter.toString())
            digitsCounter = 0
        }
        binding.btnPer.setOnClickListener {

            binding.textviewInput.append("%")
            Log.i("digits", digitsCounter.toString())
            digitsCounter = 0
        }
        binding.btnPN.setOnClickListener {
            var userInput = binding.textviewInput.text.toString()
                val number = userInput.toIntOrNull() ?: return@setOnClickListener // Convert to Int, return if not a number
                userInput = (-number).toString() // Toggle sign using unary minus operator
                binding.textviewInput.text = userInput // Update the TextView with the toggled value

        }

        binding.btnEqual.setOnClickListener {
            var userInput = binding.textviewInput.text.toString()
            val userInput2 = userInput.toCharArray()

            for (i in userInput.indices) {
                if (userInput[i] == 'x') {
                    userInput2[i] = '*'
                } else if (userInput[i] == '÷') {
                    userInput2[i] = '/'
                }
                userInput = String(userInput2)
            }
            var result2=userInput.last()
            println(result2)
            if (result2=='+'||result2=='*'||result2=='-'||result2=='/'||result2=='%'||result2=='.'){
                Toast.makeText(requireContext(), "Wrong format", Toast.LENGTH_LONG).show()
            }else{
                val expression = ExpressionBuilder(userInput).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.textviewoutput.text = longResult.toString()
                } else {
                    binding.textviewoutput.text = result.toString()
            }
//          println(userInput)
//            if (!userInput[userInput.lastIndex].isDigit()){
//                Toast.makeText(requireContext(), "Wrong format", Toast.LENGTH_LONG).show()
//            }else{
//                val expression = ExpressionBuilder(userInput).build()
//                val result = expression.evaluate()
//                val longResult = result.toLong()
//                if (result == longResult.toDouble()) {
//                    binding.textviewoutput.text = longResult.toString()
//                } else {
//                    binding.textviewoutput.text = result.toString()
//                }
            }
        }
    }
}





