package com.example.newnewnew;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.example.newnewnew.R;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItem> listData = getListData();

        final ListView listView = (ListView) findViewById(R.id.custom_list);
        ArrayList<ListItem> listData2 = listData;
		listView.setAdapter(new myAdapter(this,listData2));
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<ListItem> getListData() {
        ArrayList<ListItem> list = new ArrayList<ListItem>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);

        for (int i = 0; i < images.length; i++) {
            ListItem newsData = new ListItem();
            newsData.setUrl(images[i]);
            newsData.setHeadline(headlines[i]);
            list.add(newsData);
        }
        return list;
    }
}
