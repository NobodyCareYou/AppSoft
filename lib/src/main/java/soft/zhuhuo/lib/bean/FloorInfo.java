package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class FloorInfo extends BaseObResult {


    @SerializedName("Data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("FloorID")
        private String floorID;
        @SerializedName("FloorName")
        private String floorName;
        @SerializedName("Sort")
        private String sort;
        @SerializedName("OrgID")
        private String orgID;

        public String getFloorID() {
            return floorID;
        }

        public void setFloorID(String floorID) {
            this.floorID = floorID;
        }

        public String getFloorName() {
            return floorName;
        }

        public void setFloorName(String floorName) {
            this.floorName = floorName;
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
