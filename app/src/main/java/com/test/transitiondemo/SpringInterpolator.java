package com.test.transitiondemo;

import android.view.animation.Interpolator;

/**
 * Created by xushengfu on 2019/5/27.
 */

public class SpringInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float x) {
        float factor = 0.9f;
        float result = (float) (Math.pow(2, -10 * x) * Math.sin((x - factor / 4) * (2 * Math.PI) / factor) + 1);
        return result;
    }
}
