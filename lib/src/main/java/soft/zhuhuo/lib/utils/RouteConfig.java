package soft.zhuhuo.lib.utils;

/**
 * Created by Administrator on 2017/12/4 0004.
 */

public class RouteConfig {

    public static final String Login = "/app/login";
    public static final String SETTING = "/app/Setting";
    public static final String HOME_PAGE = "/module_home/main";
    public static final String HOME_UP_POINT_PAGE = "/module_home/up_point";
    public static final String ADDITIONAL_NOTICE_PAGE = "/module_home/additional_notice";
    public static final String GOODS_NOTICE_PAGE = "/module_home/goods_notice";
    public static final String MAIN_FUNCTION_PAGE = "/module_home/function";
    public static final String TECHNICIAN_INFO_PAGE = "/module_home/technician_info";
    public static final String UNION_ROOM_PAGE = "/module_home/union_room_page";


    public static final String ROOM_DETAIL = "/module_home/room_detail";


    public static final String ORDER_PAGE = "/ORDER/order";


    //获得home模块fragment
    public static final String Home_Fragment_Main = "/home/main";
    //获得chat模块fragment
    public static final String Chat_Fragment_Main = "/chat/main";
    //获得Recom模块fragment
    public static final String Recom_Fragment_Main = "/recom/main";
    //获得Me模块fragment
    public static final String Me_Fragment_Main = "/me/main";
    //跳转到登录页面
    public static final String Me_Login = "/me/main/login";
    //跳转到eventBus数据接收页面
    public static final String Me_EventBus = "/me/main/EventBus";
    //跳转到TextOne数据接收页面
    public static final String Me_TextOne = "/me/main/TextOne";
    //跳转到Test公用页面
    public static final String Me_Test = "/me/main/Test";
    //路由拦截
    public static final String Me_Test2 = "/me/main/Test2";
    //跳转到webview页面
    public static final String Me_WebView = "/me/main/WebView";

    //跳转到依赖注入页面
    public static final String Me_Inject = "/me/main/Inject";
    /**
     * 依赖注入使用，注意：必须实现SerializationService进行注册，
     */
    public static final String Home_Json_Service = "/huangxiaoguo/json";

    //跳转ForResult
    public static final String Chat_ForResult = "/chat/main/ForResult";
    //模块间服务调用，调用chat模块的接口
    public static final String Service_Chat = "/chat/service";
    //路由拦截
    public static final String Chat_Interceptor = "/chat/main/Interceptor";

    /**
     * 专门的分组，这里就叫做needLogin组，凡是在这个组下的，都会进行登录操作
     */
    public static final String NeedLogin_Test3 = "/needLogin/main/Test3";

}

