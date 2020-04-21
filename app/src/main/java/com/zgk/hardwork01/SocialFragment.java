package com.zgk.hardwork01;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialFragment extends Fragment  {
    private ListView listView;

    //创建适配器对象
    private MyAdapter adapter;

     private  View contentView;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        //创建界面MsgFragment
        contentView=inflater.inflate(R.layout.socialfragment,container,false);
        listView=contentView.findViewById(R.id.lv_text_view);
        List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("logo",R.mipmap.ic_launcher);
        map.put("title","标题1" );
        map.put("content","内容1");
        list.add(map);

       for(int i=2;i<30;++i)
       {
           map=new HashMap<String,Object>();
           map.put("logo",R.mipmap.ic_launcher);
           map.put("title","标题"+i);
           map.put("content","内容"+i);
           list.add(map);
       }



        adapter=new MyAdapter(getActivity());
        adapter.setlist(list);
        listView.setAdapter(adapter);
        return contentView;

    }



}
