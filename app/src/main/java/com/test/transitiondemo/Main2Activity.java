package com.test.transitiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.small_blue_icon2);
        textView=findViewById(R.id.textview2);
        playerView=findViewById(R.id.video_view1);

        playerView.setPlayer(MYApp.getInstance().getBasePlayer().getPlayer(this));
//        MYApp.getInstance().getBasePlayer().setUrl(MYApp.url);
//        MYApp.getInstance().getBasePlayer().setPrepare(false,false);
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

    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
    @Override
    protected void onStop() {
        super.onStop();
//        MYApp.getInstance().getBasePlayer().playStop(false);
    }
//
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        MYApp.getInstance().getBasePlayer().onDestroy();
    }


}
