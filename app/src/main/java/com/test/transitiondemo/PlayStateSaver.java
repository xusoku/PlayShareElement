package com.test.transitiondemo;

import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerView;
import com.hw.ycshareelement.transition.ViewStateSaver;

/**
 * Created by xushengfu on 2019/4/24.
 */

public class PlayStateSaver extends ViewStateSaver {


    public boolean getIsPlaying(Bundle bundle) {
        return bundle.getBoolean("isPlaying");
    }

    public long getPosition(Bundle bundle) {
        return bundle.getLong("textColor");
    }

    @Override
    protected void captureViewInfo(View view, Bundle bundle) {
        if (view instanceof PlayerView) {
            PlayerView playerView= (PlayerView) view;

            bundle.putBoolean("isPlaying",isPlaying(playerView.getPlayer()));
            bundle.putLong("position",playerView.getPlayer()==null?0:playerView.getPlayer().getCurrentPosition());
        }
    }

    private boolean isPlaying(Player player) {
        return player != null
                && player.getPlaybackState() != Player.STATE_ENDED
                && player.getPlaybackState() != Player.STATE_IDLE
                && player.getPlayWhenReady();
    }

}
