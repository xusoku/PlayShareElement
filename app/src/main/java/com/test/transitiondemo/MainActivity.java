package com.test.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.video.VideoListener;
import com.hw.ycshareelement.YcShareElement;
import com.hw.ycshareelement.transition.IShareElements;
import com.hw.ycshareelement.transition.ShareElementInfo;
import com.hw.ycshareelement.transition.TextViewStateSaver;

import java.util.ArrayList;
import java.util.List;
//https://github.com/yellowcath/YcShareElement

public class MainActivity extends AppCompatActivity {
    View imageView;
    View textView;
    private BasePlayer basePlayer;

    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        playerView = findViewById(R.id.video_view);
        basePlayer=BasePlayer.getInstance();
        basePlayer.init(this,playerView);
        YcShareElement.enableContentTransition(getApplication());

        imageView=findViewById(R.id.small_blue_icon);
        textView=findViewById(R.id.textview1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = YcShareElement.buildOptionsBundle(MainActivity.this, new IShareElements() {
                    @Override
                    public ShareElementInfo[] getShareElements() {
                        return new ShareElementInfo[]{new ShareElementInfo(imageView),
                                new ShareElementInfo(textView, new TextViewStateSaver()),
                        new ShareElementInfo(playerView,new PlayStateSaver())};
                    }
                });
                ActivityCompat.startActivity(MainActivity.this, intent, bundle);
//                startActivity( intent);


            }
        });

        playerView.getPlayer().getVideoComponent().addVideoListener(new VideoListener() {
            @Override
            public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                Log.e("player","width="+width+"  height="+height+" unappliedRotationDegrees="+unappliedRotationDegrees+"  pixelWidthHeightRatio="+pixelWidthHeightRatio);
            }

            @Override
            public void onRenderedFirstFrame() {
                Log.e("player","onRenderedFirstFrame");

            }
        });
        playerView.setPlaybackPreparer(new PlaybackPreparer() {
            @Override
            public void preparePlayback() {
                Log.e("player","preparePlayback");
//                player.prepare(mediaSources[0], false, true);
            }
        });


//        playerView.setControlDispatcher(new ControlDispatcher() {
//            @Override
//            public boolean dispatchSetPlayWhenReady(Player player, boolean playWhenReady) {
//                Log.e("player","playWhenReady="+playWhenReady);
//                return true;
//            }
//
//            @Override
//            public boolean dispatchSeekTo(Player player, int windowIndex, long positionMs) {
//                Log.e("player","windowIndex="+windowIndex+"   positionMs="+positionMs);
//                return true;
//            }
//
//            @Override
//            public boolean dispatchSetRepeatMode(Player player, int repeatMode) {
//                Log.e("player","repeatMode="+repeatMode);
//                return true;
//            }
//
//            @Override
//            public boolean dispatchSetShuffleModeEnabled(Player player, boolean shuffleModeEnabled) {
//                Log.e("player","shuffleModeEnabled="+shuffleModeEnabled);
//                return true;
//            }
//
//            @Override
//            public boolean dispatchStop(Player player, boolean reset) {
//                Log.e("player","reset="+reset);
//                return true;
//            }
//        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        basePlayer.playPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (player != null) {
//            player.stop(true);
//            Log.e("player","onStop_state="+player.getPlaybackState());
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePlayer.onDestroy();
    }



}
