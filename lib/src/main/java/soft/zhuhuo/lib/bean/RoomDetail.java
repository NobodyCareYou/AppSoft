package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class RoomDetail extends BaseObResult {


    @SerializedName("DiscountMoney")
    private String discountMoney;
    @SerializedName("ConsumMoney")
    private String consumMoney;
    @SerializedName("PayMoney")
    private String payMoney;
    @SerializedName("GiftMoney")
    private String giftMoney;
    @SerializedName("OpenTime")
    private String openTime;
    @SerializedName("OpenCode")
    private String openCode;
    @SerializedName("RoomMess")
    private String roomMess;
    @SerializedName("ConsumDetail")
    private List<ConsumDetailDTO> consumDetail;
    @SerializedName("ConsumInfo")
    private List<ConsumInfoDTO> consumInfo;
    @SerializedName("LinkRoom")
    private List<String> linkRoom;
    @SerializedName("RoomStateID")
    private String roomStateID;
    @SerializedName("OrderInfo")
    private List<?> orderInfo;


    public String getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(String discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getConsumMoney() {
        return consumMoney;
    }

    public void setConsumMoney(String consumMoney) {
        this.consumMoney = consumMoney;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(String giftMoney) {
        this.giftMoney = giftMoney;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    public String getRoomMess() {
        return roomMess;
    }

    public void setRoomMess(String roomMess) {
        this.roomMess = roomMess;
    }

    public List<ConsumDetailDTO> getConsumDetail() {
        return consumDetail;
    }

    public void setConsumDetail(List<ConsumDetailDTO> consumDetail) {
        this.consumDetail = consumDetail;
    }

    public List<ConsumInfoDTO> getConsumInfo() {
        return consumInfo;
    }

    public void setConsumInfo(List<ConsumInfoDTO> consumInfo) {
        this.consumInfo = consumInfo;
    }

    public List<String> getLinkRoom() {
        return linkRoom;
    }

    public void setLinkRoom(List<String> linkRoom) {
        this.linkRoom = linkRoom;
    }

    public String getRoomStateID() {
        return roomStateID;
    }

    public void setRoomStateID(String roomStateID) {
        this.roomStateID = roomStateID;
    }

    public List<?> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<?> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public static class ConsumDetailDTO {
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
        @SerializedName("ClockTime")
        private float clockTime;
        @SerializedName("DisPrice")
        private String disPrice;
        @SerializedName("IsOnlyCash")
        private String isOnlyCash;
        @SerializedName("IsCanDiscount")
        private String isCanDiscount;
        @SerializedName("OpenTime")
        private String openTime;
        @SerializedName("ItemConsumMoney")
        private String itemConsumMoney;
        @SerializedName("ItemDisMoney")
        private String itemDisMoney;
        @SerializedName("ItemDisEndMoney")
        private String itemDisEndMoney;

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

        public float getClockTime() {
            return clockTime;
        }

        public void setClockTime(float clockTime) {
            this.clockTime = clockTime;
        }

        public String getDisPrice() {
            return disPrice;
        }

        public void setDisPrice(String disPrice) {
            this.disPrice = disPrice;
        }

        public String getIsOnlyCash() {
            return isOnlyCash;
        }

        public void setIsOnlyCash(String isOnlyCash) {
            this.isOnlyCash = isOnlyCash;
        }

        public String getIsCanDiscount() {
            return isCanDiscount;
        }

        public void setIsCanDiscount(String isCanDiscount) {
            this.isCanDiscount = isCanDiscount;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getItemConsumMoney() {
            return itemConsumMoney;
        }

        public void setItemConsumMoney(String itemConsumMoney) {
            this.itemConsumMoney = itemConsumMoney;
        }

        public String getItemDisMoney() {
            return itemDisMoney;
        }

        public void setItemDisMoney(String itemDisMoney) {
            this.itemDisMoney = itemDisMoney;
        }

        public String getItemDisEndMoney() {
            return itemDisEndMoney;
        }

        public void setItemDisEndMoney(String itemDisEndMoney) {
            this.itemDisEndMoney = itemDisEndMoney;
        }


        public String clockTypeStr(){
            switch (clockType) {
                case "0":
                   return "轮";
                case "1":
                    return "点";
                case "2":
                    return "加";
                case "3":
                    return "Call";
                case "4":
                    return "选";
            }
            return "";
        }




        public String getDuration() {
            String duration = "";
            if ("1".equals(itemKindID) || "2".equals(itemKindID)) {
//                if ("0"stateID)
                switch (stateID) {
                    case "0":
                    case "1":
                        duration = String.format("等%s'", clockTime);
                        break;
                    case "2":
                        if (clockTime > 0) {
                            duration = String.format("余%s'", clockTime);
                        } else {
                            duration = String.format("超%s'", -clockTime);
                        }
                        break;
                    case "3":
                        duration = "落钟";
                        break;
                }
            } else {
                switch (stateID) {
                    case "0":
                        duration = "下单";
                        break;
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        duration = "完成";
                        break;
                }
            }
            return duration;
        }

    }

    public static class ConsumInfoDTO {
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("ItemCount")
        private String itemCount;
        @SerializedName("Money")
        private String money;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemCount() {
            return itemCount;
        }

        public void setItemCount(String itemCount) {
            this.itemCount = itemCount;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
