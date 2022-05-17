package soft.zhuhuo.lib.bean;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.utils.DateUtil;

public class TD extends BaseObResult {


    @SerializedName("TecInfo")
    private List<TecInfoDTO> tecInfo;
    @SerializedName("TecClockInfo")
    private List<TecClockInfoDTO> tecClockInfo;

    public List<TecInfoDTO> getTecInfo() {
        return tecInfo;
    }

    public void setTecInfo(List<TecInfoDTO> tecInfo) {
        this.tecInfo = tecInfo;
    }

    public List<TecClockInfoDTO> getTecClockInfo() {
        return tecClockInfo;
    }

    public void setTecClockInfo(List<TecClockInfoDTO> tecClockInfo) {
        this.tecClockInfo = tecClockInfo;
    }

    public static class TecInfoDTO {
        @SerializedName("PersonID")
        private String personID;
        @SerializedName("PostID")
        private String postID;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("DeptID")
        private String deptID;
        @SerializedName("ClassID")
        private String classID;
        @SerializedName("LevelID")
        private String levelID;
        @SerializedName("RoleID")
        private String roleID;
        @SerializedName("PersonCode")
        private String personCode;
        @SerializedName("PersonCardCode")
        private String personCardCode;
        @SerializedName("PersonName")
        private String personName;
        @SerializedName("Sex")
        private String sex;
        @SerializedName("Phone")
        private String phone;
        @SerializedName("Phone1")
        private String phone1;
        @SerializedName("Pwd")
        private String pwd;
        @SerializedName("Note")
        private String note;
        @SerializedName("IsNoWork")
        private String isNoWork;
        @SerializedName("BirthDay")
        private String birthDay;
        @SerializedName("InTime")
        private String inTime;
        @SerializedName("OutTime")
        private String outTime;
        @SerializedName("TecRoomID")
        private String tecRoomID;
        @SerializedName("ClockQXID")
        private String clockQXID;
        @SerializedName("Finger")
        private String finger;
        @SerializedName("IsSecPost")
        private String isSecPost;
        @SerializedName("OnAddWork")
        private String onAddWork;
        @SerializedName("LimitFavourable")
        private String limitFavourable;
        @SerializedName("LimitDiscount")
        private String limitDiscount;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("WeChatID")
        private String weChatID;
        @SerializedName("DeptName")
        private String deptName;
        @SerializedName("PostName")
        private String postName;
        @SerializedName("PostTypeID")
        private String postTypeID;
        @SerializedName("LevelName")
        private String levelName;
        @SerializedName("ClassName")
        private String className;

        public String getPersonID() {
            return personID;
        }

        public void setPersonID(String personID) {
            this.personID = personID;
        }

        public String getPostID() {
            return postID;
        }

        public void setPostID(String postID) {
            this.postID = postID;
        }

        public String getStateID() {
            return stateID;
        }

        public String getStateStr() {
            switch (stateID) {
                case "1":
                    return "空闲";
                case "2":
                    return "上钟";
                case "3":
                    return "圈牌";
                case "4":
                    return "预约";
                case "5":
                    return "下班";
                case "6":
                    return "休假";
                case "7":
                    return "待钟";
            }
            return "未知";
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getDeptID() {
            return deptID;
        }

        public void setDeptID(String deptID) {
            this.deptID = deptID;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }

        public String getLevelID() {
            return levelID;
        }

        public void setLevelID(String levelID) {
            this.levelID = levelID;
        }

        public String getRoleID() {
            return roleID;
        }

        public void setRoleID(String roleID) {
            this.roleID = roleID;
        }

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }

        public String getPersonCardCode() {
            return personCardCode;
        }

        public void setPersonCardCode(String personCardCode) {
            this.personCardCode = personCardCode;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone1() {
            return phone1;
        }

        public void setPhone1(String phone1) {
            this.phone1 = phone1;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getIsNoWork() {
            return isNoWork;
        }

        public void setIsNoWork(String isNoWork) {
            this.isNoWork = isNoWork;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public String getOutTime() {
            return outTime;
        }

        public void setOutTime(String outTime) {
            this.outTime = outTime;
        }

        public String getTecRoomID() {
            return tecRoomID;
        }

        public void setTecRoomID(String tecRoomID) {
            this.tecRoomID = tecRoomID;
        }

        public String getClockQXID() {
            return clockQXID;
        }

        public void setClockQXID(String clockQXID) {
            this.clockQXID = clockQXID;
        }

        public String getFinger() {
            return finger;
        }

        public void setFinger(String finger) {
            this.finger = finger;
        }

        public String getIsSecPost() {
            return isSecPost;
        }

        public void setIsSecPost(String isSecPost) {
            this.isSecPost = isSecPost;
        }

        public String getOnAddWork() {
            return onAddWork;
        }

        public void setOnAddWork(String onAddWork) {
            this.onAddWork = onAddWork;
        }

        public String getLimitFavourable() {
            return limitFavourable;
        }

        public void setLimitFavourable(String limitFavourable) {
            this.limitFavourable = limitFavourable;
        }

        public String getLimitDiscount() {
            return limitDiscount;
        }

        public void setLimitDiscount(String limitDiscount) {
            this.limitDiscount = limitDiscount;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getWeChatID() {
            return weChatID;
        }

        public void setWeChatID(String weChatID) {
            this.weChatID = weChatID;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
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

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }


    }

    public static class TecClockInfoDTO extends SelectAble {
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("ConsumID")
        private String consumID;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("Price")
        private String price;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("HandCode")
        private String handCode;
        @SerializedName("TecID")
        private String tecID;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("TecName")
        private String tecName;
        @SerializedName("ItemCount")
        private String itemCount;
        @SerializedName("ClockType")
        private String clockType;
        @SerializedName("TimeLong")
        private String timeLong;
        @SerializedName("OrderSex")
        private String orderSex;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("SendJobTime")
        private String sendJobTime;
        @SerializedName("BeginTime")
        private String beginTime;
        @SerializedName("EndTime")
        private String endTime;
        @SerializedName("OrderTime")
        private String orderTime;
        @SerializedName("OrderCode")
        private String orderCode;
        @SerializedName("OrderName")
        private String orderName;
        @SerializedName("SalerCode")
        private String salerCode;
        @SerializedName("SalerName")
        private String salerName;
        @SerializedName("IsForceEnd")
        private String isForceEnd;
        @SerializedName("ForceCode")
        private String forceCode;
        @SerializedName("ForceName")
        private String forceName;
        @SerializedName("PriorID")
        private String priorID;
        @SerializedName("PriorCode")
        private String priorCode;
        @SerializedName("PriorName")
        private String priorName;
        @SerializedName("CancelFlag")
        private String cancelFlag;
        @SerializedName("DisMoney")
        private String disMoney;
        @SerializedName("IsGift")
        private String isGift;
        @SerializedName("IsAddWork")
        private String isAddWork;
        @SerializedName("ServerCode")
        private String serverCode;
        @SerializedName("ServerName")
        private String serverName;
        @SerializedName("IsWheeled")
        private String isWheeled;
        @SerializedName("OldRoomCode")
        private String oldRoomCode;
        @SerializedName("OldHandCode")
        private String oldHandCode;
        @SerializedName("ISDelayAddLC")
        private String iSDelayAddLC;
        @SerializedName("TicketID")
        private String ticketID;
        @SerializedName("TecRoomPrint")
        private String tecRoomPrint;
        @SerializedName("IsNotice")
        private String isNotice;
        @SerializedName("AddClockType")
        private String addClockType;
        @SerializedName("CheckTime")
        private String checkTime;
        @SerializedName("OldItemID")
        private String oldItemID;
        @SerializedName("OldItemCode")
        private String oldItemCode;
        @SerializedName("OldItemName")
        private String oldItemName;
        @SerializedName("DiffPrice")
        private String diffPrice;
        @SerializedName("FTTC")
        private String fttc;
        @SerializedName("FTCode")
        private String fTCode;
        @SerializedName("FTName")
        private String fTName;
        @SerializedName("FTTime")
        private String fTTime;
        @SerializedName("IsFiveVoice")
        private String isFiveVoice;
        @SerializedName("IsOnTimeVoive")
        private String isOnTimeVoive;
        @SerializedName("IsOverFiveVoice")
        private String isOverFiveVoice;
        @SerializedName("ItemKindID")
        private String itemKindID;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("DelayTime")
        private String delayTime;
        @SerializedName("WaitTime")
        private String waitTime;
        @SerializedName("StateName")
        private String stateName;

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getConsumID() {
            return consumID;
        }

        public void setConsumID(String consumID) {
            this.consumID = consumID;
        }

        public String getItemID() {
            return itemID;
        }

        public void setItemID(String itemID) {
            this.itemID = itemID;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getHandCode() {
            return handCode;
        }

        public void setHandCode(String handCode) {
            this.handCode = handCode;
        }

        public String getTecID() {
            return tecID;
        }

        public void setTecID(String tecID) {
            this.tecID = tecID;
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

        public String getItemCount() {
            return itemCount;
        }

        public void setItemCount(String itemCount) {
            this.itemCount = itemCount;
        }

        public String getClockType() {
            return clockType;
        }

        public String getClockTypeStr() {
            switch (clockType) {
                case "0":
                    return "轮钟";
                case "1":
                    return "点钟";
                case "2":
                    return "加钟";
                case "3":
                    return "Call钟";
                case "4":
                    return "选钟";
            }
            return "未知";
        }

        public void setClockType(String clockType) {
            this.clockType = clockType;
        }

        public String getTimeLong() {
            return timeLong;
        }

        public void setTimeLong(String timeLong) {
            this.timeLong = timeLong;
        }

        public String getOrderSex() {
            return orderSex;
        }

        public void setOrderSex(String orderSex) {
            this.orderSex = orderSex;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getSendJobTime() {
            return sendJobTime;
        }

        public void setSendJobTime(String sendJobTime) {
            this.sendJobTime = sendJobTime;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public String getOrderTimeStr() {
            if (TextUtils.isEmpty(orderTime)) {
                return "";
            } else {
                return DateUtil.getHoursMinutesAndSeconds(orderTime);
            }
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public String getSalerCode() {
            return salerCode;
        }

        public void setSalerCode(String salerCode) {
            this.salerCode = salerCode;
        }

        public String getSalerName() {
            return salerName;
        }

        public void setSalerName(String salerName) {
            this.salerName = salerName;
        }

        public String getIsForceEnd() {
            return isForceEnd;
        }

        public void setIsForceEnd(String isForceEnd) {
            this.isForceEnd = isForceEnd;
        }

        public String getForceCode() {
            return forceCode;
        }

        public void setForceCode(String forceCode) {
            this.forceCode = forceCode;
        }

        public String getForceName() {
            return forceName;
        }

        public void setForceName(String forceName) {
            this.forceName = forceName;
        }

        public String getPriorID() {
            return priorID;
        }

        public void setPriorID(String priorID) {
            this.priorID = priorID;
        }

        public String getPriorCode() {
            return priorCode;
        }

        public void setPriorCode(String priorCode) {
            this.priorCode = priorCode;
        }

        public String getPriorName() {
            return priorName;
        }

        public void setPriorName(String priorName) {
            this.priorName = priorName;
        }

        public String getCancelFlag() {
            return cancelFlag;
        }

        public void setCancelFlag(String cancelFlag) {
            this.cancelFlag = cancelFlag;
        }

        public String getDisMoney() {
            return disMoney;
        }

        public void setDisMoney(String disMoney) {
            this.disMoney = disMoney;
        }

        public String getIsGift() {
            return isGift;
        }

        public void setIsGift(String isGift) {
            this.isGift = isGift;
        }

        public String getIsAddWork() {
            return isAddWork;
        }

        public void setIsAddWork(String isAddWork) {
            this.isAddWork = isAddWork;
        }

        public String getServerCode() {
            return serverCode;
        }

        public void setServerCode(String serverCode) {
            this.serverCode = serverCode;
        }

        public String getServerName() {
            return serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }

        public String getIsWheeled() {
            return isWheeled;
        }

        public void setIsWheeled(String isWheeled) {
            this.isWheeled = isWheeled;
        }

        public String getOldRoomCode() {
            return oldRoomCode;
        }

        public void setOldRoomCode(String oldRoomCode) {
            this.oldRoomCode = oldRoomCode;
        }

        public String getOldHandCode() {
            return oldHandCode;
        }

        public void setOldHandCode(String oldHandCode) {
            this.oldHandCode = oldHandCode;
        }

        public String getISDelayAddLC() {
            return iSDelayAddLC;
        }

        public void setISDelayAddLC(String iSDelayAddLC) {
            this.iSDelayAddLC = iSDelayAddLC;
        }

        public String getTicketID() {
            return ticketID;
        }

        public void setTicketID(String ticketID) {
            this.ticketID = ticketID;
        }

        public String getTecRoomPrint() {
            return tecRoomPrint;
        }

        public void setTecRoomPrint(String tecRoomPrint) {
            this.tecRoomPrint = tecRoomPrint;
        }

        public String getIsNotice() {
            return isNotice;
        }

        public void setIsNotice(String isNotice) {
            this.isNotice = isNotice;
        }

        public String getAddClockType() {
            return addClockType;
        }

        public void setAddClockType(String addClockType) {
            this.addClockType = addClockType;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public String getOldItemID() {
            return oldItemID;
        }

        public void setOldItemID(String oldItemID) {
            this.oldItemID = oldItemID;
        }

        public String getOldItemCode() {
            return oldItemCode;
        }

        public void setOldItemCode(String oldItemCode) {
            this.oldItemCode = oldItemCode;
        }

        public String getOldItemName() {
            return oldItemName;
        }

        public void setOldItemName(String oldItemName) {
            this.oldItemName = oldItemName;
        }

        public String getDiffPrice() {
            return diffPrice;
        }

        public void setDiffPrice(String diffPrice) {
            this.diffPrice = diffPrice;
        }

        public String getFttc() {
            return fttc;
        }

        public void setFttc(String fttc) {
            this.fttc = fttc;
        }

        public String getFTCode() {
            return fTCode;
        }

        public void setFTCode(String fTCode) {
            this.fTCode = fTCode;
        }

        public String getFTName() {
            return fTName;
        }

        public void setFTName(String fTName) {
            this.fTName = fTName;
        }

        public String getFTTime() {
            return fTTime;
        }

        public void setFTTime(String fTTime) {
            this.fTTime = fTTime;
        }

        public String getIsFiveVoice() {
            return isFiveVoice;
        }

        public void setIsFiveVoice(String isFiveVoice) {
            this.isFiveVoice = isFiveVoice;
        }

        public String getIsOnTimeVoive() {
            return isOnTimeVoive;
        }

        public void setIsOnTimeVoive(String isOnTimeVoive) {
            this.isOnTimeVoive = isOnTimeVoive;
        }

        public String getIsOverFiveVoice() {
            return isOverFiveVoice;
        }

        public void setIsOverFiveVoice(String isOverFiveVoice) {
            this.isOverFiveVoice = isOverFiveVoice;
        }

        public String getItemKindID() {
            return itemKindID;
        }

        public void setItemKindID(String itemKindID) {
            this.itemKindID = itemKindID;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(String delayTime) {
            this.delayTime = delayTime;
        }

        public String getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(String waitTime) {
            this.waitTime = waitTime;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }
}
