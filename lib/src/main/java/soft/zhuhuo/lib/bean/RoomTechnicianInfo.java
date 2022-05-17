package soft.zhuhuo.lib.bean;

import android.widget.TimePicker;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class RoomTechnicianInfo extends BaseObResult {


    @SerializedName("RoomInfo")
    private List<RoomInfoDTO> roomInfo;
    @SerializedName("DelayUp")
    private List<DelayUpDTO> delayUp;
    @SerializedName("FastDown")
    private List<FastDownDTO> fastDown;
    @SerializedName("NoTec")
    private List<NoTecDTO> noTec;
    @SerializedName("FastRoom")
    private List<FastRoomDTO> fastRoom;
    @SerializedName("AddItemNotice")
    private List<AddItemNoticeDTO> addItemNotice;
    @SerializedName("GoodsNotice")
    private List<GoodsNoticeDTO> goodsNotice;
    @SerializedName("FreeTec")
    private List<FreeTecDTO> freeTec;
    @SerializedName("PointClockWait")
    private List<PointClockWaitDTO> pointClockWait;
    @SerializedName("TecInfo")
    private List<TecInfoDTO> tecInfo;
    @SerializedName("TecNoticeInfo")
    private List<TecNoticeInfoDTO> tecNoticeInfo;

    public List<RoomInfoDTO> getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(List<RoomInfoDTO> roomInfo) {
        this.roomInfo = roomInfo;
    }

    public List<DelayUpDTO> getDelayUp() {
        return delayUp;
    }

    public void setDelayUp(List<DelayUpDTO> delayUp) {
        this.delayUp = delayUp;
    }

    public List<FastDownDTO> getFastDown() {
        return fastDown;
    }

    public void setFastDown(List<FastDownDTO> fastDown) {
        this.fastDown = fastDown;
    }

    public List<NoTecDTO> getNoTec() {
        return noTec;
    }

    public void setNoTec(List<NoTecDTO> noTec) {
        this.noTec = noTec;
    }

    public List<FastRoomDTO> getFastRoom() {
        return fastRoom;
    }

    public void setFastRoom(List<FastRoomDTO> fastRoom) {
        this.fastRoom = fastRoom;
    }

    public List<AddItemNoticeDTO> getAddItemNotice() {
        return addItemNotice;
    }

    public void setAddItemNotice(List<AddItemNoticeDTO> addItemNotice) {
        this.addItemNotice = addItemNotice;
    }

    public List<GoodsNoticeDTO> getGoodsNotice() {
        return goodsNotice;
    }

    public void setGoodsNotice(List<GoodsNoticeDTO> goodsNotice) {
        this.goodsNotice = goodsNotice;
    }

    public List<FreeTecDTO> getFreeTec() {
        return freeTec;
    }

    public void setFreeTec(List<FreeTecDTO> freeTec) {
        this.freeTec = freeTec;
    }

    public List<PointClockWaitDTO> getPointClockWait() {
        return pointClockWait;
    }

    public void setPointClockWait(List<PointClockWaitDTO> pointClockWait) {
        this.pointClockWait = pointClockWait;
    }

    public List<TecInfoDTO> getTecInfo() {
        return tecInfo;
    }

    public void setTecInfo(List<TecInfoDTO> tecInfo) {
        this.tecInfo = tecInfo;
    }

    public List<TecNoticeInfoDTO> getTecNoticeInfo() {
        return tecNoticeInfo;
    }

    public void setTecNoticeInfo(List<TecNoticeInfoDTO> tecNoticeInfo) {
        this.tecNoticeInfo = tecNoticeInfo;
    }

    public static class RoomInfoDTO extends SelectAble{
        @SerializedName("RoomID")
        private String roomID;
        @SerializedName("RoomTypeID")
        private String roomTypeID;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("BedCount")
        private String bedCount;
        @SerializedName("FloorID")
        private String floorID;
        @SerializedName("IP")
        private String ip;
        @SerializedName("EquipmentID")
        private String equipmentID;
        @SerializedName("RoomJC")
        private String roomJC;
        @SerializedName("Sort")
        private String sort;
        @SerializedName("IsVR")
        private String isVR;
        @SerializedName("IsNight")
        private String isNight;
        @SerializedName("RoomNote")
        private String roomNote;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("RoomTypeName")
        private String roomTypeName;
        @SerializedName("FloorName")
        private String floorName;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("TecStateID")
        private String tecStateID;
        @SerializedName("TecTimeLong")
        private String tecTimeLong;
        @SerializedName("SendNum")
        private String sendNum;
        @SerializedName("NoTecNum")
        private String noTecNum;
        @SerializedName("ClockingNum")
        private String clockingNum;
        @SerializedName("RemaindTime")
        private String remaindTime;
        @SerializedName("WaitTime")
        private String waitTime;
        @SerializedName("RestTime")
        private String restTime;
        @SerializedName("Linked")
        private String linked;
        @SerializedName("LinkRoomCode")
        private String linkRoomCode;
        @SerializedName("LinkCount")
        private String linkCount;
        @SerializedName("ConsumMoney")
        private String consumMoney;

        public String getRoomID() {
            return roomID;
        }

        public void setRoomID(String roomID) {
            this.roomID = roomID;
        }

        public String getRoomTypeID() {
            return roomTypeID;
        }

        public void setRoomTypeID(String roomTypeID) {
            this.roomTypeID = roomTypeID;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getBedCount() {
            return bedCount;
        }

        public void setBedCount(String bedCount) {
            this.bedCount = bedCount;
        }

        public String getFloorID() {
            return floorID;
        }

        public void setFloorID(String floorID) {
            this.floorID = floorID;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getEquipmentID() {
            return equipmentID;
        }

        public void setEquipmentID(String equipmentID) {
            this.equipmentID = equipmentID;
        }

        public String getRoomJC() {
            return roomJC;
        }

        public void setRoomJC(String roomJC) {
            this.roomJC = roomJC;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getIsVR() {
            return isVR;
        }

        public void setIsVR(String isVR) {
            this.isVR = isVR;
        }

        public String getIsNight() {
            return isNight;
        }

        public void setIsNight(String isNight) {
            this.isNight = isNight;
        }

        public String getRoomNote() {
            return roomNote;
        }

        public void setRoomNote(String roomNote) {
            this.roomNote = roomNote;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getRoomTypeName() {
            return roomTypeName;
        }

        public void setRoomTypeName(String roomTypeName) {
            this.roomTypeName = roomTypeName;
        }

        public String getFloorName() {
            return floorName;
        }

        public void setFloorName(String floorName) {
            this.floorName = floorName;
        }

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
        }

        public String getTecStateID() {
            return tecStateID;
        }

        public void setTecStateID(String tecStateID) {
            this.tecStateID = tecStateID;
        }

        public String getTecTimeLong() {
            return tecTimeLong;
        }

        public void setTecTimeLong(String tecTimeLong) {
            this.tecTimeLong = tecTimeLong;
        }

        public String getSendNum() {
            return sendNum;
        }

        public void setSendNum(String sendNum) {
            this.sendNum = sendNum;
        }

        public String getNoTecNum() {
            return noTecNum;
        }

        public void setNoTecNum(String noTecNum) {
            this.noTecNum = noTecNum;
        }

        public String getClockingNum() {
            return clockingNum;
        }

        public void setClockingNum(String clockingNum) {
            this.clockingNum = clockingNum;
        }

        public String getRemaindTime() {
            return remaindTime;
        }

        public void setRemaindTime(String remaindTime) {
            this.remaindTime = remaindTime;
        }

        public String getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(String waitTime) {
            this.waitTime = waitTime;
        }

        public String getRestTime() {
            return restTime;
        }

        public void setRestTime(String restTime) {
            this.restTime = restTime;
        }

        public String getLinked() {
            return linked;
        }

        public void setLinked(String linked) {
            this.linked = linked;
        }

        public String getLinkRoomCode() {
            return linkRoomCode;
        }

        public void setLinkRoomCode(String linkRoomCode) {
            this.linkRoomCode = linkRoomCode;
        }

        public String getLinkCount() {
            return linkCount;
        }

        public void setLinkCount(String linkCount) {
            this.linkCount = linkCount;
        }

        public String getConsumMoney() {
            return consumMoney;
        }

        public void setConsumMoney(String consumMoney) {
            this.consumMoney = consumMoney;
        }
    }

    public static class DelayUpDTO {
        @SerializedName("ConsumID")
        private String consumID;
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("ClockType")
        private String clockType;
        @SerializedName("DelayTime")
        private String delayTime;

        public String getConsumID() {
            return consumID;
        }

        public void setConsumID(String consumID) {
            this.consumID = consumID;
        }

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
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

        public String getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(String delayTime) {
            this.delayTime = delayTime;
        }
    }

    public static class FastDownDTO extends SelectAble{
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("PostName")
        private String postName;
        @SerializedName("PostID")
        private String postID;
        @SerializedName("FastDownTime")
        private String fastDownTime;
        @SerializedName("ClockInfo")
        private String clockInfo;
        @SerializedName("ClassName")
        private String className;
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("IsOrder")
        private String isOrder;

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getPostID() {
            return postID;
        }

        public void setPostID(String postID) {
            this.postID = postID;
        }

        public String getFastDownTime() {
            return fastDownTime;
        }

        public void setFastDownTime(String fastDownTime) {
            this.fastDownTime = fastDownTime;
        }

        public String getClockInfo() {
            return clockInfo;
        }

        public void setClockInfo(String clockInfo) {
            this.clockInfo = clockInfo;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getIsOrder() {
            return isOrder;
        }

        public void setIsOrder(String isOrder) {
            this.isOrder = isOrder;
        }
    }

    public static class NoTecDTO extends SelectAble{
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("OrderSex")
        private String orderSex;
        @SerializedName("WaitedTime")
        private String waitedTime;
        @SerializedName("MaybeWaitTime")
        private String maybeWaitTime;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("PriorID")
        private String priorID;
        @SerializedName("PriorCode")
        private String priorCode;

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
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

        public String getOrderSex() {
            return orderSex;
        }

        public String sexStr() {
            switch (orderSex) {
                case "0":
                    return "女";
                case "1":
                    return "男";
            }
            return "未知";
        }

        public void setOrderSex(String orderSex) {
            this.orderSex = orderSex;
        }

        public String getWaitedTime() {
            return waitedTime;
        }

        public void setWaitedTime(String waitedTime) {
            this.waitedTime = waitedTime;
        }

        public String getMaybeWaitTime() {
            return maybeWaitTime;
        }

        public void setMaybeWaitTime(String maybeWaitTime) {
            this.maybeWaitTime = maybeWaitTime;
        }

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
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
    }

    public static class FastRoomDTO {
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("RoomTypeName")
        private String roomTypeName;
        @SerializedName("FastTime")
        private String fastTime;

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getRoomTypeName() {
            return roomTypeName;
        }

        public void setRoomTypeName(String roomTypeName) {
            this.roomTypeName = roomTypeName;
        }

        public String getFastTime() {
            return fastTime;
        }

        public void setFastTime(String fastTime) {
            this.fastTime = fastTime;
        }
    }

    public static class AddItemNoticeDTO {
        @SerializedName("TecNoticeID")
        private String tecNoticeID;
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("NoticeText")
        private String noticeText;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("TecName")
        private String tecName;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("HandCode")
        private String handCode;
        @SerializedName("ItemCount")
        private String itemCount;
        @SerializedName("OrderCode")
        private String orderCode;
        @SerializedName("OrderName")
        private String orderName;
        @SerializedName("SalerCode")
        private String salerCode;
        @SerializedName("SalerName")
        private String salerName;
        @SerializedName("OrderTime")
        private String orderTime;
        @SerializedName("IsPlay")
        private String isPlay;
        @SerializedName("VoiceChannel1")
        private String voiceChannel1;
        @SerializedName("VoiceChannel2")
        private String voiceChannel2;
        @SerializedName("VoiceChannel3")
        private String voiceChannel3;
        @SerializedName("IsPrint")
        private String isPrint;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("CancelFlag")
        private String cancelFlag;
        @SerializedName("ItemKindID")
        private String itemKindID;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("WaitTime")
        private String waitTime;

        public String getTecNoticeID() {
            return tecNoticeID;
        }

        public void setTecNoticeID(String tecNoticeID) {
            this.tecNoticeID = tecNoticeID;
        }

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getNoticeText() {
            return noticeText;
        }

        public void setNoticeText(String noticeText) {
            this.noticeText = noticeText;
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

        public String getItemCount() {
            return itemCount;
        }

        public void setItemCount(String itemCount) {
            this.itemCount = itemCount;
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

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getIsPlay() {
            return isPlay;
        }

        public void setIsPlay(String isPlay) {
            this.isPlay = isPlay;
        }

        public String getVoiceChannel1() {
            return voiceChannel1;
        }

        public void setVoiceChannel1(String voiceChannel1) {
            this.voiceChannel1 = voiceChannel1;
        }

        public String getVoiceChannel2() {
            return voiceChannel2;
        }

        public void setVoiceChannel2(String voiceChannel2) {
            this.voiceChannel2 = voiceChannel2;
        }

        public String getVoiceChannel3() {
            return voiceChannel3;
        }

        public void setVoiceChannel3(String voiceChannel3) {
            this.voiceChannel3 = voiceChannel3;
        }

        public String getIsPrint() {
            return isPrint;
        }

        public void setIsPrint(String isPrint) {
            this.isPrint = isPrint;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getCancelFlag() {
            return cancelFlag;
        }

        public void setCancelFlag(String cancelFlag) {
            this.cancelFlag = cancelFlag;
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

        public String getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(String waitTime) {
            this.waitTime = waitTime;
        }
    }

    public static class GoodsNoticeDTO {
        @SerializedName("GoodsNoticeID")
        private String goodsNoticeID;
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("HandCode")
        private String handCode;
        @SerializedName("ItemCount")
        private String itemCount;
        @SerializedName("OrderCode")
        private String orderCode;
        @SerializedName("OrderName")
        private String orderName;
        @SerializedName("SalerCode")
        private String salerCode;
        @SerializedName("SalerName")
        private String salerName;
        @SerializedName("OrderTime")
        private String orderTime;
        @SerializedName("IsPlay")
        private String isPlay;
        @SerializedName("IsPrint")
        private String isPrint;
        @SerializedName("StateID")
        private String stateID;
        @SerializedName("CancelFlag")
        private String cancelFlag;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("WaitTime")
        private String waitTime;
        @SerializedName("FloorID")
        private String floorID;
        @SerializedName("FloorName")
        private String floorName;
        @SerializedName("ProduceID")
        private String produceID;

        public String getGoodsNoticeID() {
            return goodsNoticeID;
        }

        public void setGoodsNoticeID(String goodsNoticeID) {
            this.goodsNoticeID = goodsNoticeID;
        }

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
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

        public String getItemCount() {
            return itemCount;
        }

        public void setItemCount(String itemCount) {
            this.itemCount = itemCount;
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

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getIsPlay() {
            return isPlay;
        }

        public void setIsPlay(String isPlay) {
            this.isPlay = isPlay;
        }

        public String getIsPrint() {
            return isPrint;
        }

        public void setIsPrint(String isPrint) {
            this.isPrint = isPrint;
        }

        public String getStateID() {
            return stateID;
        }

        public void setStateID(String stateID) {
            this.stateID = stateID;
        }

        public String getCancelFlag() {
            return cancelFlag;
        }

        public void setCancelFlag(String cancelFlag) {
            this.cancelFlag = cancelFlag;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(String waitTime) {
            this.waitTime = waitTime;
        }

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

        public String getProduceID() {
            return produceID;
        }

        public void setProduceID(String produceID) {
            this.produceID = produceID;
        }
    }

    public static class FreeTecDTO {
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
        private String sex;
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

        public String getSex() {
            return sex;
        }

        public String getSexStr() {
            switch (sex) {
                case "0":
                    return "女";
                case "1":
                    return "男";
            }
            return "未知";
        }

        public void setSex(String sex) {
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

    public static class PointClockWaitDTO {
        @SerializedName("ConsumerDetailID")
        private String consumerDetailID;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("WaitedTime")
        private String waitedTime;
        @SerializedName("MaybeWaitTime")
        private String maybeWaitTime;
        @SerializedName("OrderTime")
        private String orderTime;

        public String getConsumerDetailID() {
            return consumerDetailID;
        }

        public void setConsumerDetailID(String consumerDetailID) {
            this.consumerDetailID = consumerDetailID;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getTecCode() {
            return tecCode;
        }

        public void setTecCode(String tecCode) {
            this.tecCode = tecCode;
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

        public String getWaitedTime() {
            return waitedTime;
        }

        public void setWaitedTime(String waitedTime) {
            this.waitedTime = waitedTime;
        }

        public String getMaybeWaitTime() {
            return maybeWaitTime;
        }

        public void setMaybeWaitTime(String maybeWaitTime) {
            this.maybeWaitTime = maybeWaitTime;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }
    }

    public static class TecInfoDTO extends SelectAble {
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



        @Override
        public String toString() {
            return "TecInfoDTO{" +
                    "tecID='" + tecID + '\'' +
                    ", wheelTime='" + wheelTime + '\'' +
                    ", tecCode='" + tecCode + '\'' +
                    ", tecName='" + tecName + '\'' +
                    ", tecRoomID='" + tecRoomID + '\'' +
                    ", stateID='" + stateID + '\'' +
                    ", note='" + note + '\'' +
                    ", sex=" + sex +
                    ", isNoWork='" + isNoWork + '\'' +
                    ", onAddWork='" + onAddWork + '\'' +
                    ", tecLocationID='" + tecLocationID + '\'' +
                    ", vrCount='" + vrCount + '\'' +
                    ", classID='" + classID + '\'' +
                    ", className='" + className + '\'' +
                    ", classBeginTime='" + classBeginTime + '\'' +
                    ", postID='" + postID + '\'' +
                    ", postSort='" + postSort + '\'' +
                    ", postName='" + postName + '\'' +
                    ", postTypeID='" + postTypeID + '\'' +
                    ", realClockedNum='" + realClockedNum + '\'' +
                    ", clockedNum='" + clockedNum + '\'' +
                    ", roomCode='" + roomCode + '\'' +
                    ", clockType='" + clockType + '\'' +
                    ", itemID='" + itemID + '\'' +
                    ", itemName='" + itemName + '\'' +
                    ", timeLong='" + timeLong + '\'' +
                    ", consumerDetailID='" + consumerDetailID + '\'' +
                    ", price='" + price + '\'' +
                    ", itemCount='" + itemCount + '\'' +
                    ", itemTimeLong='" + itemTimeLong + '\'' +
                    ", tecCandoItem='" + tecCandoItem + '\'' +
                    ", orgID='" + orgID + '\'' +
                    '}';
        }
    }

    public static class TecNoticeInfoDTO {
        @SerializedName("TecNoticeID")
        private String tecNoticeID;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("TecName")
        private String tecName;
        @SerializedName("RoomCode")
        private String roomCode;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("HandCode")
        private String handCode;
        @SerializedName("NoticeText")
        private String noticeText;
        @SerializedName("WaitTime")
        private String waitTime;
        @SerializedName("TecRoomID")
        private String tecRoomID;

        public String getTecNoticeID() {
            return tecNoticeID;
        }

        public void setTecNoticeID(String tecNoticeID) {
            this.tecNoticeID = tecNoticeID;
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

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
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

        public String getHandCode() {
            return handCode;
        }

        public void setHandCode(String handCode) {
            this.handCode = handCode;
        }

        public String getNoticeText() {
            return noticeText;
        }

        public void setNoticeText(String noticeText) {
            this.noticeText = noticeText;
        }

        public String getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(String waitTime) {
            this.waitTime = waitTime;
        }

        public String getTecRoomID() {
            return tecRoomID;
        }

        public void setTecRoomID(String tecRoomID) {
            this.tecRoomID = tecRoomID;
        }
    }
}
