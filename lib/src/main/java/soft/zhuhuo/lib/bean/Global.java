package soft.zhuhuo.lib.bean;

import androidx.lifecycle.MutableLiveData;

public class Global {

    private Global() {
    }

    private static Global instance;

    public static Global getInstance() {
        if (instance == null) {
            synchronized (Global.class) {
                if (instance == null) {
                    instance = new Global();
                }
            }
        }
        return instance;
    }

    private final MutableLiveData<FloorInfo> floorInfo = new MutableLiveData<>();
    private final MutableLiveData<RoomTechnicianInfo> roomTechnicianInfo = new MutableLiveData<>();
    private final MutableLiveData<RoomType> roomTypeInfo = new MutableLiveData<>();
    private final MutableLiveData<TechnicianType> technicianTypeInfo = new MutableLiveData<>();
    private final MutableLiveData<ItemInfo> itemInfo = new MutableLiveData<>();

    public void setTechnicianTypeInfo(TechnicianType info) {
        technicianTypeInfo.setValue(info);
    }

    public MutableLiveData<TechnicianType> getTechnicianTypeInfo() {
        return technicianTypeInfo;
    }

    public void setRoomTypeInfo(RoomType info) {
        roomTypeInfo.setValue(info);
    }

    public MutableLiveData<RoomType> getRoomTypeInfo() {
        return roomTypeInfo;
    }

    public void setFloorInfo(FloorInfo info) {
        floorInfo.setValue(info);
    }

    public MutableLiveData<FloorInfo> getFloorInfo() {
        return floorInfo;
    }

    public MutableLiveData<RoomTechnicianInfo> getRoomTechnicianInfo() {
        return roomTechnicianInfo;
    }

    public void setRoomTechnicianInfo(RoomTechnicianInfo response) {
        this.roomTechnicianInfo.setValue(response);
    }

    public void setItemInfo(ItemInfo response) {
        this.itemInfo.setValue(response);
    }

    public MutableLiveData<ItemInfo> getItemInfo() {
        return itemInfo;
    }
}
