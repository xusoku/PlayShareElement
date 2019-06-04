package com.test.transitiondemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class Main4Activity extends Activity {


    ImageView image_subject1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        image_subject1 = findViewById(R.id.image_subject1);

        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Fade());

        TransitionSet transitionSet = new TransitionSet();
        ChangeBounds change = new ChangeBounds();
        change.setInterpolator(new SpringInterpolator());
        transitionSet.addTransition(change);
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(image_subject1);
        transitionSet.setDuration(400);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);

        image_subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }


    public void dof(View view) {
        finishAfterTransition();
    }
}
