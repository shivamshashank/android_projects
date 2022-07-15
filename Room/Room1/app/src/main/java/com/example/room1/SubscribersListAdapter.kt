package com.example.room1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room1.databinding.SubscriberCardBinding
import com.example.room1.db.Subscriber

class SubscribersListAdapter(
    private val subscribersList: List<Subscriber>,
    private val clickListener: (Subscriber) -> Unit,
) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val subscriberCardBinding: SubscriberCardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.subscriber_card, parent, false)
        return MyViewHolder(subscriberCardBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }
}

class MyViewHolder(private val subscriberCardBinding: SubscriberCardBinding) :
    RecyclerView.ViewHolder(subscriberCardBinding.root) {
    fun bind(subscriber: Subscriber, deleteClickListener: (Subscriber) -> Unit) {
        subscriberCardBinding.subscriberCardView.setOnClickListener {
            val bundle: Bundle = bundleOf(
                "id" to subscriber.id,
                "name" to subscriber.name,
                "email" to subscriber.email,
            )

            it.findNavController()
                .navigate(R.id.action_subscribersListFragment_to_editSubscriberFragment, bundle)
        }

        subscriberCardBinding.subscriberName.text = subscriber.name
        subscriberCardBinding.subscriberEmail.text = subscriber.email

        subscriberCardBinding.deleteSubscriber.setOnClickListener {
            deleteClickListener(subscriber)
        }
    }
}