package com.example.tmdb_client.presentation.tv_shows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_client.R
import com.example.tmdb_client.databinding.FragmentArtistBinding
import com.example.tmdb_client.databinding.FragmentTvShowsBinding
import com.example.tmdb_client.presentation.artist.ArtistAdapter
import com.example.tmdb_client.presentation.artist.ArtistViewModel
import com.example.tmdb_client.presentation.artist.ArtistViewModelFactory
import com.example.tmdb_client.presentation.di.Injector
import javax.inject.Inject

class TvShowsFragment : Fragment() {
    private lateinit var binding: FragmentTvShowsBinding

    @Inject
    lateinit var tvShowsViewModelFactory: TvShowsViewModelFactory
    private lateinit var tvShowViewModel: TvShowsViewModel

    private lateinit var tvShowAdapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_shows, container, false)

//        (context!!.applicationContext as Injector).createTvShowsSubComponent().inject(this)

//        tvShowViewModel =
//            ViewModelProvider(this, tvShowViewModel)[TvShowsViewModel::class.java]

        initTvShowsRecyclerView()

        return binding.root
    }

//    @Deprecated("No Idea")
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.update_menu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }

//    @Deprecated("No Idea")
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_update -> {
//                updateMoviesList()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    private fun initTvShowsRecyclerView() {
//        binding.apply {
//            .layoutManager = LinearLayoutManager(context)
//            artistAdapter = ArtistAdapter()
//            artistsRecyclerView.adapter = artistAdapter
//
//            displayArtistsList()
//        }
    }

    private fun displayArtistsList() {
//        val responseLiveData = artistViewModel.getArtists()
//        responseLiveData.observe(requireActivity()) {
//            binding.apply {
//                artistsLoader.visibility = View.GONE
//
//                if (it!!.isEmpty()) {
//                    noArtistsTextView.visibility = View.VISIBLE
//                    artistsRecyclerView.visibility = View.GONE
//                } else {
//                    noArtistsTextView.visibility = View.GONE
//                    artistsRecyclerView.visibility = View.VISIBLE
//
//                    artistAdapter.setArtistsList(it)
//                    artistAdapter.notifyDataSetChanged()
//                }
//            }
//        }
    }

}