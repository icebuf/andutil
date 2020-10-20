package com.icebuf.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.icebuf.util.internal.AppActionBarWrapper;
import com.icebuf.util.internal.SupportActionBarWrapper;

import java.lang.reflect.Field;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/8/24
 * E-mail：bflyff@hotmail.com
 */
public class ActionBarUtil {

    private static final String TAG = ActionBarUtil.class.getSimpleName();

    public static final int KEY_ACTION_BAR_LISTENER = -10001;

    /**
     * 获取一个兼容App和Androidx的ActionBar
     * @param activity the activity
     * @return 一个兼容actionBar的实例
     */
    public static ActionBarCompat with(Activity activity) {
        if(activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar actionBar = appCompatActivity.getSupportActionBar();
            if(actionBar != null) {
                return new SupportActionBarWrapper(actionBar);
            }
        } else {
            android.app.ActionBar actionBar = activity.getActionBar();
            if(actionBar != null) {
                return new AppActionBarWrapper(actionBar);
            }
        }
        throw new RuntimeException("un support actionBar for " + activity.getClass().getName());
    }

    /**
     * 将actionBar的title设为水平居中
     * @param activity the activity
     */
    public static void setTitleInCenter(Activity activity, boolean enable) {
        View decorView = activity.getWindow().getDecorView();
        Toolbar actionBar = decorView.findViewById(R.id.action_bar);
        if(actionBar == null) {
            Log.w(TAG, "The activity of " + activity.getClass().getSimpleName()
                    + " is not support action bar!");
            return;
        }
        TextView titleView = getFieldValue(actionBar, "mTitleTextView");
        if(titleView == null) {
            Log.w(TAG, "The action bar of " + activity.getClass().getSimpleName()
                    + " was not found title text view!");
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener listener;
        Object obj = titleView.getTag(KEY_ACTION_BAR_LISTENER);
        if(obj instanceof ViewTreeObserver.OnGlobalLayoutListener) {
            listener = (ViewTreeObserver.OnGlobalLayoutListener) obj;
        } else {
            listener = new ViewTreeObserver.OnGlobalLayoutListener() {

                @Override
                public void onGlobalLayout() {
                    int centerX = actionBar.getWidth() / 2;
                    int titleCenterX = (titleView.getLeft() + titleView.getRight()) / 2;
                    //Log.e("TAG", "text = " + titleView.getText()
                    //       + " centerX = " + centerX
                    //       + " titleCenterX = " + titleCenterX
                    //       + " translationX = " + titleView.getTranslationX());
                    if (centerX != titleCenterX) {
                        titleView.setTranslationX(centerX - titleCenterX);
                    } else {
                        titleView.setTranslationX(0f);
                    }
                }
            };
        }
        if(enable) {
            titleView.getViewTreeObserver().addOnGlobalLayoutListener(listener);
            titleView.setTag(KEY_ACTION_BAR_LISTENER, listener);
            activity.getApplication().registerActivityLifecycleCallbacks(new LifecycleHandler(activity));
            Log.d(TAG, "add listener of title in center!");
        } else {
            titleView.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
            titleView.setTag(KEY_ACTION_BAR_LISTENER, null);
            Log.d(TAG, "remove listener of title in center!");
        }
    }

    /**
     * 自动解除居中监听的绑定
     */
    static class LifecycleHandler implements
            Application.ActivityLifecycleCallbacks {

        private Activity mActivity;

        public LifecycleHandler(Activity activity) {
            mActivity = activity;
        }

        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {
            if(mActivity == activity) {
                setTitleInCenter(activity, false);
                mActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
                mActivity = null;
            }
        }
    }

    private static <T> T getFieldValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            if(!field.isAccessible()) {
                field.setAccessible(true);
            }
            return (T) field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
