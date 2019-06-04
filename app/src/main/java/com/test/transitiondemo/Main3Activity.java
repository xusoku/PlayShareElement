package com.test.transitiondemo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends Activity {

    ImageView image_subject1;
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.93f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.93f);
        ObjectAnimator amin1 ;

        ScaleAnimation scaleAnimation ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        image_subject1 = findViewById(R.id.image_subject1);


        scaleAnimation=  new ScaleAnimation(0.9f, 1f, 0.9f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
        scaleAnimation.setDuration(500);


        amin1 = ObjectAnimator.ofPropertyValuesHolder(image_subject1, scaleX, scaleY);
        amin1.setDuration(160);


        image_subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        jump();

            }
        });

        image_subject1.setOnTouchListener(new SetViewAlphaListener());


        AutoPollRecyclerView mRecyclerView = (AutoPollRecyclerView) findViewById(R.id.autoPoll);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            list.add(" Item: " + ++i);
        }
        AutoPollAdapter adapter = new AutoPollAdapter(this, list);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setAdapter(adapter);
//        if (true) //保证itemCount的总个数宽度超过屏幕宽度->自己处理
            mRecyclerView.start();
    }

    public void jump(){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);


        Pair<View, String> pair1 = new Pair<>((View) image_subject1, ViewCompat.getTransitionName(image_subject1));

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(Main3Activity.this, pair1);

        ActivityCompat.startActivity(Main3Activity.this, intent, activityOptionsCompat.toBundle());


    }

    public class SetViewAlphaListener implements View.OnTouchListener {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.93f);
                PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.93f);

                ObjectAnimator amin1 = ObjectAnimator.ofPropertyValuesHolder(image_subject1, scaleX, scaleY);
                amin1.setDuration(160);
                amin1.start();
            } else if ( event.getAction()==MotionEvent.ACTION_UP|| event.getAction() == MotionEvent.ACTION_OUTSIDE || event.getAction() == MotionEvent.ACTION_CANCEL) {
                PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",  0.93f,1.0f);
                PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.93f,1.0f);

                ObjectAnimator amin1 = ObjectAnimator.ofPropertyValuesHolder(image_subject1, scaleX, scaleY);
                amin1.setDuration(160);
                amin1.start();
            }
            return false;
        }
    }
}
