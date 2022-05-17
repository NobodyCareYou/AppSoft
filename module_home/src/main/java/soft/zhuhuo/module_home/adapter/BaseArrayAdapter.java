package soft.zhuhuo.module_home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


import java.util.List;

import soft.zhuhuo.module_home.R;

public abstract class BaseArrayAdapter<T> extends BaseAdapter implements SpinnerAdapter {

    private List<T> data;

    public BaseArrayAdapter(List<T> data) {
        this.data = data;
    }

    public BaseArrayAdapter() {
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_spinner, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.tvSpinner);
//        int blue = ContextCompat.getColor(viewGroup.getContext(), R.color.blue);
//        int black = ContextCompat.getColor(viewGroup.getContext(), R.color.black);
//        textView.setTextColor(data.get(i).isSelected ? blue : black);
        bindTextViewColoum(textView, data.get(i));
        return view;
    }



    public abstract void bindTextViewColoum(TextView textView, T t);


}
