package soft.zhuhuo.lib.utils;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

import soft.zhuhuo.lib.R;

public class VoiceUtils {


    public static void playRing(Context context){
        MediaPlayer mp = MediaPlayer.create(context, R.raw.ring);
        try {
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }
}
