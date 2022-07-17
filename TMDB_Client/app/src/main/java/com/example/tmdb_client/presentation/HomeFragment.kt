package com.example.tmdb_client.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tmdb_client.R
import com.example.tmdb_client.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.apply {
            moviesButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
            }

            tvShowsButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_tvShowsFragment)
            }

            artistsButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_artistFragment)
            }
        }

        return binding.root
    }

}