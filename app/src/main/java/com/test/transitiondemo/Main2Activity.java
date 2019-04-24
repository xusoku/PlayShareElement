package com.test.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.ui.PlayerView;
import com.hw.ycshareelement.YcShareElement;
import com.hw.ycshareelement.transition.IShareElements;
import com.hw.ycshareelement.transition.ShareElementInfo;
import com.hw.ycshareelement.transition.TextViewStateSaver;

public class Main2Activity extends AppCompatActivity {

    View imageView;
    View textView;
    PlayerView playerView;
    private BasePlayer basePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.small_blue_icon2);
        textView=findViewById(R.id.textview2);
        playerView=findViewById(R.id.video_view1);
        basePlayer=new BasePlayer();

        playerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                basePlayer.init(Main2Activity.this,playerView);
            }
        },1000);


        YcShareElement.setEnterTransitions(this,new IShareElements() {
            @Override
            public ShareElementInfo[] getShareElements() {
                return new ShareElementInfo[]{new ShareElementInfo(imageView),
                        new ShareElementInfo(textView, new TextViewStateSaver()),
                        new ShareElementInfo(playerView,new PlayStateSaver())};
            }
        },true,new PlayShareElementTransitionfactory());

        YcShareElement.startTransition(this);
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
