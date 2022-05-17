package soft.zhuhuo.lib.net;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.FloorInfo;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.bean.RoomDetail;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.RoomType;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.bean.TechnicianType;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.lib.bean.User;

public interface ApiService {

    @POST("/LocalServer/ServerApi/")
    Observable<User> login(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<FloorInfo> getRoomOtherInfo(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<RoomTechnicianInfo> getRoomTechnicianInfo(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<ItemInfo> getItemInfo(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<TCItem> getTechnicianCanDoItem(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<RoomDetail> getRoomDetail(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> cleanRoom(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> openRoom(@Body RequestBody param);


    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> orderMain(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> orderAdditional(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> orderGoods(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<TD> getTechnicianInfo(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> downClock(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> downClockAlert(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> cancelItem(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> updateRoom(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> cancelAdditional(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> completeGoods(@Body RequestBody param);


    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> updateItem(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> updateTechnician(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<ItemTechnician> getItemTechnician(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> setTechnicianState(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> upClock(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> updateClockType(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> updateDownTime(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> setRoomState(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<UnionRoomInfo> getUnionInfo(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> linkedRoom(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> addClock(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<BaseObResult> first(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<RoomType> getRoomType(@Body RequestBody param);

    @POST("/LocalServer/ServerApi/")
    Observable<TechnicianType> getTechnicianType(@Body RequestBody param);
}