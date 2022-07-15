package com.example.room1.view

import android.os.Bundle
import android.os.Parcelable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.room1.R
import com.example.room1.databinding.FragmentEditSubscriberBinding
import com.example.room1.db.Subscriber
import com.example.room1.db.SubscriberDAO
import com.example.room1.db.SubscriberDatabase
import com.example.room1.db.SubscriberRepository
import com.example.room1.view_model.SubscriberViewModel
import com.example.room1.view_model.SubscriberViewModelFactory

class EditSubscriberFragment : Fragment() {
    private lateinit var binding: FragmentEditSubscriberBinding
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
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_subscriber, container, false)

        val id: Int = arguments!!.getInt("id")
        val name: String? = arguments!!.getString("name")
        val email: String? = arguments!!.getString("email")

        binding.apply {

            subscriberNameEditText.setText(name)
            subscriberEmailEditText.setText(email)

            updateButton.setOnClickListener {
                if (TextUtils.isEmpty(subscriberNameEditText.text.toString())) {
                    Toast.makeText(activity, "Please enter name!", Toast.LENGTH_LONG).show()
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(
                        subscriberEmailEditText.text.toString()
                    )
                        .matches()
                ) {
                    Toast.makeText(activity, "Invalid email!", Toast.LENGTH_LONG).show()
                } else {
                    subscriberViewModel.updateSubscriber(
                        Subscriber(
                            id,
                            subscriberNameEditText.text.toString(),
                            subscriberEmailEditText.text.toString(),
                        )
                    )

//                    activity!!.supportFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
                }
            }

            return binding.root
        }
    }
}