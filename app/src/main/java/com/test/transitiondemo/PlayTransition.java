package com.test.transitiondemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
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
        ShareElementInfo info = ShareElementInfo.getFromView(transitionValues.view);
        if(info != null && info.getViewStateSaver() instanceof PlayStateSaver) {
            mToPlaying=((PlayStateSaver)(info.getViewStateSaver())).getIsPlaying(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
            mToPosition=((PlayStateSaver)(info.getViewStateSaver())).getPosition(info.isEnter()?info.getFromViewBundle():info.getToViewBundle());
        }
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        ShareElementInfo info = ShareElementInfo.getFromView(startValues.view);
        if(info != null && info.getViewStateSaver() instanceof PlayStateSaver) {
            PlayerView view = (PlayerView) startValues.view;

            int[] vLocation = new int[2];
            view.getLocationInWindow(vLocation);
            int centerX = vLocation[0] + view.getMeasuredWidth() / 2;
            int centerY = vLocation[1] + view.getMeasuredHeight() / 2;

            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            int maxRradius = (int) Math.hypot(width, height);

            Log.e("player","centerX="+centerX+"   centerY="+centerY);
            Log.e("player","maxRradius="+maxRradius);
            Animator animator1 =ViewAnimationUtils.createCircularReveal(view,0,height,0,maxRradius);

            ValueAnimator vaSY = ObjectAnimator.ofFloat(view, "scaleX", 0.8f,
                    1.0f);
//            ValueAnimator vaSY1 = ObjectAnimator.ofFloat(view, "scaleX", 1.2f,1.0f);

            vaSY.setInterpolator(new OvershootInterpolator(10));
            AnimatorSet aa=new AnimatorSet();
            aa.playSequentially(vaSY);

//            aa.playTogether(animator1);
            return aa;
        } else {
            return super.createAnimator(sceneRoot, startValues, endValues);
        }
    }
}
