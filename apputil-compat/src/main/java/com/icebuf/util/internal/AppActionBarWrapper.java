package com.icebuf.util.internal;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.icebuf.util.ActionBarCompat;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public class AppActionBarWrapper implements ActionBarCompat{

    private final ActionBar mActionBar;

    public AppActionBarWrapper(android.app.ActionBar actionBar) {
        this.mActionBar = actionBar;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public ActionBarCompat setHomeAsUpIndicator(Drawable drawable) {
        mActionBar.setHomeAsUpIndicator(drawable);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public ActionBarCompat setHomeAsUpIndicator(int resId) {
        mActionBar.setHomeAsUpIndicator(resId);
        return this;
    }

    @Override
    public ActionBarCompat setHomeActionContentDescription(@Nullable CharSequence description) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            mActionBar.setHomeActionContentDescription(description);
        }
        return this;
    }

    @Override
    public ActionBarCompat setHomeActionContentDescription(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            mActionBar.setHomeActionContentDescription(resId);
        }
        return this;
    }

    @Override
    public ActionBarCompat setHideOnContentScrollEnabled(boolean hideOnContentScroll) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionBar.setHideOnContentScrollEnabled(hideOnContentScroll);
        }
        return this;
    }

    @Override
    public boolean isHideOnContentScrollEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mActionBar.isHideOnContentScrollEnabled();
        }
        return false;
    }

    @Override
    public int getHideOffset() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mActionBar.getHideOffset();
        }
        return 0;
    }

    @Override
    public ActionBarCompat setHideOffset(int offset) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionBar.setHideOffset(offset);
        }
        return this;
    }

    @Override
    public ActionBarCompat setElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionBar.setElevation(elevation);
        }
        return this;
    }

    @Override
    public float getElevation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mActionBar.getElevation();
        }
        return 0f;
    }

    @Override
    public Object getActionBar() {
        return mActionBar;
    }

    @Override
    public ActionBarCompat setDisplayShowCustomEnabled(boolean enable) {
        mActionBar.setDisplayShowCustomEnabled(enable);
        return this;
    }

    @Override
    public ActionBarCompat setCustomView(View view) {
        mActionBar.setCustomView(view);
        return this;
    }

    @Override
    public ActionBarCompat setCustomView(View view, ActionBarCompat.LayoutParams layoutParams) {
        mActionBar.setCustomView(view, layoutParams.getParams());
        return this;
    }

    @Override
    public ActionBarCompat setCustomView(int id) {
        mActionBar.setCustomView(id);
        return this;
    }

    @Override
    public ActionBarCompat setIcon(int resId) {
        mActionBar.setIcon(resId);
        return this;
    }

    @Override
    public ActionBarCompat setIcon(Drawable icon) {
        mActionBar.setIcon(icon);
        return this;
    }

    @Override
    public ActionBarCompat setLogo(int resId) {
        mActionBar.setLogo(resId);
        return this;
    }

    @Override
    public ActionBarCompat setLogo(Drawable logo) {
        mActionBar.setLogo(logo);
        return this;
    }

    @Override
    public ActionBarCompat setTitle(CharSequence title) {
        mActionBar.setTitle(title);
        return this;
    }

    @Override
    public ActionBarCompat setTitle(int resId) {
        mActionBar.setTitle(resId);
        return this;
    }

    @Override
    public ActionBarCompat setSubtitle(CharSequence subtitle) {
        mActionBar.setSubtitle(subtitle);
        return this;
    }

    @Override
    public ActionBarCompat setSubtitle(int resId) {
        mActionBar.setSubtitle(resId);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayOptions(int options) {
        mActionBar.setDisplayOptions(options);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayOptions(int options, int mask) {
        mActionBar.setDisplayOptions(options, mask);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayUseLogoEnabled(boolean useLogo) {
        mActionBar.setDisplayUseLogoEnabled(useLogo);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayShowHomeEnabled(boolean showHome) {
        mActionBar.setDisplayShowHomeEnabled(showHome);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        mActionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        return this;
    }

    @Override
    public ActionBarCompat setDisplayShowTitleEnabled(boolean showTitle) {
        mActionBar.setDisplayShowTitleEnabled(showTitle);
        return this;
    }

    @Override
    public ActionBarCompat setBackgroundDrawable(Drawable drawable) {
        mActionBar.setBackgroundDrawable(drawable);
        return this;
    }

    @Override
    public ActionBarCompat setStackedBackgroundDrawable(Drawable d) {
        mActionBar.setStackedBackgroundDrawable(d);
        return this;
    }

    @Override
    public ActionBarCompat setSplitBackgroundDrawable(Drawable d) {
        mActionBar.setSplitBackgroundDrawable(d);
        return this;
    }

    @Override
    public View getCustomView() {
        return mActionBar.getCustomView();
    }

    @Override
    public CharSequence getTitle() {
        return mActionBar.getTitle();
    }

    @Override
    public CharSequence getSubtitle() {
        return mActionBar.getSubtitle();
    }

    @Override
    public int getDisplayOptions() {
        return mActionBar.getDisplayOptions();
    }

    @Override
    public int getHeight() {
        return mActionBar.getHeight();
    }

    @Override
    public ActionBarCompat show() {
        mActionBar.show();
        return this;
    }

    @Override
    public ActionBarCompat hide() {
        mActionBar.hide();
        return this;
    }

    @Override
    public boolean isShowing() {
        return mActionBar.isShowing();
    }

    @Override
    public ActionBarCompat addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mActionBar.addOnMenuVisibilityListener(listener);
        return this;
    }

    @Override
    public ActionBarCompat removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mActionBar.removeOnMenuVisibilityListener(listener);
        return this;
    }

    @Override
    public ActionBarCompat setHomeButtonEnabled(boolean enabled) {
        mActionBar.setHomeButtonEnabled(enabled);
        return this;
    }

    @Override
    public Context getThemedContext() {
        return mActionBar.getThemedContext();
    }

}
