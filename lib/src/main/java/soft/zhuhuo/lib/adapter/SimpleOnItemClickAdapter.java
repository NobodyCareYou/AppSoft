package soft.zhuhuo.lib.adapter;

import android.view.View;

public  abstract  class SimpleOnItemClickAdapter<T> implements OnItemClickListener<T> {


    @Override
    public void onItemClick(View v, T data, int position) {

    }

    @Override
    public void onItemClick(T data, int position) {

    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public boolean onItemLongClick(T data, int position) {
        return false;
    }

    @Override
    public boolean onItemLongClick(View v, T data, int position) {
        return false;
    }

    @Override
    public void onItemClick(Object v1, Object position) {

    }
}
