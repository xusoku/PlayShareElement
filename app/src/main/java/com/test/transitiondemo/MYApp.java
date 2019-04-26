package com.test.transitiondemo;

import android.app.Application;

/**
 * Created by xushengfu on 2019/4/25.
 */

public class MYApp extends Application {

    public static final String url="http://sl.video.xycdn.n0808.com/r_d74a077b655290ae6314ff79e92bf08f6588c12b?sign=63da5b62268350474e5b8f64bc734ea1&t=b986fe6c&xsign=1556359158-162ea4bfe2d721dc6fee898ad7954f12";
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
        basePlayer.init(this);
    }


    public BasePlayer getBasePlayer() {
        if (basePlayer != null) {
            return basePlayer;
        } else {
            return BasePlayer.getInstance();
        }
    }
}
