package com.test.transitiondemo;

import android.app.Application;

/**
 * Created by xushengfu on 2019/4/25.
 */

public class MYApp extends Application {

    public static final String url="http://sl.video.xycdn.n0808.com/r_a99eb7f24d52de62904baa458ac70a18d2d42324?sign=dae7f3ed69956aa659bc47dd33de44a3&t=b98b720c&xsign=1556505030-e44f287a5ebfae400bf30ad3d05eb972";
    public static final String url1="http://sl.video.xycdn.n0808.com/r_d5179fb9f8e60c23e7e156528c2d7fc9fcc74401?sign=afee5a42012d57cf19549324a3890913&t=b9842076&xsign=1556265211-c606d5640d77c4c3ec71fb641d99c2e8";
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
