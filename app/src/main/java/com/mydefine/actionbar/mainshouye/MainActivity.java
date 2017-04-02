package com.mydefine.actionbar.mainshouye;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    public void initview() {
        content = (FrameLayout) findViewById(R.id.content);
        ivHome = (ImageView) findViewById(R.id.iv_home);
        tvHome = (TextView) findViewById(R.id.tv_home);
        llHome = (LinearLayout) findViewById(R.id.ll_home);
        ivTouzi = (ImageView) findViewById(R.id.iv_touzi);
        llTouzi = (LinearLayout) findViewById(R.id.ll_touzi);
        ivMe = (ImageView) findViewById(R.id.iv_me);
        tvMe = (TextView) findViewById(R.id.tv_me);
        llMe = (LinearLayout) findViewById(R.id.ll_me);
        ivMore = (ImageView) findViewById(R.id.iv_more);

        tvTouzi= (TextView) findViewById(R.id.tv_touzi);
        tvMore = (TextView) findViewById(R.id.tv__more);
        llMore = (LinearLayout) findViewById(R.id.ll_more);


    }
public void initLinstener(){
    content.setOnClickListener(this);
    ivHome.setOnClickListener(this);

    tvHome.setOnClickListener(this);
    llHome.setOnClickListener(this);

    ivTouzi.setOnClickListener(this);
    llHome.setOnClickListener(this);

    ivMe.setOnClickListener(this);
    tvMe.setOnClickListener(this);

    llMe.setOnClickListener(this);
    ivMore.setOnClickListener(this);

    tvMore.setOnClickListener(this);
    llMore.setOnClickListener(this);

    tvTouzi.setOnClickListener(this);
    llTouzi.setOnClickListener(this);
}
    FrameLayout content;

    ImageView ivHome;

    TextView tvHome;

    LinearLayout llHome;

    ImageView ivTouzi;

    TextView tvTouzi;

    LinearLayout llTouzi;

    ImageView ivMe;

    TextView tvMe;

    LinearLayout llMe;

    ImageView ivMore;

    TextView tvMore;

    LinearLayout llMore;

    private HomeFragment homeFragment;
    private TouziFragment touziFragment;
    private MeFragment meFragment;
    private MoreFragment moreFragment;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initLinstener();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                setSelect(0);
                break;
            case R.id.ll_touzi:
                setSelect(1);
                break;
            case R.id.ll_me:
                setSelect(2);
                break;
            case R.id.ll_more:
                setSelect(3);
                break;
        }
    }


    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        reSetTab();
        hideFragment();
        switch (i) {
            case 0:
                //首页
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.content, homeFragment);
                }
                ivHome.setImageResource(R.drawable.bid01);
                //  tvHome.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(homeFragment);
                break;
            case 1:
                //投资
                if (touziFragment == null) {
                    touziFragment = new TouziFragment();
                    ft.add(R.id.content, touziFragment);
                }
                ivTouzi.setImageResource(R.drawable.bid03);
                //  tvTouzi.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(touziFragment);
                break;
            case 2:
                //资产
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    ft.add(R.id.content, meFragment);
                }
                ivMe.setImageResource(R.drawable.bid05);
                // tvMe.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(meFragment);
                break;
            case 3:
                //更多
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    ft.add(R.id.content, moreFragment);
                }
                ivMore.setImageResource(R.drawable.bid07);
                //  tvMore.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(moreFragment);
                break;
        }
        ft.commit();
    }


    private void reSetTab() {
        ivHome.setImageResource(R.drawable.bid02);
        ivTouzi.setImageResource(R.drawable.bid04);
        ivMe.setImageResource(R.drawable.bid06);
        ivMore.setImageResource(R.drawable.bid08);
        /*tvHome.setTextColor(UIUtils.getColor(R.color.home_back_unselected));
        tvTouzi.setTextColor(UIUtils.getColor(R.color.home_back_unselected));
        tvMe.setTextColor(UIUtils.getColor(R.color.home_back_unselected));
        tvMore.setTextColor(UIUtils.getColor(R.color.home_back_unselected));*/
    }


    private void hideFragment() {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (touziFragment != null) {
            ft.hide(touziFragment);
        }
        if (meFragment != null) {
            ft.hide(meFragment);
        }
        if (moreFragment != null) {
            ft.hide(moreFragment);
        }
    }


}
