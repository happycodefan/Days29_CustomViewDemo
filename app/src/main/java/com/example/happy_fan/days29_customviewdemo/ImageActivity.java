package com.example.happy_fan.days29_customviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActivity extends AppCompatActivity {

    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Integer[] ints = new Integer[100];
        Arrays.fill(ints, R.mipmap.ic_launcher);
        List<Map<String,Integer>> maps = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            HashMap<String,Integer> map = new HashMap<>();
            map.put("img",R.mipmap.ic_launcher);
            maps.add(map);
        }
        adapter = new SimpleAdapter(this,maps, R.layout.item, new String[]{"img"},new int[]{R.id.item_image});
        ListView list = ((ListView) findViewById(R.id.image_list));
        list.setAdapter(adapter);

    }
}
