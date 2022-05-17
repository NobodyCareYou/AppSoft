package soft.zhuhuo.lib;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.net.NetworkRequiredInfo;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.lib.utils.UIUtil;

public class BaseApplication extends Application {

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new MaterialHeader(context).setColorSchemeResources(R.color.black));
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new BallPulseFooter(context));
    }

    /**
     * 上下文
     */
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRouter(this);
    }

    public static Context getInstance() {
        return instance;
    }

    private void initRouter(BaseApplication mApplication) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (UIUtil.isApkInDebug(instance)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(mApplication);
        MVUtils.init(this);
        NetworkApi.init(new NetworkRequiredInfo(this));
        TUtils.init(this);

    }
}
