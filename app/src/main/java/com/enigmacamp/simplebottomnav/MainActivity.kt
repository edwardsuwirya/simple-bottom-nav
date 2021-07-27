package com.enigmacamp.simplebottomnav

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.enigmacamp.simplebottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.apply {
            setBottomNavVisible(View.GONE)
            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.homeFragmentMenu -> {
                        setBottomNavVisible(View.VISIBLE)
                        navController.navigate(
                            R.id.homeFragment,
                            null,
                            NavOptions.Builder().setPopUpTo(R.id.my_nav, true).build()
                        ); true
                    }
                    R.id.historyFragmentMenu -> {
                        setBottomNavVisible(View.VISIBLE)
                        navController.navigate(
                            R.id.historyFragment,
                            null,
                            NavOptions.Builder().setPopUpTo(R.id.my_nav, true).build()
                        ); true
                    }
                    else -> {
                        bottomNavigationView.visibility = View.GONE
                        false
                    }
                }
            }
        }
    }

    fun setBottomNavVisible(visible: Int){
        binding.bottomNavigationView.visibility = visible
    }
}