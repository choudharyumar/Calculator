package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToFragment(SplashScreen())
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            goToFragment(CalculatorFragment())
        }, 2500)




    }
    private fun goToFragment(fragment: Fragment){
        fragmentManager=supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragContainer1,fragment).commit()
    }
}