package com.zhou.jy.huzhi.base.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class ThemeData {

    public String description;
    public String background;
    public int color;
    public String name;
    public String image;
    public List<editor> editorses;
    public List<storie> stories;


   public  class storie{
        public List<String> images;
        public int type;
        public int  id ;
        public String title;
    }

   public  class editor{
        public String url;
        public String bio;
        public int id;
        public String avatar;
        public String name;
    }
}
