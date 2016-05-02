package com.softpo.coordinatorlayoutdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.softpo.coordinatorlayoutdemo.R;
import com.softpo.coordinatorlayoutdemo.adapters.RvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_my, container, false);

        ListView listView = ((ListView) inflate.findViewById(R.id.listView));

        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);

        Bundle arguments = this.getArguments();
        int index = 0;
        if (arguments != null) {
            index= arguments.getInt("index");
        }

        List<String> list = new ArrayList<>();

        switch (index){
            case 0:
                for (int i = 0; i < 100; i++) {
                    list.add("今日头条"+i);
                }
                break;
            case 1:
                for (int i = 0; i < 100; i++) {
                    list.add("今日财经"+i);
                }
                break;
            case 2:
                for (int i = 0; i < 100; i++) {
                    list.add("今日科技"+i);
                }
                break;

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        RvAdapter adapter1 = new RvAdapter(getContext(),list);

        LinearLayoutManager layoutManger = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManger);

        recyclerView.setAdapter(adapter1);


        return inflate;
    }

}
