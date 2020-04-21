package com.zgk.hardwork01;


import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements OnClickListener,RadioGroup.OnCheckedChangeListener {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioGroup rGroup;

    private Fragment f1;
    private Fragment f2;
    private Fragment f3;
    private Fragment f4;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        /**
         * 拿到事务管理器并开启事务
         */
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        /**
         * 初始化按钮
         */
        rb1 =  findViewById(R.id.rb_1);
        rb2 =  findViewById(R.id.rb_2);
        rb3 =  findViewById(R.id.rb_3);
        rb4 =  findViewById(R.id.rb_4);
        rGroup =  findViewById(R.id.rg);

        /**
         * 为三个按钮添加监听
         */
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);

        /**
         * 启动默认选中第一个
         */
        rGroup.check(R.id.rb_1);
        f1 = new PushFragment();
        transaction.replace(R.id.fl_content, f1);
        transaction.commit();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {//new add
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    //hide title&navigation
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }


    @Override
    public void onClick(View v) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (v.getId()) {
            case R.id.rb_1 :
                /**
                 * 为了防止重叠，需要点击之前先移除其他Fragment
                 */
                hideFragment(transaction);
                f1 = new PushFragment();
                transaction.replace(R.id.fl_content, f1);
                transaction.commit();

                break;
            case R.id.rb_2 :
                hideFragment(transaction);
                f2 = new SocialFragment();
                transaction.replace(R.id.fl_content, f2);
                transaction.commit();

                break;
            case R.id.rb_3 :
                hideFragment(transaction);
                f3 = new PersonFragment();
                transaction.replace(R.id.fl_content, f3);
                transaction.commit();
                break;
            case R.id.rb_4:
                hideFragment(transaction);
                f4 = new ToolFragment();
                transaction.replace(R.id.fl_content, f4);
                transaction.commit();
                break;

            default :
                break;
        }
    }

    /*
     * 去除（隐藏）所有的Fragment
     * */
    private void hideFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            //transaction.hide(f1);隐藏方法也可以实现同样的效果，不过我一般使用去除
            transaction.remove(f1);
        }
        if (f2 != null) {
            //transaction.hide(f2);
            transaction.remove(f2);
        }
        if (f3 != null) {
            //transaction.hide(f3);
            transaction.remove(f3);
        }
        if (f4 != null) {
            //transaction.hide(f4);
            transaction.remove(f4);
        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}


