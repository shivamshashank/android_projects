package com.example.notification1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.example.notification1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val channelId = "com.example.notification1.channel1"
    private var notificationManager: NotificationManager? = null

    private val KEY_REPLY = "key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create Notification Channel
        channelId.createNotificationChannel("Demo Name", "Demo Channel Description")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            notificationButton.setOnClickListener { displayNotification() }
        }
    }

    private fun String.createNotificationChannel(name: String, channelDescription: String) {
        val channel =
            NotificationChannel(this, name, NotificationManager.IMPORTANCE_HIGH).apply {
                description = channelDescription
            }

        notificationManager?.createNotificationChannel(channel)
    }

    private fun displayNotification() {
        val notificationId = 45

        // intent - Second Activity
        val secondActivityIntent = Intent(this, SecondActivity::class.java)
        val pendingSecondActivityIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            secondActivityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else PendingIntent.FLAG_UPDATE_CURRENT,
        )

        // action - Details Activity
        val detailsActivityIntent = Intent(this, DetailsActivity::class.java)
        val pendingDetailsActivityIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            detailsActivityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else PendingIntent.FLAG_UPDATE_CURRENT,
        )
        val detailsAction: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Details", pendingDetailsActivityIntent).build()

        // action - Settings Activity
        val settingsActivityIntent = Intent(this, SettingsActivity::class.java)
        val pendingSettingsActivityIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            settingsActivityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else PendingIntent.FLAG_UPDATE_CURRENT,
        )
        val settingsAction: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Settings", pendingSettingsActivityIntent).build()

        // action - Reply Activity
        val replyActivityIntent = Intent(this, ReplyActivity::class.java)
        val pendingReplyActivityIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            replyActivityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else PendingIntent.FLAG_UPDATE_CURRENT,
        )
        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert your name here")
            build()
        }
        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
            0, "Reply", pendingReplyActivityIntent
        ).addRemoteInput(remoteInput).build()

        val notification: Notification = NotificationCompat
            .Builder(this, channelId)
            .setContentTitle("Demo Title")
            .setContentText("This is a Demo notification")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingSecondActivityIntent)
            .addAction(detailsAction)
            .addAction(settingsAction)
            .addAction(replyAction)
            .build()

        notificationManager?.notify(notificationId, notification)
    }
}