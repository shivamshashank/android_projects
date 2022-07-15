package com.example.room1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room1.R
import com.example.room1.SubscribersListAdapter
import com.example.room1.databinding.FragmentSubscribersListBinding
import com.example.room1.db.Subscriber
import com.example.room1.db.SubscriberDAO
import com.example.room1.db.SubscriberDatabase
import com.example.room1.db.SubscriberRepository
import com.example.room1.view_model.SubscriberViewModel
import com.example.room1.view_model.SubscriberViewModelFactory

class SubscribersListFragment : Fragment() {
    private lateinit var binding: FragmentSubscribersListBinding
    private lateinit var subscriberViewModelFactory: SubscriberViewModelFactory
    private lateinit var subscriberViewModel: SubscriberViewModel

    private lateinit var subscriberDAO: SubscriberDAO
    private lateinit var subscriberRepository: SubscriberRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        subscriberDAO = SubscriberDatabase.getInstance(requireContext()).subscriberDao
        subscriberRepository = SubscriberRepository(subscriberDAO)
        subscriberViewModelFactory = SubscriberViewModelFactory(subscriberRepository)
        subscriberViewModel =
            ViewModelProvider(this, subscriberViewModelFactory)[SubscriberViewModel::class.java]

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_subscribers_list, container, false)

        binding.lifecycleOwner = this

        binding.apply {
            // Display Subscribers List
            subscriberViewModel.getAllSubscribers.asLiveData().observe(viewLifecycleOwner) {
                progressBar.visibility = View.GONE
                if (it.isEmpty()) {
                    noSubscribersTextView.visibility = View.VISIBLE
                    subscribersListRecyclerView.visibility = View.GONE
                } else {
                    noSubscribersTextView.visibility = View.GONE
                    subscribersListRecyclerView.visibility = View.VISIBLE

                    subscribersListRecyclerView.layoutManager = LinearLayoutManager(context)
                    subscribersListRecyclerView.adapter = SubscribersListAdapter(it) { selectedSubscriber: Subscriber ->
                        subscriberViewModel.deleteSubscriber(selectedSubscriber)
                    }
                }
            }

            addSubscriberFAB.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_subscribersListFragment_to_addSubscriberFragment)
            }

            deleteAllSubscribersFAB.setOnClickListener {
                subscriberViewModel.deleteAllSubscribers()
            }
        }

        return binding.root
    }

}