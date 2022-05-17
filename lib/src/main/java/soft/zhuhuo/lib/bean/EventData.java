package soft.zhuhuo.lib.bean;

import java.util.List;

import soft.zhuhuo.lib.base.BaseRequest;

public class EventData {

    public static final int FLOOR_INFO = 1;
    public static final int ROOM_AND_TECHNICIAN_INFO = 2;
    public static final int ITEM_INFO = 3;
    public static final int SINGLE_ITEM_INFO = 4;
    public static final int ORDER_MAIN_PARAM = 5;
    public static final int ORDER_ADDITIONAL_PARAM = 6;
    public static final int ORDER_GOODS_PARAM = 7;

    public int type;


    public RoomTechnicianInfo roomInfo;

    public EventData(RoomTechnicianInfo info) {
        type = ROOM_AND_TECHNICIAN_INFO;
        this.roomInfo = info;
    }


    public FloorInfo floorInfo;


    public EventData(FloorInfo floorInfo) {
        type = FLOOR_INFO;
        this.floorInfo = floorInfo;
    }

    public List<ItemInfo.DataBean> itemInfo;

    public EventData(List<ItemInfo.DataBean> info) {
        type = ITEM_INFO;
        this.itemInfo = info;
    }

    public ItemInfo.DataBean singleItem;

    public EventData(ItemInfo.DataBean info) {
        type = SINGLE_ITEM_INFO;
        this.singleItem = info;
    }

    public BaseRequest.OrderMainParam param;

    public boolean isContinue  = false;
    public EventData(boolean isContinue,BaseRequest.OrderMainParam info) {
        type = ORDER_MAIN_PARAM;
        this.isContinue = isContinue;
        this.param = info;
    }

    public BaseRequest.OrderAdditionalParam orderAdditionalParam;

    public EventData(boolean isContinue,BaseRequest.OrderAdditionalParam info) {
        type = ORDER_ADDITIONAL_PARAM;
        this.isContinue = isContinue;
        this.orderAdditionalParam = info;
    }

    public BaseRequest.OrderGoodsParam mOrderGoodsParam;

    public EventData(BaseRequest.OrderGoodsParam info) {
        type = ORDER_GOODS_PARAM;
        this.mOrderGoodsParam = info;
    }


}
