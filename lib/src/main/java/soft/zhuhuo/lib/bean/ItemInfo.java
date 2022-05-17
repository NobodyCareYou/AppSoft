package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class ItemInfo extends BaseObResult {


    @SerializedName("Data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("ItemTypeID")
        private String itemTypeID;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("LPrice")
        private double lPrice;
        @SerializedName("LTimeLong")
        private String lTimeLong;
        @SerializedName("DPrice")
        private double dPrice;
        @SerializedName("DTimeLong")
        private String dTimeLong;
        @SerializedName("JPrice")
        private double jPrice;
        @SerializedName("JTimeLong")
        private String jTimeLong;
        @SerializedName("CPrice")
        private double cPrice;
        @SerializedName("CTimeLong")
        private String cTimeLong;
        @SerializedName("XPrice")
        private double xPrice;
        @SerializedName("XTimeLong")
        private String xTimeLong;
        @SerializedName("SaleCount")
        private String saleCount;
        @SerializedName("WagesCount")
        private String wagesCount;
        @SerializedName("IsCanDiscount")
        private String isCanDiscount;
        @SerializedName("IsOnlyCash")
        private String isOnlyCash;
        @SerializedName("IsTC")
        private String isTC;
        @SerializedName("PYM")
        private String pYM;
        @SerializedName("ProduceID")
        private String produceID;
        @SerializedName("IsPlayVoice")
        private String isPlayVoice;
        @SerializedName("IsPrint")
        private String isPrint;
        @SerializedName("Units")
        private String units;
        @SerializedName("ISFT")
        private String iSFT;
        @SerializedName("IsDownEqu")
        private String isDownEqu;
        @SerializedName("IsStop")
        private String isStop;
        @SerializedName("PriorLevel")
        private String priorLevel;
        @SerializedName("IsLZDP")
        private String isLZDP;
        @SerializedName("StoreCount")
        private String storeCount;
        @SerializedName("Sort")
        private String sort;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("ItemTypeName")
        private String itemTypeName;
        @SerializedName("ProduceName")
        private String produceName;
        @SerializedName("ItemKindID")
        private String itemKindID;
        @SerializedName("ItemKindName")
        private String itemKindName;

        public String getItemID() {
            return itemID;
        }

        public void setItemID(String itemID) {
            this.itemID = itemID;
        }

        public String getItemTypeID() {
            return itemTypeID;
        }

        public void setItemTypeID(String itemTypeID) {
            this.itemTypeID = itemTypeID;
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

        public double getLPrice() {
            return lPrice;
        }

        public void setLPrice(double lPrice) {
            this.lPrice = lPrice;
        }

        public String getLTimeLong() {
            return lTimeLong;
        }

        public void setLTimeLong(String lTimeLong) {
            this.lTimeLong = lTimeLong;
        }

        public double getDPrice() {
            return dPrice;
        }

        public void setDPrice(double dPrice) {
            this.dPrice = dPrice;
        }

        public String getDTimeLong() {
            return dTimeLong;
        }

        public void setDTimeLong(String dTimeLong) {
            this.dTimeLong = dTimeLong;
        }

        public double getJPrice() {
            return jPrice;
        }

        public void setJPrice(double jPrice) {
            this.jPrice = jPrice;
        }

        public String getJTimeLong() {
            return jTimeLong;
        }

        public void setJTimeLong(String jTimeLong) {
            this.jTimeLong = jTimeLong;
        }

        public double getCPrice() {
            return cPrice;
        }

        public void setCPrice(double cPrice) {
            this.cPrice = cPrice;
        }

        public String getCTimeLong() {
            return cTimeLong;
        }

        public void setCTimeLong(String cTimeLong) {
            this.cTimeLong = cTimeLong;
        }

        public double getXPrice() {
            return xPrice;
        }

        public void setXPrice(double xPrice) {
            this.xPrice = xPrice;
        }

        public String getXTimeLong() {
            return xTimeLong;
        }

        public void setXTimeLong(String xTimeLong) {
            this.xTimeLong = xTimeLong;
        }

        public String getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(String saleCount) {
            this.saleCount = saleCount;
        }

        public String getWagesCount() {
            return wagesCount;
        }

        public void setWagesCount(String wagesCount) {
            this.wagesCount = wagesCount;
        }

        public String getIsCanDiscount() {
            return isCanDiscount;
        }

        public void setIsCanDiscount(String isCanDiscount) {
            this.isCanDiscount = isCanDiscount;
        }

        public String getIsOnlyCash() {
            return isOnlyCash;
        }

        public void setIsOnlyCash(String isOnlyCash) {
            this.isOnlyCash = isOnlyCash;
        }

        public String getIsTC() {
            return isTC;
        }

        public void setIsTC(String isTC) {
            this.isTC = isTC;
        }

        public String getPYM() {
            return pYM;
        }

        public void setPYM(String pYM) {
            this.pYM = pYM;
        }

        public String getProduceID() {
            return produceID;
        }

        public void setProduceID(String produceID) {
            this.produceID = produceID;
        }

        public String getIsPlayVoice() {
            return isPlayVoice;
        }

        public void setIsPlayVoice(String isPlayVoice) {
            this.isPlayVoice = isPlayVoice;
        }

        public String getIsPrint() {
            return isPrint;
        }

        public void setIsPrint(String isPrint) {
            this.isPrint = isPrint;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        public String getISFT() {
            return iSFT;
        }

        public void setISFT(String iSFT) {
            this.iSFT = iSFT;
        }

        public String getIsDownEqu() {
            return isDownEqu;
        }

        public void setIsDownEqu(String isDownEqu) {
            this.isDownEqu = isDownEqu;
        }

        public String getIsStop() {
            return isStop;
        }

        public void setIsStop(String isStop) {
            this.isStop = isStop;
        }

        public String getPriorLevel() {
            return priorLevel;
        }

        public void setPriorLevel(String priorLevel) {
            this.priorLevel = priorLevel;
        }

        public String getIsLZDP() {
            return isLZDP;
        }

        public void setIsLZDP(String isLZDP) {
            this.isLZDP = isLZDP;
        }

        public String getStoreCount() {
            return storeCount;
        }

        public void setStoreCount(String storeCount) {
            this.storeCount = storeCount;
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

        public String getItemTypeName() {
            return itemTypeName;
        }

        public void setItemTypeName(String itemTypeName) {
            this.itemTypeName = itemTypeName;
        }

        public String getProduceName() {
            return produceName;
        }

        public void setProduceName(String produceName) {
            this.produceName = produceName;
        }

        public String getItemKindID() {
            return itemKindID;
        }

        public void setItemKindID(String itemKindID) {
            this.itemKindID = itemKindID;
        }

        public String getItemKindName() {
            return itemKindName;
        }

        public void setItemKindName(String itemKindName) {
            this.itemKindName = itemKindName;
        }


        @Override
        public String toString() {
            return "DataBean{" +
                    "itemID='" + itemID + '\'' +
                    ", itemTypeID='" + itemTypeID + '\'' +
                    ", itemCode='" + itemCode + '\'' +
                    ", itemName='" + itemName + '\'' +
                    ", lPrice='" + lPrice + '\'' +
                    ", lTimeLong='" + lTimeLong + '\'' +
                    ", dPrice='" + dPrice + '\'' +
                    ", dTimeLong='" + dTimeLong + '\'' +
                    ", jPrice='" + jPrice + '\'' +
                    ", jTimeLong='" + jTimeLong + '\'' +
                    ", cPrice='" + cPrice + '\'' +
                    ", cTimeLong='" + cTimeLong + '\'' +
                    ", xPrice='" + xPrice + '\'' +
                    ", xTimeLong='" + xTimeLong + '\'' +
                    ", saleCount='" + saleCount + '\'' +
                    ", wagesCount='" + wagesCount + '\'' +
                    ", isCanDiscount='" + isCanDiscount + '\'' +
                    ", isOnlyCash='" + isOnlyCash + '\'' +
                    ", isTC='" + isTC + '\'' +
                    ", pYM='" + pYM + '\'' +
                    ", produceID='" + produceID + '\'' +
                    ", isPlayVoice='" + isPlayVoice + '\'' +
                    ", isPrint='" + isPrint + '\'' +
                    ", units='" + units + '\'' +
                    ", iSFT='" + iSFT + '\'' +
                    ", isDownEqu='" + isDownEqu + '\'' +
                    ", isStop='" + isStop + '\'' +
                    ", priorLevel='" + priorLevel + '\'' +
                    ", isLZDP='" + isLZDP + '\'' +
                    ", storeCount='" + storeCount + '\'' +
                    ", sort='" + sort + '\'' +
                    ", orgID='" + orgID + '\'' +
                    ", itemTypeName='" + itemTypeName + '\'' +
                    ", produceName='" + produceName + '\'' +
                    ", itemKindID='" + itemKindID + '\'' +
                    ", itemKindName='" + itemKindName + '\'' +
                    '}';
        }
    }
}
