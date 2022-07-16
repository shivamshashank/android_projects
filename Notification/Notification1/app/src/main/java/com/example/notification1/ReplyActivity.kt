package com.example.notification1

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput

class ReplyActivity : AppCompatActivity() {
    private val channelId = "com.example.notification1.channel1"
    private var notificationManager: NotificationManager? = null

    private val KEY_REPLY = "key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reply)

        receiveInput()
    }

    private fun receiveInput() {
        val notificationId = 45

        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)

        if (remoteInput == null) {
            Toast.makeText(this, "Received Input is Null!!!", Toast.LENGTH_LONG).show()
        } else {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()

            val replyTextView = findViewById<TextView>(R.id.replyTextView)
            replyTextView.text = inputString

            val repliedNotification = NotificationCompat
                .Builder(this, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply received")
                .build()

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(notificationId, repliedNotification)

        }
    }
}