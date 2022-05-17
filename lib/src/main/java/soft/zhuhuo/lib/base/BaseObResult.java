package soft.zhuhuo.lib.base;

public class BaseObResult {

    private String MsgID;
    private String MsgInfo;

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getMsgInfo() {
        return MsgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        MsgInfo = msgInfo;
    }


    @Override
    public String toString() {
        return "BaseObResult{" +
                "MsgID='" + MsgID + '\'' +
                ", MsgInfo='" + MsgInfo + '\'' +
                '}';
    }
}
