package com.test.transitiondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by xushengfu on 2019/6/4.
 */

public class AutoPollRecyclerView extends RecyclerView {
    private static final long TIME_AUTO_POLL = 50;
    AutoPollTask autoPollTask;
    private boolean running; //标示是否正在自动轮询
    private boolean canRun;//标示是否可以自动轮询,可在不需要的是否置false
    public AutoPollRecyclerView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        autoPollTask = new AutoPollTask(this);
    }
    static class AutoPollTask implements Runnable {
        private final WeakReference<AutoPollRecyclerView> mReference;
        //使用弱引用持有外部类引用->防止内存泄漏
        public AutoPollTask(AutoPollRecyclerView reference) {
            this.mReference = new WeakReference<AutoPollRecyclerView>(reference);
        }
        @Override
        public void run() {
           final AutoPollRecyclerView recyclerView = mReference.get();
            if (recyclerView != null && recyclerView.running &&recyclerView.canRun) {
                recyclerView.scrollBy(1);
                recyclerView.postDelayed(recyclerView.autoPollTask,AutoPollRecyclerView.TIME_AUTO_POLL);
            }
        }
    }
    //开启:如果正在运行,先停止->再开启
    public void start() {
        if (running) {
            stop();
        }
        canRun = true;
        running = true;
        postDelayed(autoPollTask,TIME_AUTO_POLL);
    }
    public void stop(){
            running = false;
            removeCallbacks(autoPollTask);
    }

    public void scrollBy(final int x){
        postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollBy(x, 0);
            }
        },10);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
//        switch (e.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                if (running)
//                    stop();
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_OUTSIDE:
//                if (canRun)
//                    start();
//                break;
//        }
        return true;
    }
}