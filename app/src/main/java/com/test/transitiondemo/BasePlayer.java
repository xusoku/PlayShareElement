package com.test.transitiondemo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.video.VideoListener;

/**
 * Created by xushengfu on 2019/4/24.
 */

public class BasePlayer {

    private SimpleExoPlayer player;
    private boolean playWhenReady = false;
    private int currentWindow;
    private long playbackPosition = 0;
    private MediaSource mediaSource;


    private static final BasePlayer basePlayer = new BasePlayer();

    public static BasePlayer getInstance() {
        return basePlayer;
    }

    public SimpleExoPlayer getPlayer(Context context) {
        if(player==null){
            init(context);
        }
        return player;
    }

    private BasePlayer() {
    }

    public void init(Context context) {
        getRawArray(context);
        initializePlayer(context);
        setListener();
    }

    public long getPlaybackPosition() {
        return playbackPosition;
    }

    private void getRawArray(Context context) {
        Resources res = context.getResources();
        final TypedArray sources = res.obtainTypedArray(R.array.video_source);
        int[] videoSources = new int[sources.length()];
        for (int i = 0; i < sources.length(); i++) {
            videoSources[i] = sources.getResourceId(i, -1);
        }
        sources.recycle();

        createMediaSources(context, videoSources);
    }


    private void initializePlayer(Context context) {
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(
                    new DefaultRenderersFactory(context),
                    new DefaultTrackSelector(), new DefaultLoadControl());
            player.seekTo(currentWindow, playbackPosition);

//        Uri uri = Uri.parse("http://sl.video.xycdn.n0808.com/r_733d71990c8d2afe7dd85d0cdb18a17331e24796?sign=ae2b1057c051727166a8d28a0d3988b8&t=b97f12bc&xsign=1556099614-ab9e8f98f167a94c35174bda8bddf920");
//        mediaSources[0]= buildMediaSource(uri);
        }

    }
    private void createMediaSources(Context context, int[] videoSources) {
        MediaSource[] mediaSources = new MediaSource[videoSources.length];
        for (int i = 0; i < videoSources.length; i++) {
            int videoSource = videoSources[i];
            try {
                DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(videoSource));
                final RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
                rawResourceDataSource.open(dataSpec);

                // The MediaSource represents the media to be played.
                ExtractorMediaSource.Factory extractorMediaFactory = new ExtractorMediaSource.Factory(new DataSource.Factory() {
                    @Override
                    public DataSource createDataSource() {
                        return rawResourceDataSource;
                    }
                });
                extractorMediaFactory.setExtractorsFactory(Mp4Extractor.FACTORY);
                MediaSource mediaSource = extractorMediaFactory.createMediaSource(rawResourceDataSource.getUri());
                mediaSources[i] = mediaSource;
            } catch (RawResourceDataSource.RawResourceDataSourceException e) {
                e.printStackTrace();
            }
        }
        mediaSource = mediaSources[0];
    }

    private MediaSource buildMediaSource(Uri uri) {
        return new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("exoplayer-codelab")).
                createMediaSource(uri);
    }

    private void setListener() {
        player.addListener(new Player.DefaultEventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {
                Log.e("player", "onTimelineChanged");
            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
                Log.e("player", "onTracksChanged");
            }

            @Override
            public void onLoadingChanged(boolean isLoading) {
                Log.e("player", "isLoading=" + isLoading);
            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                Log.e("player", "playWhenReady=" + playWhenReady + "   playbackState=" + playbackState);
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {
                Log.e("player", "repeatMode=" + repeatMode);
            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
                Log.e("player", "shuffleModeEnabled=" + shuffleModeEnabled);
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                Log.e("player", "error=" + error.getMessage());
            }

            @Override
            public void onPositionDiscontinuity(int reason) {
                Log.e("player", "reason=" + reason);
            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Log.e("player", "playbackParameters=" + playbackParameters.toString());
            }

            @Override
            public void onSeekProcessed() {
                Log.e("player", "onSeekProcessed=" + player.getContentPosition() + "");
            }
        });
    }

    public void setUrl(String url) {
        if (player != null) {
            Uri uri = Uri.parse(url);
            mediaSource = buildMediaSource(uri);
        }
    }
    public void setVolume(int i) {
        if (player != null) {
          player.setVolume(i);
        }
    }
    public void setRefuse() {
        if (player != null) {
         player.blockingSendMessages();
        }
    }

    public void setPrepare(boolean resetPosition, boolean resetState) {
        if (player != null) {
//            player.setPlaybackParameters(new PlaybackParameters(2.0f));//倍数播放
            player.prepare(mediaSource, resetPosition, resetState);
        }
    }

    public void setPlayer(PlayerView playerView) {
        if (player != null) {
            playerView.setPlayer(player);
        }
    }

    public void seekPlayer(long playbackPosition) {
        if (player != null) {
            player.seekTo(currentWindow, playbackPosition);
        }
    }

    public void playStart() {
        if (player != null) {
            player.setPlayWhenReady(true);
        }
    }

    public void playPause() {
        if (player != null) {
            player.setPlayWhenReady(false);
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
        }
    }

    public void playStop(boolean isReset) {
        if (player != null) {
            player.stop(isReset);
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
        }
    }

    protected void onDestroy() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    private boolean isPlaying() {
        return player != null
                && player.getPlaybackState() != Player.STATE_ENDED
                && player.getPlaybackState() != Player.STATE_IDLE
                && player.getPlayWhenReady();
    }

}
