package com.example.whatstnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
//import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
//import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
TabItem mhome,mscience,mhealth,mtech,mentertainment,msports;
PageAdapter pageAdapter;
Toolbar toolbar;
String api="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api="040ae3020697403a922203402cdb1e46";
        setSupportActionBar(toolbar);
        mhome=findViewById(R.id.home);
        mscience=findViewById(R.id.science);
        mhealth=findViewById(R.id.science);
        mtech=findViewById(R.id.technology);
        mentertainment=findViewById(R.id.entertainment);
        msports=findViewById(R.id.sports);
        tabLayout=findViewById(R.id.include);
        ViewPager viewPager =findViewById(R.id.fragmentcontainer);
        pageAdapter=new PageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()<=5 ){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}