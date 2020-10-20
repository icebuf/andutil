package com.icebuf.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public interface ActionBarCompat {

    ActionBarCompat setCustomView(View view);

    ActionBarCompat setCustomView(View view, LayoutParams layoutParams);

    ActionBarCompat setCustomView(int id);

    ActionBarCompat setIcon(@DrawableRes int resId);

    ActionBarCompat setIcon(Drawable icon);

    ActionBarCompat setLogo(@DrawableRes int resId);

    ActionBarCompat setLogo(Drawable logo);

    ActionBarCompat setTitle(CharSequence title);

    ActionBarCompat setTitle(@StringRes int resId);

    ActionBarCompat setSubtitle(CharSequence subtitle);

    ActionBarCompat setSubtitle(int resId);

    ActionBarCompat setDisplayOptions(@ActionBar.DisplayOptions int options);

    ActionBarCompat setDisplayOptions(@ActionBar.DisplayOptions int options,
                                                    @ActionBar.DisplayOptions int mask);

    ActionBarCompat setDisplayUseLogoEnabled(boolean useLogo);

    ActionBarCompat setDisplayShowHomeEnabled(boolean showHome);

    ActionBarCompat setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    ActionBarCompat setDisplayShowTitleEnabled(boolean showTitle);

    ActionBarCompat setDisplayShowCustomEnabled(boolean showCustom);

    ActionBarCompat setBackgroundDrawable(@Nullable Drawable d);

    ActionBarCompat setStackedBackgroundDrawable(Drawable d);

    ActionBarCompat setSplitBackgroundDrawable(Drawable d);

    View getCustomView();

    CharSequence getTitle();

    CharSequence getSubtitle();

    @ActionBar.DisplayOptions
    int getDisplayOptions();

    int getHeight();

    ActionBarCompat show();

    ActionBarCompat hide();

    boolean isShowing();

    ActionBarCompat addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    ActionBarCompat removeOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    ActionBarCompat setHomeButtonEnabled(boolean enabled);

    Context getThemedContext();

    ActionBarCompat setHomeAsUpIndicator(Drawable drawable);

    ActionBarCompat setHomeAsUpIndicator(@DrawableRes int resId);

    ActionBarCompat setHomeActionContentDescription(@Nullable CharSequence description);

    ActionBarCompat setHomeActionContentDescription(@StringRes int resId);

    ActionBarCompat setHideOnContentScrollEnabled(boolean hideOnContentScroll);

    boolean isHideOnContentScrollEnabled();

    int getHideOffset();

    ActionBarCompat setHideOffset(int offset);

    ActionBarCompat setElevation(float elevation);

    float getElevation();

    Object getActionBar();

    class LayoutParams {

        private ActionBar.LayoutParams mSupportParams;

        private android.app.ActionBar.LayoutParams mParams;

        public LayoutParams(ActionBar.LayoutParams params) {
            this.mSupportParams = params;
        }

        public LayoutParams(android.app.ActionBar.LayoutParams appParams) {
            this.mParams = appParams;
        }

        public android.app.ActionBar.LayoutParams getParams() {
            return mParams;
        }

        public ActionBar.LayoutParams getSupportParams() {
            return mSupportParams;
        }

    }

    interface OnMenuVisibilityListener extends ActionBar.OnMenuVisibilityListener,
            android.app.ActionBar.OnMenuVisibilityListener{

    }
}
