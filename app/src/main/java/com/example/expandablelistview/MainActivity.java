package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.RaceData));

        String[] array;
        List<String> list = new ArrayList<>();
        array = getResources().getStringArray(R.array.RaceData);
        for(String item : array)
        {
            list.add(item);
        }

        listItem.put(listGroup.get(0),list); // with this implementation, we are able to add more list options
        adapter.notifyDataSetChanged();
    }
}
