package com.test.transitiondemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.BaseInterpolator;

/**
 * Created by xushengfu on 2019/5/21.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
public class CusInterpolator extends BaseInterpolator {

    private static float bounce(float t) {
        return t * t * 8.0f;
    }
    @Override
    public float getInterpolation(float x) {
//        if (t < 0.3535f){ return bounce(t);}
//        else {
//            return 1;
//        }
        float factor = 0.1f;
       return (float) (Math.pow(2, -10 * x) * Math.sin((x - factor / 4) * (2 * Math.PI) / factor) + 1);
    }
}
