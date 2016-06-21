package com.zhou.jy.huzhi.base.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Themes {
    public int limit;
    public List<String> subscribed;
    public List<other>  others;

  public class other{
      public int color;
      public String thumbnail;
      public String description;
      public int id;
      public String name;
  }
}
