package com.example.newnewnew;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.newnewnew.R;

public class myAdapter extends BaseAdapter {
    private ArrayList<ListItem> listData;
    private LayoutInflater layoutInflater;

    public myAdapter(Context context, ArrayList<ListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        myHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new myHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
            convertView.setTag(holder);

        } else {
            holder = (myHolder) convertView.getTag();
        }

        ListItem newsItem = listData.get(position);
        holder.headlineView.setText(newsItem.getHeadline());

        if (holder.imageView != null) {
            new ImageDownloaderTask(holder.imageView).execute(newsItem.getUrl());
        }

        return convertView;
    }

    static class myHolder {
        TextView headlineView;
        ImageView imageView;
    }
}
