package com.softpo.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.softpo.coordinatorlayoutdemo.adapters.MyAdapter;
import com.softpo.coordinatorlayoutdemo.fragments.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class AppBarLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(android.R.drawable.ic_menu_agenda);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

        initTabLayout();

        initViewPager();
    }

    private void initView() {
        mViewPager = ((ViewPager) findViewById(R.id.viewpager));
        mTabLayout = ((TabLayout) findViewById(R.id.tabs));

    }

    private void initViewPager() {

        List<Fragment> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            MyFragment fragment = new MyFragment();

            Bundle bundle = new Bundle();

            bundle.putInt("index",i);
            fragment.setArguments(bundle);

            list.add(fragment);
        }

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),list);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }

    private void initTabLayout() {

        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setText("头条");
        mTabLayout.addTab(tab);
        TabLayout.Tab tab2 = mTabLayout.newTab();
        tab2.setText("财经");
        mTabLayout.addTab(tab2);
        TabLayout.Tab tab3 = mTabLayout.newTab();
        tab3.setText("科技");
        mTabLayout.addTab(tab3);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
