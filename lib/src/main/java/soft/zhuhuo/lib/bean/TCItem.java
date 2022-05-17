package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class TCItem extends BaseObResult {

    @SerializedName("Data")
    private List<DataDTO> data;


    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("TecBindItemID")
        private String tecBindItemID;
        @SerializedName("TecID")
        private String tecID;
        @SerializedName("TecCode")
        private String tecCode;
        @SerializedName("ItemID")
        private String itemID;
        @SerializedName("BindTypeID")
        private String bindTypeID;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("ItemID_1")
        private String itemid1;
        @SerializedName("ItemTypeID")
        private String itemTypeID;
        @SerializedName("ItemCode")
        private String itemCode;
        @SerializedName("ItemName")
        private String itemName;
        @SerializedName("LPrice")
        private String lPrice;
        @SerializedName("LTimeLong")
        private String lTimeLong;
        @SerializedName("DPrice")
        private String dPrice;
        @SerializedName("DTimeLong")
        private String dTimeLong;
        @SerializedName("JPrice")
        private String jPrice;
        @SerializedName("JTimeLong")
        private String jTimeLong;
        @SerializedName("CPrice")
        private String cPrice;
        @SerializedName("CTimeLong")
        private String cTimeLong;
        @SerializedName("XPrice")
        private String xPrice;
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
        private String pym;
        @SerializedName("ProduceID")
        private String produceID;
        @SerializedName("IsPlayVoice")
        private String isPlayVoice;
        @SerializedName("IsPrint")
        private String isPrint;
        @SerializedName("Units")
        private String units;
        @SerializedName("ISFT")
        private String isft;
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
        @SerializedName("OrgID_1")
        private String orgid1;
        @SerializedName("ItemName_1")
        private String itemname1;

        public String getTecBindItemID() {
            return tecBindItemID;
        }

        public void setTecBindItemID(String tecBindItemID) {
            this.tecBindItemID = tecBindItemID;
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

        public String getItemID() {
            return itemID;
        }

        public void setItemID(String itemID) {
            this.itemID = itemID;
        }

        public String getBindTypeID() {
            return bindTypeID;
        }

        public void setBindTypeID(String bindTypeID) {
            this.bindTypeID = bindTypeID;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getItemid1() {
            return itemid1;
        }

        public void setItemid1(String itemid1) {
            this.itemid1 = itemid1;
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

        public String getLPrice() {
            return lPrice;
        }

        public void setLPrice(String lPrice) {
            this.lPrice = lPrice;
        }

        public String getLTimeLong() {
            return lTimeLong;
        }

        public void setLTimeLong(String lTimeLong) {
            this.lTimeLong = lTimeLong;
        }

        public String getDPrice() {
            return dPrice;
        }

        public void setDPrice(String dPrice) {
            this.dPrice = dPrice;
        }

        public String getDTimeLong() {
            return dTimeLong;
        }

        public void setDTimeLong(String dTimeLong) {
            this.dTimeLong = dTimeLong;
        }

        public String getJPrice() {
            return jPrice;
        }

        public void setJPrice(String jPrice) {
            this.jPrice = jPrice;
        }

        public String getJTimeLong() {
            return jTimeLong;
        }

        public void setJTimeLong(String jTimeLong) {
            this.jTimeLong = jTimeLong;
        }

        public String getCPrice() {
            return cPrice;
        }

        public void setCPrice(String cPrice) {
            this.cPrice = cPrice;
        }

        public String getCTimeLong() {
            return cTimeLong;
        }

        public void setCTimeLong(String cTimeLong) {
            this.cTimeLong = cTimeLong;
        }

        public String getXPrice() {
            return xPrice;
        }

        public void setXPrice(String xPrice) {
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

        public String getPym() {
            return pym;
        }

        public void setPym(String pym) {
            this.pym = pym;
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

        public String getIsft() {
            return isft;
        }

        public void setIsft(String isft) {
            this.isft = isft;
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

        public String getOrgid1() {
            return orgid1;
        }

        public void setOrgid1(String orgid1) {
            this.orgid1 = orgid1;
        }

        public String getItemname1() {
            return itemname1;
        }

        public void setItemname1(String itemname1) {
            this.itemname1 = itemname1;
        }
    }
}
