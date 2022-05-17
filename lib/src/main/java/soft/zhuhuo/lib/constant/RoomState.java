package soft.zhuhuo.lib.constant;

import java.util.ArrayList;
import java.util.List;

import soft.zhuhuo.lib.R;

public class RoomState {

//    房间状态ID 1空2休息3预约4上钟5脏6待结账7维修8进客

    public String StateId;
    public String StateName;

    public RoomState(String stateId, String stateName) {
        StateId = stateId;
        StateName = stateName;
    }

    public static List<RoomState> getRoomState(){
        List<RoomState> tmp = new ArrayList<>();
        tmp.add(new RoomState("1","空闲"));
        tmp.add(new RoomState("2","休息"));
        tmp.add(new RoomState("3","预约"));
        tmp.add(new RoomState("4","上钟"));
        tmp.add(new RoomState("5","脏房"));
        tmp.add(new RoomState("6","结账"));
        tmp.add(new RoomState("7","维修"));
        tmp.add(new RoomState("8","进客"));
        return tmp;
    }

    public static String getName(String StateId) {
        String str = "空闲";
        switch (StateId) {
            case "1":
                str = "空闲";
                break;
            case "2":
                str = "休息";
                break;
            case "3":
                str = "预约";
                break;
            case "4":
                str = "上钟";
                break;
            case "5":
                str = "脏房";
                break;
            case "6":
                str = "结账";
                break;
            case "7":
                str = "维修";
                break;
            case "8":
                str = "进客";
                break;
        }
        return str;
    }

    public static int getRoomStateBg(String StateId) {
        int res = R.drawable.room_state_1;
        switch (StateId) {
            case "1":
                res = R.drawable.room_state_1;
                break;
            case "2":
                res = R.drawable.room_state_2;
                break;
            case "3":
                res = R.drawable.room_state_3;
                break;
            case "4":
                res = R.drawable.room_state_4;
                break;
            case "5":
                res = R.drawable.room_state_5;
                break;
            case "6":
                res = R.drawable.room_state_6;
                break;
            case "7":
                res = R.drawable.room_state_7;
                break;
            case "8":
                res = R.drawable.room_state_8;
                break;
        }
        return res;
    }
}
