package com.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofit1.databinding.ActivityMainBinding
import com.example.retrofit1.models.Albums
import com.example.retrofit1.models.AlbumsItem
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        // getRequestWithPathParameters()

        // getRequestWithQueryParameters()

        uploadAlbum()
    }

    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> = retrofitService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title: String = it.body()!!.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response: Response<Albums> = retrofitService.getAlbumsParticularUserId(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsList: MutableListIterator<AlbumsItem>? = it.body()?.listIterator()

            if (albumsList == null) {
                "Album List is null!".also { it1 -> binding.albumsListTextView.text = it1 }
            } else {
                while (albumsList.hasNext()) {
                    val albumsItem: AlbumsItem = albumsList.next()
                    val albumText: String =
                        " User Id : ${albumsItem.userId}\n Album Id : ${albumsItem.id}\n Album Title : ${albumsItem.title}\n\n\n"

                    binding.albumsListTextView.append(albumText)
                }
            }
        })
    }

    private fun uploadAlbum() {
        val responseLiveData: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> =
                retrofitService.uploadAlbum(AlbumsItem(0, "My Title", 3))
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsItem: AlbumsItem? = it.body()
            val albumText: String =
                " User Id : ${albumsItem?.userId}\n Album Id : ${albumsItem?.id}\n Album Title : ${albumsItem?.title}\n\n\n"

            binding.albumsListTextView.text = albumText
        })
    }
}