package com.example.nhac.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nhac.Adapter.MainViewPagerAdapter;
import com.example.nhac.Fragment.Fragment_Tim_Kiem;
import com.example.nhac.Fragment.Fragment_Trang_chu;
import com.example.nhac.R;

import android.view.View;
import android.widget.MediaController.MediaPlayerControl;

public class MainActivity extends AppCompatActivity{

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addPragment(new Fragment_Trang_chu(),"");
        //mainViewPagerAdapter.addPragment(new Fragment_Tim_Kiem(),"Tìm kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        //tabLayout.setupWithViewPager(viewPager);
        //tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        //tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);

    }

    private void anhxa(){
        //tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }

}
