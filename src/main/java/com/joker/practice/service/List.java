package com.joker.practice.service;

/**
 * @Author: wzp
 * @Date: 2020/7/29 8:01
 */
public interface List {

    /**
     * 在数组末尾添加元素
     */
    void add(Object obj);

    /**
     * 在指定位置添加元素
     */
    void add(int index,Object obj);

    /**
     * 批量添加
     */
    void add(int index,List list);

    /**
     * 修改元素
     */
    void set(int index,Object obj);

    /**
     * 删除元素
     */
    void remove(int index);

    /**
     * 删除元素
     */
    void remove(Object obj);

    /**
     * 获取元素
     */
    Object get(int index);

    /**
     * 获取长度
     */
    int size();
}
