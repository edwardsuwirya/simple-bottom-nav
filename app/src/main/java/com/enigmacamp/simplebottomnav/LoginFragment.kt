package com.enigmacamp.simplebottomnav

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.enigmacamp.simplebottomnav.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LoginFragment", "onCreate: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LoginFragment", "onDestroy: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            loginButton.setOnClickListener {
                (activity as MainActivity).setBottomNavVisible(View.VISIBLE)
                findNavController().navigate(
                    R.id.homeFragment, null,
                    NavOptions.Builder().setPopUpTo(R.id.my_nav, true).build()
                )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}