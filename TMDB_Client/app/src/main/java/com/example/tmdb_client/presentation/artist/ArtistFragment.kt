package com.example.tmdb_client.presentation.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_client.R
import com.example.tmdb_client.databinding.FragmentArtistBinding
import com.example.tmdb_client.presentation.di.Injector
import javax.inject.Inject

class ArtistFragment : Fragment() {
    private lateinit var binding: FragmentArtistBinding

    @Inject
    lateinit var artistViewModelFactory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist, container, false)

        (context!!.applicationContext as Injector).createArtistSubComponent().inject(this)

        artistViewModel =
            ViewModelProvider(this, artistViewModelFactory)[ArtistViewModel::class.java]

        initArtistsRecyclerView()

        binding.toolbar.setNavigationOnClickListener(View.OnClickListener { activity!!.onBackPressed() })

        return binding.root
    }

//    @Deprecated("No Idea")
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.update_menu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
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

    private fun initArtistsRecyclerView() {
        binding.apply {
            artistsRecyclerView.layoutManager = LinearLayoutManager(context)
            artistAdapter = ArtistAdapter()
            artistsRecyclerView.adapter = artistAdapter

            displayArtistsList()
        }
    }

    private fun displayArtistsList() {
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(requireActivity()) {
            binding.apply {
                artistsLoader.visibility = View.GONE

                if (it!!.isEmpty()) {
                    noArtistsTextView.visibility = View.VISIBLE
                    artistsRecyclerView.visibility = View.GONE
                } else {
                    noArtistsTextView.visibility = View.GONE
                    artistsRecyclerView.visibility = View.VISIBLE

                    artistAdapter.setArtistsList(it)
                    artistAdapter.notifyDataSetChanged()
                }
            }
        }
    }

}