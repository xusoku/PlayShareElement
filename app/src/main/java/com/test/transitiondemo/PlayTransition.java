package com.test.transitiondemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.ui.PlayerView;
import com.hw.ycshareelement.transition.ChangeTextTransition;
import com.hw.ycshareelement.transition.ShareElementInfo;
import com.hw.ycshareelement.transition.TextViewStateSaver;

/**
 * Created by xushengfu on 2019/4/24.
 */

public class PlayTransition extends Transition {

    private boolean mFromPlaying;
    private boolean mToPlaying;
    private long mFromPosition;
    private long mToPosition;
    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        ShareElementInfo info = ShareElementInfo.getFromView(transitionValues.view);
        if(info != null && info.getViewStateSaver() instanceof PlayStateSaver) {
            mFromPlaying=((PlayStateSaver)(info.getViewStateSaver())).getIsPlaying(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
            mFromPosition=((PlayStateSaver)(info.getViewStateSaver())).getPosition(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
        }


    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
//        ShareElementInfo info = ShareElementInfo.getFromView(transitionValues.view);
//        if(info != null && info.getViewStateSaver() instanceof PlayStateSaver) {
//            mToPlaying=((PlayStateSaver)(info.getViewStateSaver())).getIsPlaying(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
//            mToPosition=((PlayStateSaver)(info.getViewStateSaver())).getPosition(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
//        }
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        ShareElementInfo info = ShareElementInfo.getFromView(endValues.view);
        if(info != null && info.getViewStateSaver() instanceof PlayStateSaver) {
            PlayerView view = (PlayerView) endValues.view;

            Log.e("player","mFromPlaying="+mFromPlaying+"   mFromPosition="+mFromPosition);
            Log.e("player","mToPlaying="+mToPlaying+"   mToPosition="+mToPosition);
            return super.createAnimator(sceneRoot, startValues, endValues);
        } else {
            return super.createAnimator(sceneRoot, startValues, endValues);
        }
    }
}
