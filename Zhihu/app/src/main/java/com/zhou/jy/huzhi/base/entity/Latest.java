package com.zhou.jy.huzhi.base.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Latest {

    public String date;
    public List<stories> stories;
    public List<top_stories> top_stories;


    class  stories{
        public String title;
        public String ga_prefix;
        public List<String> images;
        public int type;
        public int id;

    }
    class top_stories{
        public String title;
        public String image;
        public  String  ga_prefix;
        public int type;
        public int id;
    }


    @Override
    public String toString() {
        return "Latest{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
