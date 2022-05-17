package soft.zhuhuo.lib;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.adapter.PickerAdapter;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.utils.DisplayUtil;

/**
 * 筛选弹窗
 */
public class PickerPopupWindow extends PopupWindow {

    private Context context;
    private List<String> data;
    private String defaultText;
    private int background;
    private OnItemClickListener onItemClickListener;
    private int width;


    private PickerPopupWindow(Context context, Build build) {
        super(context);

        this.context = context;
        width = build.width;
        int height = build.height;
        this.data = build.data;
        this.defaultText = build.defaultText;
        this.onItemClickListener = build.onItemClickListener;
        this.background = build.background;
        init(context, width, height);


    }

    private int popupHeight;
    private int popupWidth;

    private void init(Context context, int width, int height) {
        RecyclerView v = (RecyclerView) View.inflate(context, R.layout.pop_picker, null);
        v.setLayoutManager(new LinearLayoutManager(context));
        PickerAdapter adapter = new PickerAdapter(context, data, defaultText, width, height, background);
        adapter.setOnItemClickListener(new SimpleOnItemClickAdapter() {
            @Override
            public void onItemClick(View v, int position) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, position);
                    dismiss();
                }
            }

            @Override
            public void onItemClick(Object v1, Object position) {

            }
        });

        v.setAdapter(adapter);
        setContentView(v);
        setOutsideTouchable(true);
        setBackgroundDrawable(null);
        setOnDismissListener(() -> alphaBackground(1));

        v.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupHeight = v.getMeasuredHeight();
        popupWidth = v.getMeasuredWidth();

    }

    @Override
    public void showAsDropDown(View anchor) {
        alphaBackground(0.65f);
        super.showAsDropDown(anchor);
    }

    public void show(View parent) {
        int[] location = new int[2];
        parent.getLocationOnScreen(location);
        super.showAtLocation(parent, Gravity.NO_GRAVITY, (location[0] + parent.getWidth() / 2) - width / 2, location[1] - popupHeight - DisplayUtil.dip2px(context, 5f));
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        int[] location = new int[2];
        parent.getLocationOnScreen(location);
        super.showAtLocation(parent, Gravity.NO_GRAVITY, (location[0] + parent.getWidth() / 2) - width / 2, location[1] - popupHeight - DisplayUtil.dip2px(context, 5f));

    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        alphaBackground(0.65f);
        super.showAsDropDown(anchor, xoff, yoff);
    }

    public void alphaBackground(float alpha) {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = alpha;
        ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ((Activity) context).getWindow().setAttributes(lp);
    }

    public static class Build {
        private int width;
        private int height;
        private List<String> data;
        private String defaultText;
        private int background;
        private OnItemClickListener onItemClickListener;

        public Build setWidth(int width) {
            this.width = width;
            return this;
        }

        public Build setHeight(int height) {
            this.height = height;
            return this;
        }

        public Build setData(List<String> data) {
            this.data = data;
            return this;
        }

        public Build setDefaultText(String defaultText) {
            this.defaultText = defaultText;
            return this;
        }

        public Build setBackground(int background) {
            this.background = background;
            return this;
        }

        public Build setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public PickerPopupWindow build(Context context) {
            return new PickerPopupWindow(context, this);
        }
    }
}
