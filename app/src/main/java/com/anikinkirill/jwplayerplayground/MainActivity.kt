package com.anikinkirill.jwplayerplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.longtailvideo.jwplayer.JWPlayerView
import com.longtailvideo.jwplayer.configuration.PlayerConfig
import com.longtailvideo.jwplayer.media.ads.AdBreak
import com.longtailvideo.jwplayer.media.ads.AdRules
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

        val midRollBreak1 = AdBreak.Builder()
            .tag("https://ad.adriver.ru/cgi-bin/rle.cgi?sid=216288&bt=61&pz=0&target=blank&tuid=1&rnd=1484434468")
            .offset("5")
            .build()

        val midRollBreak2 = AdBreak.Builder()
            .tag("https://ad.adriver.ru/cgi-bin/rle.cgi?sid=216288&bt=61&pz=0&target=blank&tuid=1&rnd=1484434468")
            .offset("15")
            .build()

        adSchedule.add(midRollBreak1)
        adSchedule.add(midRollBreak2)

        val advertising = Advertising(AdSource.VAST, adSchedule)

        val playlistItem = PlaylistItem.Builder()
                .file("https://cdn.jwplayer.com/manifests/{MEDIA_ID}.m3u8")
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