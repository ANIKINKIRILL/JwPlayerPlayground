package com.anikinkirill.jwplayerplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.longtailvideo.jwplayer.JWPlayerView
import com.longtailvideo.jwplayer.configuration.PlayerConfig
import com.longtailvideo.jwplayer.media.ads.AdBreak
import com.longtailvideo.jwplayer.media.ads.AdSource
import com.longtailvideo.jwplayer.media.ads.Advertising
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem


class MainActivity : AppCompatActivity() {

    private lateinit var jwPlayerView: JWPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jwPlayerView = findViewById(R.id.jwplayer)

        val adSchedule = ArrayList<AdBreak>()

        val midRollBreak = AdBreak.Builder()
            .tag("https://stats.seedr.com/vast?gid=5f46295381da8d14654e9ea3&debug=true")
            .offset("5")
            .build()

        adSchedule.add(midRollBreak)

        val advertising = Advertising(AdSource.VAST, adSchedule)

        val playlistItem = PlaylistItem.Builder()
                .file("https://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8")
                .build()

        val playlist = ArrayList<PlaylistItem>()
        playlist.add(playlistItem)
        val config = PlayerConfig.Builder()
            .playlist(playlist)
            .advertising(advertising)
            .autostart(true)
            .build()
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