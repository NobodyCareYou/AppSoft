package soft.zhuhuo.com;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.lib.utils.RouteConfig;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImmersionBar.with(this).init();

        new Thread(
                () ->
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ARouter.getInstance().build(RouteConfig.Login).navigation();
                    finish();
                }
        ).start();
    }
}
