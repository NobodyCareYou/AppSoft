package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class RoomType extends BaseObResult {


    @SerializedName("Data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("RoomTypeID")
        private String roomTypeID;
        @SerializedName("RoomTypeName")
        private String roomTypeName;
        @SerializedName("RoomTypeJC")
        private String roomTypeJC;
        @SerializedName("Sort")
        private String sort;
        @SerializedName("OrgID")
        private String orgID;

        public String getRoomTypeID() {
            return roomTypeID;
        }

        public void setRoomTypeID(String roomTypeID) {
            this.roomTypeID = roomTypeID;
        }

        public String getRoomTypeName() {
            return roomTypeName;
        }

        public void setRoomTypeName(String roomTypeName) {
            this.roomTypeName = roomTypeName;
        }

        public String getRoomTypeJC() {
            return roomTypeJC;
        }

        public void setRoomTypeJC(String roomTypeJC) {
            this.roomTypeJC = roomTypeJC;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }
    }
}
