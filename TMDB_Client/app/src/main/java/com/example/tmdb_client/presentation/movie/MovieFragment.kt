package com.example.tmdb_client.presentation.movie

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_client.R
import com.example.tmdb_client.databinding.FragmentMovieBinding
import com.example.tmdb_client.presentation.di.Injector
import javax.inject.Inject

class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)

        setHasOptionsMenu(true)

        (context!!.applicationContext as Injector).createMovieSubComponent().inject(this)

        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]

        initMoviesRecyclerView()

        return binding.root
    }

    @Deprecated("No Idea")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Deprecated("No Idea")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMoviesList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initMoviesRecyclerView() {
        binding.apply {
            moviesRecyclerView.layoutManager = LinearLayoutManager(context)
            movieAdapter = MovieAdapter()
            moviesRecyclerView.adapter = movieAdapter

            displayMoviesList()
        }
    }

    private fun displayMoviesList() {
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(requireActivity()) {
            binding.apply {
                moviesLoader.visibility = View.GONE

                if (it!!.isEmpty()) {
                    noMoviesTextView.visibility = View.VISIBLE
                    moviesRecyclerView.visibility = View.GONE
                } else {
                    noMoviesTextView.visibility = View.GONE
                    moviesRecyclerView.visibility = View.VISIBLE

                    movieAdapter.setMoviesList(it)
                    movieAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun updateMoviesList() {
        binding.apply {
            moviesLoader.visibility = View.VISIBLE
            moviesRecyclerView.visibility = View.GONE
            noMoviesTextView.visibility = View.GONE

            val responseLiveData = movieViewModel.updateMovies()
            responseLiveData.observe(requireActivity()) {
                moviesLoader.visibility = View.GONE

                if (it!!.isEmpty()) {
                    noMoviesTextView.visibility = View.VISIBLE
                    moviesRecyclerView.visibility = View.GONE
                } else {
                    noMoviesTextView.visibility = View.GONE
                    moviesRecyclerView.visibility = View.VISIBLE

                    movieAdapter.setMoviesList(it)
                    movieAdapter.notifyDataSetChanged()
                }
            }
        }
    }

}