package com.test.transitiondemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.video.VideoListener;
import com.hw.ycshareelement.YcShareElement;
import com.hw.ycshareelement.transition.IShareElements;
import com.hw.ycshareelement.transition.ShareElementInfo;
import com.hw.ycshareelement.transition.TextViewStateSaver;
//https://github.com/yellowcath/YcShareElement

public class MainActivity extends AppCompatActivity {
    View imageView;
    View textView;

    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
//            StrictMode.setVmPolicy(builder.build());
//        }
        playerView = findViewById(R.id.video_view);
        playerView.setPlayer(MYApp.getInstance().getBasePlayer().getPlayer());
        MYApp.getInstance().getBasePlayer().setUrl(MYApp.url);
        MYApp.getInstance().getBasePlayer().setPrepare(true,true);
        YcShareElement.enableContentTransition(getApplication());

        imageView=findViewById(R.id.small_blue_icon);
        textView=findViewById(R.id.textview1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                MYApp.getInstance().getBasePlayer().playStart();
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
    }

    @Override
    protected void onPause() {
        super.onPause();
//        playerView.removeAllViewsInLayout();
//        MYApp.getInstance().getBasePlayer().playPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
//        MYApp.getInstance().getBasePlayer().setPrepare(false,false);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void doZoom(View view) {
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
    }

    public void doFix(View view) {
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
    }

    public void doHeight(View view) {
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
    }

    public void doWidth(View view) {
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH);
    }

    public void doFill(View view) {
        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
    }
}
