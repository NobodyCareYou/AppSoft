package soft.zhuhuo.lib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import soft.zhuhuo.lib.base.BaseObResult;

public class UnionRoomInfo extends BaseObResult {
    public  boolean isSelected  = false;
    @SerializedName("LinkedRoom")
    private List<LinkedRoomDTO> linkedRoom;
    @SerializedName("NoLinkedRoom")
    private List<NoLinkedRoomDTO> noLinkedRoom;

    public List<LinkedRoomDTO> getLinkedRoom() {
        return linkedRoom;
    }

    public void setLinkedRoom(List<LinkedRoomDTO> linkedRoom) {
        this.linkedRoom = linkedRoom;
    }

    public List<NoLinkedRoomDTO> getNoLinkedRoom() {
        return noLinkedRoom;
    }

    public void setNoLinkedRoom(List<NoLinkedRoomDTO> noLinkedRoom) {
        this.noLinkedRoom = noLinkedRoom;
    }

    public static class LinkedRoomDTO extends SelectAble {
        @SerializedName("LinkID")
        private String linkID;
        @SerializedName("LinkRoom")
        private String linkRoom;
        @SerializedName("LinkCount")
        private String linkCount;

        public String getLinkID() {
            return linkID;
        }

        public void setLinkID(String linkID) {
            this.linkID = linkID;
        }

        public String getLinkRoom() {
            return linkRoom;
        }

        public void setLinkRoom(String linkRoom) {
            this.linkRoom = linkRoom;
        }

        public String getLinkCount() {
            return linkCount;
        }

        public void setLinkCount(String linkCount) {
            this.linkCount = linkCount;
        }
    }

    public static class NoLinkedRoomDTO extends SelectAble{
        @SerializedName("LinkID")
        private String linkID;
        @SerializedName("LinkRoom")
        private String linkRoom;
        @SerializedName("LinkCount")
        private String linkCount;
        @SerializedName("RoomTypeName")
        private String roomTypeName;

        public String getLinkID() {
            return linkID;
        }

        public void setLinkID(String linkID) {
            this.linkID = linkID;
        }

        public String getLinkRoom() {
            return linkRoom;
        }

        public void setLinkRoom(String linkRoom) {
            this.linkRoom = linkRoom;
        }

        public String getLinkCount() {
            return linkCount;
        }

        public void setLinkCount(String linkCount) {
            this.linkCount = linkCount;
        }

        public String getRoomTypeName() {
            return roomTypeName;
        }

        public void setRoomTypeName(String roomTypeName) {
            this.roomTypeName = roomTypeName;
        }
    }
}
