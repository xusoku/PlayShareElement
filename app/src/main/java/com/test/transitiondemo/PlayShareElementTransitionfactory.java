package com.test.transitiondemo;

import android.transition.TransitionSet;
import android.view.View;

import com.hw.ycshareelement.transition.DefaultShareElementTransitionFactory;

import java.util.List;

/**
 * Created by xushengfu on 2019/4/24.
 */

public class PlayShareElementTransitionfactory extends DefaultShareElementTransitionFactory {
    @Override
    protected TransitionSet buildShareElementsTransition(List<View> shareViewList) {
        TransitionSet transitionSet =  super.buildShareElementsTransition(shareViewList);
        transitionSet.addTransition(new PlayTransition());
        return transitionSet;
    }

}
