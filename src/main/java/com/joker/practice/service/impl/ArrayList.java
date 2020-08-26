package com.joker.practice.service.impl;

import com.joker.practice.service.List;

import java.util.Arrays;

/**
 * @Author: wzp
 * @Date: 2020/7/29 8:00
 */
public class ArrayList implements List {

    public Object[] objs = new Object[0];
    public int size = 0;

    /**
     * 检查index，合法返回true
     *
     * @param index
     * @return
     */
    private boolean checkIndex(int index) {
        return index >= 0 || index <= this.size;
    }

    @Override
    public void add(Object obj) {
        //添加元素，往数组obj添加内容
        //1.数组长度+1，扩容
        this.objs = Arrays.copyOf(this.objs, ++this.size);
        //2.把新增元素添加到数组末尾
        this.objs[size - 1] = obj;
    }

    @Override
    public void add(int index, Object obj) {
        //指定位置添加内容
        //检查index
        if (checkIndex(index)) {
            //扩容
            this.objs = Arrays.copyOf(this.objs, ++this.size);
            //从末尾向前遍历，逐个元素后移，直到指定添加位置
            for (int i = this.size - 1; i > index; i--) {
                this.objs[i] = this.objs[i - 1];
            }
            //插入元素
            this.objs[index] = obj;
        }
    }

    @Override
    public void add(int index, List list) {
        //批量插入
        if (checkIndex(index)) {
            this.size += list.size();
            //扩容
            this.objs = Arrays.copyOf(this.objs, this.size);
            //从末尾向前遍历，逐个元素后移，直到指定添加位置
            for (int i = this.size - 1; i >= this.size-list.size(); i--) {
                this.objs[i] = this.objs[i - list.size()];
            }
            //插入元素
            for(int i=0;i<list.size();i++){
                this.objs[index+i] = list.get(i);
            }
        }
    }

    @Override
    public void set(int index, Object obj) {
        //修改指定位置的元素
        if (checkIndex(index)) {
            this.objs[index] = obj;
        }
    }

    @Override
    public void remove(int index) {
        //删除指定位置的元素
        //检查index
        if (checkIndex(index)) {
            //删除元素
            for (int i = index; i < this.size - 1; i++) {
                this.objs[i] = this.objs[i + 1];
            }
            //长度-1
            this.objs = Arrays.copyOf(this.objs, --this.size);
        }

    }

    @Override
    public void remove(Object obj) {
        int index=0;
        //遍历数组，定位元素
        for(int i=0;i<this.size;i++){
            if(this.objs[i].equals(obj)){
                index=i;
                break;
            }
        }

        remove(index);
    }

    @Override
    public Object get(int index) {
        //返回元素
        return this.objs[index];
    }

    @Override
    public int size() {
        //返回长度
        return this.size;
    }
}
