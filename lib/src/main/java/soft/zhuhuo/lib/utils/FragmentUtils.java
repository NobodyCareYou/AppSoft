package soft.zhuhuo.lib.utils;


import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by Administrator on 2017/12/4 0004.
 */

public class FragmentUtils {

    public static Fragment getHomeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteConfig.Home_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getChatFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteConfig.Chat_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getRecomFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteConfig.Recom_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getMeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteConfig.Me_Fragment_Main).navigation();
        return fragment;
    }
}

