package soft.zhuhuo.module_home.adapter;

import android.widget.TextView;

import java.util.List;

public class SPItemAdapter extends BaseArrayAdapter<String> {



    @Override
    public void bindTextViewColoum(TextView textView, String s) {
        textView.setText(s);
    }
}
