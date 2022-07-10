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
import com.example.navigation2.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        binding.apply {
            submitButton.setOnClickListener {
                if (TextUtils.isEmpty(emailEditText.text.toString())) {
                    Toast.makeText(activity, "Please enter email!", Toast.LENGTH_LONG).show()
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.text.toString())
                        .matches()
                ) {
                    Toast.makeText(activity, "Invalid email!", Toast.LENGTH_LONG).show()
                } else {
                    val name: String? = arguments!!.getString("name")
                    val bundle: Bundle =
                        bundleOf("name" to name, "email" to emailEditText.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
                }
            }
        }

        return binding.root
    }

}