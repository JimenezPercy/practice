package com.joker.practice.service.impl;

import com.joker.practice.service.List;

/**
 * @Author: wzp
 * @Date: 2020/7/29 21:32
 */
public class LinkedList implements List {

    //起点
    private Node first;
    //终点
    private Node last;

    //长度
    private int size = 0;

    /**
     * 从头部添加元素
     *
     * @param obj
     */
    public void addFirst(Object obj) {
        //最前面没有元素,即链表为空
        if (this.first == null) {
            Node node = new Node();
            this.first = node;
            this.last = node;
            node.item = obj;
        } else {
            //头部已经有元素
            Node node = new Node();
            node.item = obj;
            //把原来first的上一个元素，指向现在新建的Node
            this.first.previous = node;
            //新建的元素下一个，指向原来的first
            node.next = this.first;
            node.previous = node;
            //first替换成新的node元素
            this.first = node;
        }
        this.size++;
    }

    /**
     * 从尾部添加元素
     *
     * @param obj
     */
    public void addLast(Object obj) {
        //没有元素
        if (this.last == null) {
            Node node = new Node();
            this.first = node;
            this.last = node;
            node.item = obj;
        } else {
            //有元素
            Node node = new Node();
            node.item = obj;
            //把原来last的下一个指向新增节点
            this.last.next = node;
            //新增节点的上一个指向原来的last
            node.previous = this.last;
            node.next = node;
            //把last指向新增节点
            this.last = node;
        }
        this.size++;
    }

    /**
     * 获取头部元素
     *
     * @param obj
     * @return
     */
    public Object getFirst(Object obj) {
        return this.first;
    }

    /**
     * 获取尾部元素
     *
     * @param obj
     * @return
     */
    public Object getLast(Object obj) {
        return this.last;
    }

    /**
     * 删除头部元素
     *
     * @param obj
     */
    public void removeFirst(Object obj) {

    }

    /**
     * 删除尾部元素
     *
     * @param obj
     */
    public void removeLast(Object obj) {

    }

    @Override
    public void add(Object obj) {
        this.addLast(obj);
    }

    @Override
    public void add(int index, Object obj) {

    }

    @Override
    public void add(int index, List list) {

    }

    @Override
    public void set(int index, Object obj) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public Object get(int index) {
        if (checkIndex(index)) {
            Node f = this.first;
            for (int i = 1; i <= index; i++) {
                f = f.next;
            }
            return f.item;
        }
        return null;

    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 检查游标合法性
     *
     * @param index
     * @return
     */
    private boolean checkIndex(int index) {
        return index >= 0 && index < this.size;
    }

    /**
     * 节点类
     */
    class Node {
        //上一个节点
        Node previous;
        //当前节点
        Object item;
        //下一个节点
        Node next;
    }
}
