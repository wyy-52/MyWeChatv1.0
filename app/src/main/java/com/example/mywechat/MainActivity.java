package com.example.mywechat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mTabweixin;
    private LinearLayout mTabfriend;
    private LinearLayout mTabaddress;
    private LinearLayout mTabsetting;

    private ImageButton mImgweixin;
    private ImageButton mImgfriend;
    private ImageButton mImgaddress;
    private ImageButton mImgsetting;

    private final Fragment mTab01=new newsFragment();
    private final Fragment mTab02=new friendFragment();
    private final Fragment mTab03=new addressFragment();
    private final Fragment mTab04=new settingFragment();

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        setSelect(0);
    }

    private void initView(){
        mTabweixin=(LinearLayout)findViewById(R.id.id_tab_news);
        mTabfriend=(LinearLayout)findViewById(R.id.id_tab_friend);
        mTabaddress=(LinearLayout)findViewById(R.id.id_tab_address);
        mTabsetting=(LinearLayout)findViewById(R.id.id_tab_setting);

        mImgweixin=(ImageButton)findViewById(R.id.id_tab_news_img);
        mImgfriend=(ImageButton)findViewById(R.id.id_tab_friend_img);
        mImgaddress=(ImageButton)findViewById(R.id.id_tab_address_img);
        mImgsetting=(ImageButton)findViewById(R.id.id_tab_setting_img);
    }

    private void initEvent(){//控制监听范围
        mTabweixin.setOnClickListener(this);
        mTabfriend.setOnClickListener(this);
        mTabaddress.setOnClickListener(this);
        mTabsetting.setOnClickListener(this);
    }

    private void initFragment(){
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void setSelect(int i){
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                mImgweixin.setImageResource(R.drawable.tab_news_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgfriend.setImageResource(R.drawable.tab_friend_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgaddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgsetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        resetImgs();
        switch(v.getId()){
            case R.id.id_tab_news:
                setSelect(0);
                break;
            case R.id.id_tab_friend:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void resetImgs(){
        mImgweixin.setImageResource(R.drawable.tab_news_normal);
        mImgfriend.setImageResource(R.drawable.tab_friend_normal);
        mImgaddress.setImageResource(R.drawable.tab_address_normal);
        mImgsetting.setImageResource(R.drawable.tab_settings_normal);
    }
}
