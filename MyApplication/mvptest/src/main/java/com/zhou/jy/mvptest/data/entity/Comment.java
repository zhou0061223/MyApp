package com.zhou.jy.mvptest.data.entity;


import com.zhou.jy.mvptest.base.BaseEntity;
import com.zhou.jy.mvptest.data.Pointer;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class Comment extends BaseEntity.BaseBean {

    public Pointer article;
    public String content;
    public Pointer creater;

    public Comment(Pointer article, String content, Pointer creater) {
        this.article = article;
        this.content = content;
        this.creater = creater;
    }
}
