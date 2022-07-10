package com.example.navigation1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigation1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.apply {

            submitButton.setOnClickListener {
                if (TextUtils.isEmpty(nameEditText.text.toString())) {
                    Toast.makeText(activity, "Please insert your name!", Toast.LENGTH_LONG).show()
                } else {
                    val bundle: Bundle = bundleOf("user_input" to nameEditText.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_homeFragment_to_secondFragment, bundle)
                }
            }
        }

        return binding.root
    }

}