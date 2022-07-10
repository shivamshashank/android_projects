package com.example.navigation2

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
import com.example.navigation2.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.apply {
            nextButton.setOnClickListener {
                if (TextUtils.isEmpty(nameEditText.text.toString())) {
                    Toast.makeText(activity, "Please enter your name", Toast.LENGTH_LONG).show()
                } else {
                    val bundle: Bundle = bundleOf("name" to nameEditText.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_nameFragment_to_emailFragment, bundle)
                }
            }
        }

        return binding.root
    }

}