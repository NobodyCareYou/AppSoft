package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TechnicianType extends BaseResult{


    @SerializedName("Data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("PostID")
        private String postID;
        @SerializedName("PostTypeID")
        private String postTypeID;
        @SerializedName("PostName")
        private String postName;
        @SerializedName("PostJC")
        private String postJC;
        @SerializedName("Sort")
        private String sort;
        @SerializedName("OrgID")
        private String orgID;

        public String getPostID() {
            return postID;
        }

        public void setPostID(String postID) {
            this.postID = postID;
        }

        public String getPostTypeID() {
            return postTypeID;
        }

        public void setPostTypeID(String postTypeID) {
            this.postTypeID = postTypeID;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getPostJC() {
            return postJC;
        }

        public void setPostJC(String postJC) {
            this.postJC = postJC;
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
