package com.zgk.hardwork01;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListFragment extends androidx.fragment.app.ListFragment {
    private MyAdapter adapter;
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        getActivity().setTitle("ddd");

        List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("logo",R.mipmap.ic_launcher);
        map.put("title","标题一" );
        map.put("content","内容一");
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("logo",R.mipmap.ic_launcher);
        map.put("title","标题二" );
        map.put("content","内容二");
        list.add(map);

        adapter=new MyAdapter(getActivity());
        adapter.setlist(list);
        setListAdapter(adapter);

    }


}
