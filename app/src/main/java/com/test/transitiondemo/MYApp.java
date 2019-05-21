package com.test.transitiondemo;

import android.app.Application;

/**
 * Created by xushengfu on 2019/4/25.
 */

public class MYApp extends Application {

    public static final String url="http://test.cdn.sunmi.com/VIDEO/5cdcd8cf73122.mp4";
    public static final String url2="http://test.cdn.sunmi.com/VIDEO/5cdcdd7cf133f.mp4";
    public static final String url1="https://v.qq.com/txp/iframe/player.html?vid=a0871see02k";
    public static MYApp instance;

    public static MYApp getInstance() {
        return instance;
    }

    private BasePlayer basePlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        basePlayer = BasePlayer.getInstance();
    }


    public BasePlayer getBasePlayer() {
        if (basePlayer != null) {
            return basePlayer;
        } else {
            return BasePlayer.getInstance();
        }
    }
}
