package com.zgk.hardwork01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
public class MyAdapter extends BaseAdapter {
    private List<Map<String,Object>> list;

    private LayoutInflater inflater;

    public MyAdapter(Context context){

       this.inflater=LayoutInflater.from(context);
    }
 public void setlist(List<Map<String,Object>> list)
 {
     this.list=list;
 }


    @Override
    public int getCount() {
        //return返回的是int类型，也就是页面要显示的数量。
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
View view= inflater.inflate(R.layout.list_view_item,null);
        TextView title = (TextView) view.findViewById(R.id.news_title);
       ImageView logo  = (ImageView) view.findViewById(R.id.news_img);
        TextView content = (TextView) view.findViewById(R.id.news_message);
        Map map=list.get(position);
        logo.setImageResource((Integer) map.get("logo"));
        title.setText((String)map.get("title"));
        content.setText((String)map.get("content"));
       return view;
        
    }
    static class ViewHolder {
        public ImageView images;
        public TextView title;
        public TextView contents;
    }



}