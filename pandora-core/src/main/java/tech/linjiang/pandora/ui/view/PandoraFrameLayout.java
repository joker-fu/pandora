package tech.linjiang.pandora.ui.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PandoraFrameLayout extends FrameLayout {

    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;

    public PandoraFrameLayout(@NonNull Context context) {
        super(context);
    }

    public PandoraFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PandoraFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PandoraFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mOnInterceptTouchEventListener != null && ev.getAction() == MotionEvent.ACTION_DOWN) {
            mOnInterceptTouchEventListener.onTouch();
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener listener) {
        mOnInterceptTouchEventListener = listener;
    }

    public interface OnInterceptTouchEventListener {
        void onTouch();
    }

}
