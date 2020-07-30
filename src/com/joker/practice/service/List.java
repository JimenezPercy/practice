package com.joker.practice.service;

/**
 * @Author: wzp
 * @Date: 2020/7/29 8:01
 */
public interface List {

    /**
     * 新增元素
     * @param obj
     */
    void add(Object obj);

    /**
     * 在指定位置新增元素
     * @param index
     * @param obj
     */
    void add(int index,Object obj);

    /**
     * 批量添加元素
     * @param index
     * @param list
     */
    void add(int index,List list);

    /**
     * 修改元素值
     * @param index
     * @param obj
     */
    void set(int index,Object obj);

    /**
     * 删除指定位置的元素
     * @param index
     */
    void remove(int index);

    /**
     * 删除元素
     * @param obj
     */
    void remove(Object obj);

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * 获取元素数量
     * @return
     */
    int size();
}
