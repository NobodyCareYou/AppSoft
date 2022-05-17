package soft.zhuhuo.lib.bean;

import java.util.ArrayList;
import java.util.List;

import soft.zhuhuo.lib.R;
import soft.zhuhuo.lib.constant.RoomState;

public class TechnicianState {
    public String StateId;
    public String StateName;

    public TechnicianState(String stateId, String stateName) {
        StateId = stateId;
        StateName = stateName;
    }
    public static List<TechnicianState> getTechnicianState(){
        List<TechnicianState> tmp = new ArrayList<>();
        tmp.add(new TechnicianState("1","空闲"));
        tmp.add(new TechnicianState("2","上钟"));
        tmp.add(new TechnicianState("3","圈牌"));
        tmp.add(new TechnicianState("4","预约"));
        tmp.add(new TechnicianState("5","下班"));
        tmp.add(new TechnicianState("6","休假"));
        tmp.add(new TechnicianState("7","待钟"));
        return tmp;
    }



    public static String getName(String StateId) {
        String str = "空闲";
        switch (StateId) {
            case "1":
                str = "空闲";
                break;
            case "2":
                str = "上钟";
                break;
            case "3":
                str = "圈牌";
                break;
            case "4":
                str = "预约";
                break;
            case "5":
                str = "下班";
                break;
            case "6":
                str = "休假";
                break;
            case "7":
                str = "待钟";
                break;
        }
        return str;
    }

    public static int  getTechnicianStateBg (String StateId){
        int res = R.drawable.technician_state_1;
        switch (StateId) {
            case "1":
                res = R.drawable.technician_state_1;
                break;
            case "2":
                res = R.drawable.technician_state_2;
                break;
            case "3":
                res = R.drawable.technician_state_3;
                break;
            case "4":
                res = R.drawable.technician_state_4;
                break;
            case "5":
                res = R.drawable.technician_state_5;
                break;
            case "6":
                res = R.drawable.technician_state_6;
                break;
            case "7":
                res = R.drawable.technician_state_7;
                break;
        }
        return res;
    }
}
