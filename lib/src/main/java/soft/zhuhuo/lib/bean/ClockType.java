package soft.zhuhuo.lib.bean;

public class ClockType extends SelectAble{
    public int clockType;
    public String clockTypeStr;

    public ClockType(int clockType, String clockTypeStr) {
        this.clockType = clockType;
        this.clockTypeStr = clockTypeStr;
    }
}
