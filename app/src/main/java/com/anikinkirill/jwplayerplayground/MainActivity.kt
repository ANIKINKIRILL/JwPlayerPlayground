package com.anikinkirill.jwplayerplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.longtailvideo.jwplayer.JWPlayerView
import com.longtailvideo.jwplayer.configuration.PlayerConfig

import com.longtailvideo.jwplayer.media.playlists.PlaylistItem

class MainActivity : AppCompatActivity() {

    private lateinit var jwPlayerView: JWPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jwPlayerView = findViewById(R.id.jwplayer)

        val playlistItem = PlaylistItem.Builder()
                .file("https://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8")
                .build()

        val playlist: MutableList<PlaylistItem> = ArrayList()
        playlist.add(playlistItem)
        val config = PlayerConfig.Builder().playlist(playlist).build()
        jwPlayerView.setup(config)
    }

    override fun onStart() {
        super.onStart()
        jwPlayerView.onStart()
    }

    override fun onResume() {
        super.onResume()
        jwPlayerView.onResume()
    }

    override fun onPause() {
        super.onPause()
        jwPlayerView.onPause()
    }

    override fun onStop() {
        super.onStop()
        jwPlayerView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        jwPlayerView.onDestroy()
    }

}