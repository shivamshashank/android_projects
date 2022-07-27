package com.example.tmdb_client.presentation.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_client.R
import com.example.tmdb_client.databinding.FragmentTvShowsBinding
import com.example.tmdb_client.presentation.di.Injector
import javax.inject.Inject

class TvShowsFragment : Fragment() {
    private lateinit var binding: FragmentTvShowsBinding

    @Inject
    lateinit var tvShowsViewModelFactory: TvShowsViewModelFactory
    private lateinit var tvShowViewModel: TvShowsViewModel

    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_shows, container, false)

        (context!!.applicationContext as Injector).createTvShowsSubComponent().inject(this)

        tvShowViewModel =
            ViewModelProvider(this, tvShowsViewModelFactory)[TvShowsViewModel::class.java]

        initTvShowsRecyclerView()

        binding.toolbar.setNavigationOnClickListener(View.OnClickListener { activity!!.onBackPressed() })

        return binding.root
    }

    private fun initTvShowsRecyclerView() {
        binding.apply {
            tvShowsRecyclerView.layoutManager = LinearLayoutManager(context)
            tvShowAdapter = TvShowAdapter()
            tvShowsRecyclerView.adapter = tvShowAdapter

            displayTvShowsList()
        }
    }

    private fun displayTvShowsList() {
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(requireActivity()) {
            binding.apply {
                tvShowsLoader.visibility = View.GONE

                if (it!!.isEmpty()) {
                    noTvShowsTextView.visibility = View.VISIBLE
                    tvShowsRecyclerView.visibility = View.GONE
                } else {
                    noTvShowsTextView.visibility = View.GONE
                    tvShowsRecyclerView.visibility = View.VISIBLE

                    tvShowAdapter.setTvShowsList(it)
                    tvShowAdapter.notifyDataSetChanged()
                }
            }
        }
    }

}