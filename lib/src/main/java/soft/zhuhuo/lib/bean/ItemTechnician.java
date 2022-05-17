package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class ItemTechnician extends BaseObResult {



    @SerializedName("Data")
    private List<DataDTO> data;

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO extends SelectAble{
        @SerializedName("TecID")
        private String tecID;
        @SerializedName("WheelTime")
        private String wheelTime;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("TecName")
        private String tecName;
        @SerializedName("TecRoomID")
        private String tecRoomID;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("Note")
        private String note;
        @SerializedName("Sex")
        private int sex;
        @SerializedName("IsNoWork")
        private String isNoWork;
        @SerializedName("OnAddWork")
        private String onAddWork;
        @SerializedName("TecLocationID")
        private String tecLocationID;
        @SerializedName("VrCount")
        private String vrCount;
        @SerializedName("ClassID")
        private String classID;
        @SerializedName("ClassName")
        private String className;
        @SerializedName("ClassBeginTime")
        private String classBeginTime;
        @SerializedName("PostID")
        private String postID;
        @SerializedName("PostSort")
        private String postSort;
        @SerializedName("PostName")
        private String postName;
        @SerializedName("PostTypeID")
        private String postTypeID;
        @SerializedName("RealClockedNum")
        private String realClockedNum;
        @SerializedName("ClockedNum")
        private String clockedNum;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("ClockType")
        private String clockType;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("TimeLong")
        private String timeLong;
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("Price")
        private String price;
        @SerializedName("ItemCount")
        private String itemCount;
        @SerializedName("ItemTimeLong")
        private String itemTimeLong;
        @SerializedName("TecCandoItem")
        private String tecCandoItem;
        @SerializedName("OrgID")
        private String orgID;

        public String getTecID() {
            return tecID;
        }

        public void setTecID(String tecID) {
            this.tecID = tecID;
        }

        public String getWheelTime() {
            return wheelTime;
        }

        public void setWheelTime(String wheelTime) {
            this.wheelTime = wheelTime;
        }

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
        }

        public String getTecName() {
            return tecName;
        }

        public void setTecName(String tecName) {
            this.tecName = tecName;
        }

        public String getTecRoomID() {
            return tecRoomID;
        }

        public void setTecRoomID(String tecRoomID) {
            this.tecRoomID = tecRoomID;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getIsNoWork() {
            return isNoWork;
        }

        public void setIsNoWork(String isNoWork) {
            this.isNoWork = isNoWork;
        }

        public String getOnAddWork() {
            return onAddWork;
        }

        public void setOnAddWork(String onAddWork) {
            this.onAddWork = onAddWork;
        }

        public String getTecLocationID() {
            return tecLocationID;
        }

        public void setTecLocationID(String tecLocationID) {
            this.tecLocationID = tecLocationID;
        }

        public String getVrCount() {
            return vrCount;
        }

        public void setVrCount(String vrCount) {
            this.vrCount = vrCount;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getClassBeginTime() {
            return classBeginTime;
        }

        public void setClassBeginTime(String classBeginTime) {
            this.classBeginTime = classBeginTime;
        }

        public String getPostID() {
            return postID;
        }

        public void setPostID(String postID) {
            this.postID = postID;
        }

        public String getPostSort() {
            return postSort;
        }

        public void setPostSort(String postSort) {
            this.postSort = postSort;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getPostTypeID() {
            return postTypeID;
        }

        public void setPostTypeID(String postTypeID) {
            this.postTypeID = postTypeID;
        }

        public String getRealClockedNum() {
            return realClockedNum;
        }

        public void setRealClockedNum(String realClockedNum) {
            this.realClockedNum = realClockedNum;
        }

        public String getClockedNum() {
            return clockedNum;
        }

        public void setClockedNum(String clockedNum) {
            this.clockedNum = clockedNum;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getClockType() {
            return clockType;
        }

        public void setClockType(String clockType) {
            this.clockType = clockType;
        }

        public String getItemID() {
            return itemID;
        }

        public void setItemID(String itemID) {
            this.itemID = itemID;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getTimeLong() {
            return timeLong;
        }

        public void setTimeLong(String timeLong) {
            this.timeLong = timeLong;
        }

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getItemCount() {
            return itemCount;
        }

        public void setItemCount(String itemCount) {
            this.itemCount = itemCount;
        }

        public String getItemTimeLong() {
            return itemTimeLong;
        }

        public void setItemTimeLong(String itemTimeLong) {
            this.itemTimeLong = itemTimeLong;
        }

        public String getTecCandoItem() {
            return tecCandoItem;
        }

        public void setTecCandoItem(String tecCandoItem) {
            this.tecCandoItem = tecCandoItem;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }
    }
}
