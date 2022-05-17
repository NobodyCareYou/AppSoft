package soft.zhuhuo.lib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.Nullable;

import soft.zhuhuo.lib.R;


public class UnderLineTextView extends androidx.appcompat.widget.AppCompatTextView {
    private final Paint mPaint = new Paint();
    //下划线高度
    private float defaultUnderLineHeight = 2;
    //距离边上的宽度
    private float defaultInsideWidth = 10;
    //默认下划线的颜色
    private int defaultUnderLineColor = Color.BLACK;


    public UnderLineTextView(Context context) {
        this(context, null);
    }

    public UnderLineTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UnderLineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        @SuppressLint({"CustomViewStyleable", "Recycle"}) TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.underLineTextStyle);
        defaultInsideWidth = array.getDimension(R.styleable.underLineTextStyle_underLineInsideWidth, 2);
        defaultUnderLineHeight = array.getDimension(R.styleable.underLineTextStyle_underLineHeight, 2);
        defaultUnderLineColor = array.getColor(R.styleable.underLineTextStyle_underLineColor, Color.BLACK);
        Resources r = getResources();
        defaultInsideWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, defaultInsideWidth, r.getDisplayMetrics());
        defaultUnderLineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, defaultUnderLineHeight, r.getDisplayMetrics());
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, (int) (bottom + 2*defaultUnderLineHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(defaultUnderLineColor);
        canvas.drawRect(defaultInsideWidth, getHeight() - defaultUnderLineHeight, getWidth() - defaultInsideWidth, getHeight() + 2*defaultUnderLineHeight, mPaint);
    }


}
