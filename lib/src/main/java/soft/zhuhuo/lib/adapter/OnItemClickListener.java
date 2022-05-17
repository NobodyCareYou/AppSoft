package soft.zhuhuo.lib.adapter;


import android.view.View;

public interface OnItemClickListener<T> {

    /**
     * Item 点击事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    void onItemClick(T data, int position);

    void onItemClick(View v, int position);

    void onItemClick(View v, T data, int position);

    /**
     * Item 长按事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    boolean onItemLongClick(T data, int position);

    boolean onItemLongClick(View v, T data, int position);

    void onItemClick(Object v1, Object position);
}
