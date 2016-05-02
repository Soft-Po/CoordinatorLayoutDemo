package com.softpo.coordinatorlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.softpo.coordinatorlayoutdemo.adapters.RvAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        initRecyclerView();

        initCollapsingToolbarLayout();
    }

    private void initCollapsingToolbarLayout() {
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        mCollapsingToolbarLayout.setTitle("许我一屡清愁");

//        mCollapsingToolbarLayout.setContentScrimColor(Color.RED);

//        mCollapsingToolbarLayout.setContentScrimResource(R.color.colorAccent);
    }

    private void initRecyclerView() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            list.add(String.format("第%03d条数据",i));
        }

        RvAdapter adapter = new RvAdapter(this,list);

//        设置布局
        GridLayoutManager layout = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position%5==0){
                    return 3;
                }else if(position%5==2){
                    return 2;
                }else {
                    return 1;
                }
            }
        });

        mRecyclerView.setLayoutManager(layout);

        mRecyclerView.setAdapter(adapter);
    }

    private void initView() {
        mRecyclerView = ((RecyclerView) findViewById(R.id.recycler));

        mCollapsingToolbarLayout = ((CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout));
    }

}
