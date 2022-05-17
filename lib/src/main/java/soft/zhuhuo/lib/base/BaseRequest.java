package soft.zhuhuo.lib.base;

import android.util.Log;

import androidx.appcompat.widget.DialogTitle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.utils.MVUtils;

public class BaseRequest {


    private static final String BASE_URL = "http://27vp294939.wicp.vip/LocalServer/ServerApi/";
    private static final String TAG = "PARAM_";

    public static final String ORG_ID = MVUtils.getString(Key.ORG_ID);
    public static final String CODE = MVUtils.getString(Key.PERSON_CODE);


    public static class OrderMainParam {
        public String RoomCode;
        public List<Data> data;

        public OrderMainParam(String roomCode) {
            RoomCode = roomCode;
        }

        public static class Data {
            public String itemName;
            public String itemID;
            public String tecCode;
            public int clockType;
            public int orderSex;
            public int isForce;
            public double _price;

            public String clockTypeStr() {
                switch (clockType) {
                    case 0:
                        return "轮钟";
                    case 1:
                        return "点钟";
                    case 2:
                        return "加钟";
                    case 3:
                        return "Call钟";
                    case 4:
                        return "选钟";
                }
                return "";
            }
        }

    }

    public static String getOrderMainParam(OrderMainParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2001");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("RoomCode", param.RoomCode);
        jsonObject.addProperty("HandCode", "");
        jsonObject.addProperty("OrderCode", CODE);
        jsonObject.addProperty("SalerCode", CODE);
        jsonObject.addProperty("IsMec", 0);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        for (OrderMainParam.Data datum : param.data) {
            JsonObject obj = new JsonObject();
            obj.addProperty("ItemKindID", 1);
            obj.addProperty("ItemID", datum.itemID);
            obj.addProperty("TecCode", datum.tecCode);
            obj.addProperty("ClockType", datum.clockType);
            obj.addProperty("OrderSex", datum.orderSex);
            obj.addProperty("IsForce", datum.isForce);
            data.add(obj);
        }
        jsonObject.add("Data", data);

        Log.d("getOrderMainParam", jsonObject.toString());
        return jsonObject.toString();

    }


    public static class OrderAdditionalParam {
        public String RoomCode;
        public List<Data> data;

        public OrderAdditionalParam(String roomCode) {
            RoomCode = roomCode;
        }

        public static class Data {
            public String itemName;
            public String itemID;
            public String tecCode;
            public int clockType;
            public int orderSex;
            public int isForce;
            public double _price;
            public int AddItemNotice; //1通知 0消费

            public String clockTypeStr() {
                switch (clockType) {
                    case 0:
                        return "轮钟";
                    case 1:
                        return "点钟";
                    case 2:
                        return "加钟";
                    case 3:
                        return "Call钟";
                    case 4:
                        return "选钟";
                }
                return "";
            }
        }

    }

    public static String getOrderAdditionalP(OrderAdditionalParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2017");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("RoomCode", param.RoomCode);
        jsonObject.addProperty("HandCode", "");
        jsonObject.addProperty("OrderCode", CODE);
        jsonObject.addProperty("SalerCode", CODE);
        jsonObject.addProperty("IsMec", 0);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        for (OrderAdditionalParam.Data datum : param.data) {
            JsonObject obj = new JsonObject();
            obj.addProperty("ItemKindID", 2);
            obj.addProperty("ItemID", datum.itemID);
            obj.addProperty("TecCode", datum.tecCode);
            obj.addProperty("ClockType", datum.clockType);
            obj.addProperty("OrderSex", datum.orderSex);
            obj.addProperty("IsForce", datum.isForce);
            obj.addProperty("AddItemNotice", datum.AddItemNotice);
            data.add(obj);
        }
        jsonObject.add("Data", data);


        Log.d(TAG, "getOrderAdditionalP: "+BASE_URL);
        Log.d(TAG, "getOrderAdditionalP: "+jsonObject.toString());
        return jsonObject.toString();

    }

    public static class OrderGoodsParam {
        public String RoomCode;
        public String OrderCode = CODE;
        public String SalerCode = CODE;

        public List<OrderGoodsParam.Data> data;

        public OrderGoodsParam(String roomCode) {
            RoomCode = roomCode;
        }

        public static class Data {
            public String itemName;
            public String ItemID;
            public int ItemCount;
            public double _price;
        }
    }

    public static String getOrderGoodsP(OrderGoodsParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2006");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("RoomCode", param.RoomCode);
        jsonObject.addProperty("HandCode", "");
        jsonObject.addProperty("OrderCode", CODE);
        jsonObject.addProperty("SalerCode", CODE);
        jsonObject.addProperty("IsMec", 0);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        for (OrderGoodsParam.Data datum : param.data) {
            JsonObject obj = new JsonObject();
            obj.addProperty("ItemID", datum.ItemID);
            obj.addProperty("ItemCount", String.valueOf(datum.ItemCount));
            data.add(obj);
        }
        jsonObject.add("Data", data);

        Log.d("getOrderAdditionalP", jsonObject.toString());
        return jsonObject.toString();

    }

    public static String getTDParam(String  techCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3003");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("OptTypeID", "0");
        jsonObject.addProperty("TecCode", techCode);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();

    }

    public static class TechnicianUpClockP {
        // {"ID":"3005","OrgID":"T3","MecCode":"","Data":[{"IsMec":"0","RoomCode":"903","HandCode":"","ItemID":"","TecCode":"101"}]}

        public String RoomCode;
        public String HandCode;
        public String ItemID;
        public String TecCode;
    }

    public static String getTechnicianUpClockParam(TechnicianUpClockP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3005");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", 0);
        obj.addProperty("RoomCode", param.RoomCode);
        obj.addProperty("HandCode", param.HandCode);
        obj.addProperty("ItemID", param.ItemID);
        obj.addProperty("TecCode", param.TecCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class TechnicianDownClockP {
        // {"ID":"3006","OrgID":"T3","MecCode":"","Data":[{"IsMecIsMec":0,"RoomCode":"903","TecCode":"101","IsForceEnd":0,"ForceCode":"admin"}]}
        public String RoomCode;
        public String TecCode;
        public String IsForceEnd;
        public String ForceCode = CODE;
    }

    public static String getTechnicianDownClockP(TechnicianDownClockP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3006");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", 0);
        obj.addProperty("RoomCode", param.RoomCode);
        obj.addProperty("TecCode", param.TecCode);
        obj.addProperty("IsForceEnd", param.IsForceEnd);
        obj.addProperty("ForceCode", param.ForceCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class DownClockAlertP {
        //  {"ID":"3012","OrgID":"T3","MecCode":"","Data":[{"ConsumerDetailID":"8BCC4DAEF0854FC0BD6D0B20D563853E"}]}
        public String ConsumerDetailID;

        public DownClockAlertP(String consumerDetailID) {
            ConsumerDetailID = consumerDetailID;
        }
    }

    public static String getDownClockAlertP(DownClockAlertP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3012");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class UCTParam {
        //   {"ID":"3009","OrgID":"T3","MecCode":"","Data":[{"ConsumerDetailID":"7F31AC8BE5F248EB94E8D6AB67964BFB","ClockType":"3","OptCode":"admin","AuthorCode":"admin"}]}
        public String ConsumerDetailID;
        public String ClockType;
        public String OptCode = CODE;
        public String AuthorCode = CODE;

        public UCTParam(String consumerDetailID, String clockType) {
            ConsumerDetailID = consumerDetailID;
            ClockType = clockType;
        }
    }

    public static String getUCTParam(UCTParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3009");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        obj.addProperty("ClockType", param.ClockType);
        obj.addProperty("OptCode", param.OptCode);
        obj.addProperty("AuthorCode", param.AuthorCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class UDTParam {
        //   {"ID":"3010","OrgID":"T3","MecCode":"","Data":[{"ConsumerDetailID":"BF6A7CC1C5DD491D85260CD60BC763E3","BeginTime":5,"OptCode":"admin","AuthorCode":"admin"}]}
        public String ConsumerDetailID;
        public String BeginTime;
        public String OptCode = CODE;
        public String AuthorCode = CODE;

        public UDTParam(String consumerDetailID, String beginTime) {
            ConsumerDetailID = consumerDetailID;
            BeginTime = beginTime;
        }
    }

    public static String getUDTParam(UDTParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3009");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        obj.addProperty("BeginTime", param.BeginTime);
        obj.addProperty("OptCode", param.OptCode);
        obj.addProperty("AuthorCode", param.AuthorCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }


    public static class TCDItemParam {
        //  {"ID":"10012","OrgID":"T3","OptTypeID":"3","MecCode":"","Data":[{"TecID":"0855E0032D2F49DAB7564E8A3CF4C97A","TecCode":"022","ItemID":"","BindTypeID":""}]}
        public String TecID;
        public String TecCode;

    }

    public static String getTCDParam(TCDItemParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10012");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", "3");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("TecID", param.TecID);
        obj.addProperty("TecCode", param.TecCode);
        obj.addProperty("ItemID", "");
        obj.addProperty("BindTypeID", "");
        data.add(obj);
        jsonObject.add("Data", data);
        Log.d(TAG, "getTCDParam: "+jsonObject.toString());
        return jsonObject.toString();
    }

    public static class UpdateItemParam {
        //{"ID":"2008","OrgID":"T3","MecCode":"","Data":[{"ConsumerDetailID":"FC97C4F9F0EA4EC2A165BE5098E3C31E","ItemID":"3777715885EF4CF5A09883427B916C6B","TecCode":"102","OptCode":"admin","AuthorCode":"admin","IsForce":0}]}
        public String ConsumerDetailID;
        public String ItemID;
        public String TecCode;
        public String OptCode = CODE;
        public String AuthorCode = CODE;
        public String IsForce;

    }

    public static String getUpdateItemParam(UpdateItemParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2008");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        obj.addProperty("ItemID", param.ItemID);
        obj.addProperty("TecCode", param.TecCode);
        obj.addProperty("OptCode", param.OptCode);
        obj.addProperty("AuthorCode", param.AuthorCode);
        obj.addProperty("IsForce", param.IsForce);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }


    public static String getItemParam() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10018");
        jsonObject.addProperty("OptTypeID", "3");
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ItemTypeID", "");
        obj.addProperty("ItemTypeName", "");
        obj.addProperty("ItemKindID", "");
        obj.addProperty("IsDownEpu", "");
        obj.addProperty("Sort", "");
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class CancelItemParam {
        public String ConsumerDetailID;
        public String OptCode = CODE;
        public String AuthorCode = CODE;

        public CancelItemParam(String consumerDetailID) {
            ConsumerDetailID = consumerDetailID;
        }
    }


    public static String getCancelItemParam(CancelItemParam param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2007");
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        obj.addProperty("OptCode", param.OptCode);
        obj.addProperty("AuthorCode", param.AuthorCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class UpdateTechnicianP {
        public String optTypeID;
        public String roomCode;
        public String consumerDetailID;
        public String dTecCode;
        public String isForce;
        public String isRingTec;
        public String nextOrderSex;
        public String newClockType;
    }


    public static String getUpdateTechnicianP(UpdateTechnicianP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3007");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", param.optTypeID);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", 0);
        obj.addProperty("RoomCode", param.roomCode);
        obj.addProperty("ConsumerDetailID", param.consumerDetailID);
        obj.addProperty("STecCode", param.dTecCode);
        obj.addProperty("IsForce", param.isForce); //强制更换
        obj.addProperty("IsRingTec", param.isRingTec); //是否圈牌
        obj.addProperty("NextOrderSex", param.nextOrderSex); //1换下一个男技师   0换下一个女技师
        obj.addProperty("NewClockType", param.newClockType); //新上点类型
        obj.addProperty("OptCode", CODE); //操作人
        obj.addProperty("AuthorCode", CODE); //授权人
        data.add(obj);
        jsonObject.add("Data", data);
        Log.d("Param", "getUpdateTechnicianP: " + jsonObject.toString());
        return jsonObject.toString();

    }


    public static String getItemAvailableTechnicianP(String itemId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3004");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("ItemID", itemId);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class FirstP {
        //        {"ID":"3019","OrgID":"T3","OptTypeID":0,"OptCode":"admin","AuthorCode":"admin","Data":[{"ConsumerDetailID":"9B77D5845E934BA6BF04A393543250FE"}]}
        public String OptTypeID; // 1取消 0 优先
        public String OptCode = CODE;
        public String AuthorCode = CODE;
        public String ConsumerDetailID;

        public FirstP(String optTypeID, String consumerDetailID) {
            OptTypeID = optTypeID;
            ConsumerDetailID = consumerDetailID;
        }
    }

    public static String getFirstP(FirstP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3019");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", param.OptTypeID);
        jsonObject.addProperty("OptCode", param.OptCode);
        jsonObject.addProperty("AuthorCode", param.AuthorCode);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class LeaveMessageP {
        //{"ID":"1008","OrgID":"T3","MecCode":"","Data":[{"Mess":"111112。留言人：管理员 时间: 16:18:01","Code":"005","MessageTypeID":"0","OptCode":"admin"}]}
        public String Mess;
        public String MessageTypeID = "0";
        public String Code;
        public String OptCode = CODE;

        public LeaveMessageP(String mess, String code) {
            Mess = mess;
            Code = code;
        }
    }

    public static String getLeaveMessageP(LeaveMessageP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1008");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("Mess", param.Mess);
        obj.addProperty("Code", param.Code);
        obj.addProperty("MessageTypeID", param.MessageTypeID);
        obj.addProperty("OptCode", param.OptCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class SplitP {
        //        {"ID":"2009","OrgID":"T3","NewRoomCode":"602","NewHandCode":"001","OptCode":"admin","AuthorCode":"admin","MecCode":"","Data":[{"RoomCode":"601","HandCode":"005","ConsumerDetailID":"FC97C4F9F0EA4EC2A165BE5098E3C31E"},{"RoomCode":"601","HandCode":"005","ConsumerDetailID":"BD50D445A09547E685E5D4DC6B85D7E5"}]}:
        public String NewRoomCode;
        public String RoomCode;
        public String HandCode;
        public String NewHandCode = "0";
        public String OptCode = CODE;
        public String AuthorCode = CODE;
        public String ConsumerDetailID;

    }

    public static String getSplitP(SplitP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2009");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("NewRoomCode", param.NewRoomCode);
        jsonObject.addProperty("NewHandCode", param.NewHandCode);
        jsonObject.addProperty("OptCode", param.OptCode);
        jsonObject.addProperty("AuthorCode", param.AuthorCode);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomCode", param.RoomCode);
        obj.addProperty("HandCode", param.HandCode);
        obj.addProperty("ConsumerDetailID", param.ConsumerDetailID);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class UnionP {
        //    {"ID":"1003","OrgID":"T3","OptTypeID":"3","MecCode":"","Data":[{"RoomCode":"","OptCode":"admin","AuthorCode":"admin"}]}
        public String OptTypeID;
        public String OptCode = CODE;
        public String AuthorCode = CODE;
        public String RoomCode;

        public UnionP(String optTypeID) {
            OptTypeID = optTypeID;
        }
    }

    public static String getUnionP(UnionP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1003");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", param.OptTypeID);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomCode", param.RoomCode);
        obj.addProperty("OptCode", param.OptCode);
        obj.addProperty("AuthorCode", param.AuthorCode);
        data.add(obj);
        jsonObject.add("Data", data);
        Log.d(TAG, "getUnionP: " + jsonObject.toString());
        return jsonObject.toString();
    }


    public static String getCleanRoomP(String type, String roomCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1006");
        jsonObject.addProperty("OptTypeID", type);//0 请求 1完成
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomCode", roomCode);
        obj.addProperty("IsMec", 0);
        obj.addProperty("OptCode", MVUtils.getString(Key.PERSON_CODE));
        obj.addProperty("AuthorCode", MVUtils.getString(Key.PERSON_CODE));
        obj.addProperty("MemberTypeID", "");
        data.add(obj);
        jsonObject.add("Data", data);
        Log.d(TAG, "getCleanRoomP: " + jsonObject.toString());
        return jsonObject.toString();
    }


    public static String getUpdateRoomStateP(String type, String roomCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1011");
        jsonObject.addProperty("OptTypeID", type); // 2维修房  3取消维修房  4设为休息房  0过夜房  1取消过夜房
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomCode", roomCode);
        obj.addProperty("IsMec", 0);
        obj.addProperty("OptCode", MVUtils.getString(Key.PERSON_CODE));
        obj.addProperty("AuthorCode", MVUtils.getString(Key.PERSON_CODE));
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }


    public static String getSetTechnicianStateP(String OptTypeID, String technicianCode) {
//        {"ID":"3002","Sourse":"1","OrgID":"T3","OptCode":"admin","AuthorCode":"admin","OptTypeID":6,MecCode":"","Data":[{"Note":"","CancelHolidayType":"1","TecCode":"103"}]}:

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3002");
        jsonObject.addProperty("Sourse", "1");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("OptCode", CODE);
        jsonObject.addProperty("AuthorCode", CODE);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", OptTypeID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("Note", "");
        obj.addProperty("CancelHolidayType", OptTypeID.equals("6") ? "1" : "");//取消休假传1
        obj.addProperty("TecCode", technicianCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getOpenRoomP(String roomCode) {
//        {"ID":"1001","OrgID":"T3","MecCode":"","Data":[{"IsMec":"0","RoomCode":"901","OpenCode":"admin","RoomCardCode":""}]}
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1001");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", "0");
        obj.addProperty("RoomCode", roomCode);
        obj.addProperty("OpenCode", CODE);
        obj.addProperty("RoomCardCode", "");
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getRepairP(String roomCode) {
//        {"ID":"1001","OrgID":"T3","MecCode":"","Data":[{"IsMec":"0","RoomCode":"901","OpenCode":"admin","RoomCardCode":""}]}
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1001");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", "0");
        obj.addProperty("RoomCode", roomCode);
        obj.addProperty("OpenCode", CODE);
        obj.addProperty("RoomCardCode", "");
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getCompleteServiceP(String roomCode, String goodsNoticeID) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2015");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("OptCode", CODE);
        jsonObject.addProperty("RoomCode", roomCode);
        jsonObject.addProperty("IsMec", "0");
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("GoodsNoticeID", goodsNoticeID);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getCancelAdditional(String tecNoticeID) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2023");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("TecNoticeID", tecNoticeID);
        obj.addProperty("OptCode", CODE);
        obj.addProperty("AuthorCode", CODE);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getRoomTypesP() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10003");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", "3");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomTypeID", "");
        obj.addProperty("RoomTypeName", "");
        obj.addProperty("RoomTypeJC", "");
        obj.addProperty("Sort", "");
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static String getTechnicianTypeP() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10008");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OptTypeID", "3");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("PostID", "");
        obj.addProperty("PostTypeID", "2,3");
        obj.addProperty("PostName", "");
        obj.addProperty("PostJC", "");
        obj.addProperty("Sort", "");
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class AddClockP {
        public String RoomCode;
        public String TecCode;
        public String ItemID;
        public String ItemCount;
        public String IsForce;
    }

    public static String getAddClockP(AddClockP p) {
//        {"ID":"3011","OrgID":"T3","MecCode":"","Data":[{"IsMec":0,"RoomCode":"903","HandCode":"","TecCode":"101","ItemID":"17F362F36BEA42AB9E99B4785DB29672","OrderCode":"admin","ItemCount":1,"IsForce":0}]}
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3011");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("IsMec", "0");
        obj.addProperty("RoomCode", p.RoomCode);
        obj.addProperty("HandCode", "");
        obj.addProperty("TecCode", p.TecCode);
        obj.addProperty("ItemID", p.ItemID);
        obj.addProperty("OrderCode", CODE);
        obj.addProperty("ItemCount", p.ItemCount);
        obj.addProperty("IsForce", p.IsForce);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }


    public static String getUpdateRoomP(String oldRoomCode, String newRoomCode) {
//        {"ID":"1007","OrgID":"T3","MecCode":"","Data":[{"NowRoomCode":"802","IsMec":"0","OptCode":"admin","AuthorCode":"admin","OldRoomCode":"602"}]}
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "1007");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("NowRoomCode", newRoomCode);
        obj.addProperty("IsMec", "0");
        obj.addProperty("OptCode", CODE);
        obj.addProperty("AuthorCode", CODE);
        obj.addProperty("OldRoomCode", oldRoomCode);
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }

    public static class ItemAvailableTechnicianP {
        //    {"ID":"3004","OrgID":"T3","ItemID":"17F362F36BEA42AB9E99B4785DB29672","MecCode":"","Data":[]}:
        public String ItemID;

        public ItemAvailableTechnicianP(String itemID) {
            ItemID = itemID;
        }
    }

    public static String getItemAvailableTechnicianP(ItemAvailableTechnicianP param) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "3004");
        jsonObject.addProperty("OrgID", ORG_ID);
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("ItemID", param.ItemID);
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        data.add(obj);
        jsonObject.add("Data", data);
        return jsonObject.toString();
    }


}
