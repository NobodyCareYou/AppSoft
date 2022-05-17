package soft.zhuhuo.lib.net.interceptor;





import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import soft.zhuhuo.lib.net.INetworkRequiredInfo;

/**
 * 请求拦截器
 * @author lh
 */
public class RequestInterceptor implements Interceptor {
    /**
     * 网络请求信息
     */
    private INetworkRequiredInfo iNetworkRequiredInfo;

    public RequestInterceptor(INetworkRequiredInfo iNetworkRequiredInfo){
        this.iNetworkRequiredInfo = iNetworkRequiredInfo;
    }

    /**
     * 拦截
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        //构建器
        Request.Builder builder = chain.request().newBuilder();
        //添加使用环境
        builder.addHeader("os","android");
        //添加版本号
        builder.addHeader("appVersionCode",this.iNetworkRequiredInfo.getAppVersionCode());
        //添加版本名
        builder.addHeader("appVersionName",this.iNetworkRequiredInfo.getAppVersionName());
        //返回
        return chain.proceed(builder.build());
    }
}