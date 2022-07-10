package com.example.navigation2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigation2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        val name: String? = arguments!!.getString("name")
        val email: String? = arguments!!.getString("email")

        binding.apply {
            nameTextView.text = name
            emailTextView.text = email

            viewTerms.setOnClickListener {
                it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
            }
        }

        return binding.root
    }

}