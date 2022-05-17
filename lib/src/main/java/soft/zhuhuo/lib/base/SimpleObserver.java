package soft.zhuhuo.lib.base;

import android.util.Log;

import androidx.lifecycle.Observer;

public abstract class SimpleObserver<T extends BaseObResult> implements Observer<T> {

    private static final String TAG = "SimpleObserver";

    public abstract void success(T t);

    public abstract void fail(String msg);

    public abstract void isShowLoading(boolean isShow);

    @Override
    public void onChanged(T t) {
//        switch (t.getLoadState()) {
//            case START_REQUEST:
//                Log.d(TAG, "START_REQUEST: ");
//                isShowLoading(true);
//                break;
//            case END_REQUEST:
//                Log.d(TAG, "END_REQUEST: ");
//                isShowLoading(false);
//                break;
//            case LOAD_SUCCESS:
//                isShowLoading(false);
//                Log.d(TAG, "LOAD_SUCCESS: ");
//                success(t);
//                break;
//            case LOAD_FAIL:
//                Log.d(TAG, "LOAD_FAIL: ");
//                isShowLoading(false);
//                fail(t.getMsgInfo());
//                break;
//        }
    }
}
