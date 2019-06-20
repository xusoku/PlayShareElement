package com.test.transitiondemo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import android.util.Log;
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
    LooperLayoutManager layoutManager1;
    AutoPollRecyclerView mRecyclerView1;
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
        mRecyclerView1 = (AutoPollRecyclerView) findViewById(R.id.autoPoll1);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            list.add(" Item: " + ++i);
        }
        LooperLayoutManager layoutManager = new LooperLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setLooperEnable(true);
        AutoPollAdapter adapter = new AutoPollAdapter(this, list);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
//        if (true) //保证itemCount的总个数宽度超过屏幕宽度->自己处理
        mRecyclerView.start();



        layoutManager1 = new LooperLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager1.setLooperEnable(true);
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setAdapter(adapter);
        mRecyclerView1.scrollBy(dip2px(this,30));

//        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        if (true) //保证itemCount的总个数宽度超过屏幕宽度->自己处理
        mRecyclerView1.start();



    }

    public void jump(){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);

        intent.putExtra("x",(layoutManager1.getScollDistance()));
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

    /**
     * 获取屏幕高度
     */
    public static final int getScreenHeight(Context context) {
        final int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }

    /**
     * 获取屏幕宽度
     */
    public static final int getScreenWidth(Context context) {
        final int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
