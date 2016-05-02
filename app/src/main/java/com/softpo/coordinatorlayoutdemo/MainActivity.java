package com.softpo.coordinatorlayoutdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////////////////////////////////
//
//        Window window = this.getWindow();
//        ViewGroup mContentView = (ViewGroup) this.findViewById(Window.ID_ANDROID_CONTENT);
////First translucent status bar.
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        int statusBarHeight = getStatusBarHeight(this);
//        View mChildView = mContentView.getChildAt(0);
//        if (mChildView != null) {
//            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mChildView.getLayoutParams();
//            //如果已经为 ChildView 设置过了 marginTop, 再次调用时直接跳过
//            if (lp != null && lp.topMargin < statusBarHeight && lp.height != statusBarHeight) {
//                //不预留系统空间
//                ViewCompat.setFitsSystemWindows(mChildView, false);
//                lp.topMargin += statusBarHeight;
//                mChildView.setLayoutParams(lp);
//            }
//        }
//
//        View statusBarView = mContentView.getChildAt(0);
//        if (statusBarView != null && statusBarView.getLayoutParams() != null && statusBarView.getLayoutParams().height == statusBarHeight) {
//            //避免重复调用时多次添加 View
//            statusBarView.setBackgroundColor(Color.RED);
//            return;
//        }
//        statusBarView = new View(this);
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
//        statusBarView.setBackgroundColor(Color.RED);
////向 ContentView 中添加假 View
//        mContentView.addView(statusBarView, 0, lp);
        ///////////////////////////////////////////////////////////////////


        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        /**
         * android:fitsSystemWindows="true"
         android:clipToPadding="true"
         只要在某个view设置了该熟悉，那么状态栏的颜色就跟该view的背景色保持一致。
         */

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                                Toast.makeText(MainActivity.this, "Test",Toast.LENGTH_LONG).show();

                            }
                        })
                        .show();
            }
        });
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
