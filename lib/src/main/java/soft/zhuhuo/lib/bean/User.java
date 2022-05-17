package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class User extends BaseObResult {



    @SerializedName("ClassTecCount")
    private String classTecCount;
    @SerializedName("RoomCount")
    private String roomCount;
    @SerializedName("PostName")
    private String postName;


    @SerializedName("OrgID")
    private String orgID;
    @SerializedName("OrgName")
    private String orgName;
    @SerializedName("Btime")
    private String btime;
    @SerializedName("ETime")
    private String eTime;
    @SerializedName("PersonID")
    private String personID;
    @SerializedName("PeronCode")
    private String peronCode;
    @SerializedName("PersonName")
    private String personName;
    @SerializedName("LimitFavourable")
    private String limitFavourable;
    @SerializedName("LimitDiscount")
    private String limitDiscount;
    @SerializedName("RoleLevel")
    private String roleLevel;
    @SerializedName("IsChain")
    private String isChain;
    @SerializedName("ISAggregatePayment")
    private String iSAggregatePayment;
    @SerializedName("SysVerType")
    private String sysVerType;
    @SerializedName("RoleLimit")
    private List<RoleLimitBean> roleLimit;

    public String getClassTecCount() {
        return classTecCount;
    }

    public void setClassTecCount(String classTecCount) {
        this.classTecCount = classTecCount;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getETime() {
        return eTime;
    }

    public void setETime(String eTime) {
        this.eTime = eTime;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPeronCode() {
        return peronCode;
    }

    public void setPeronCode(String peronCode) {
        this.peronCode = peronCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getIsChain() {
        return isChain;
    }

    public void setIsChain(String isChain) {
        this.isChain = isChain;
    }

    public String getISAggregatePayment() {
        return iSAggregatePayment;
    }

    public void setISAggregatePayment(String iSAggregatePayment) {
        this.iSAggregatePayment = iSAggregatePayment;
    }

    public String getSysVerType() {
        return sysVerType;
    }

    public void setSysVerType(String sysVerType) {
        this.sysVerType = sysVerType;
    }

    public List<RoleLimitBean> getRoleLimit() {
        return roleLimit;
    }

    public void setRoleLimit(List<RoleLimitBean> roleLimit) {
        this.roleLimit = roleLimit;
    }

    public static class RoleLimitBean {
        @SerializedName("RoleLimitID")
        private String roleLimitID;
        @SerializedName("RoleID")
        private String roleID;
        @SerializedName("MenuID")
        private String menuID;
        @SerializedName("OrgID")
        private String orgID;
        @SerializedName("MenuName")
        private String menuName;
        @SerializedName("FatherCode")
        private String fatherCode;

        public String getRoleLimitID() {
            return roleLimitID;
        }

        public void setRoleLimitID(String roleLimitID) {
            this.roleLimitID = roleLimitID;
        }

        public String getRoleID() {
            return roleID;
        }

        public void setRoleID(String roleID) {
            this.roleID = roleID;
        }

        public String getMenuID() {
            return menuID;
        }

        public void setMenuID(String menuID) {
            this.menuID = menuID;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public String getFatherCode() {
            return fatherCode;
        }

        public void setFatherCode(String fatherCode) {
            this.fatherCode = fatherCode;
        }


    }

    @Override
    public String toString() {
        return "User{" +
                "orgID='" + orgID + '\'' +
                ", orgName='" + orgName + '\'' +
                ", btime='" + btime + '\'' +
                ", eTime='" + eTime + '\'' +
                ", personID='" + personID + '\'' +
                ", peronCode='" + peronCode + '\'' +
                ", personName='" + personName + '\'' +
                ", limitFavourable='" + limitFavourable + '\'' +
                ", limitDiscount='" + limitDiscount + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", isChain='" + isChain + '\'' +
                ", iSAggregatePayment='" + iSAggregatePayment + '\'' +
                ", sysVerType='" + sysVerType + '\'' +
                ", roleLimit=" + roleLimit +
                '}';
    }
}
