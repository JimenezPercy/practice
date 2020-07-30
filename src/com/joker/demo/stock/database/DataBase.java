package com.joker.demo.stock.database;

import com.joker.demo.stock.entity.Goods;
import com.joker.demo.stock.entity.GoodsType;
import com.joker.practice.service.List;
import com.joker.practice.service.impl.ArrayList;

/**
 * 存放数据
 *
 * @Author: wzp
 * @Date: 2020/7/29 23:13
 */
public class DataBase {
    List goodsList = new ArrayList();
    List goodsTypeList = new ArrayList();

    private static DataBase db = null;

    private DataBase() {

    }

    //---------------------------------------------------------------------------
    private int goodsTypeId = 0;

    /**
     * 自动生成ID序列
     *
     * @return
     */
    public int goodsTypeIdSequence() {
        return ++this.goodsTypeId;
    }

    public synchronized static DataBase getDataBase() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    /**
     * 添加物品类型，新增类型ID需要自动生成
     *
     * @param type
     */
    public void insertGoodsType(GoodsType type) {
        goodsTypeList.add(type);
    }

    /**
     * 修改物品类型
     *
     * @param type
     * @param index
     */
    public void updateGoodsType(GoodsType type, int index) {
        goodsTypeList.set(index, type);
    }

    /**
     * 根据ID修改物品类型
     *
     * @param type
     */
    public void updateGoodsTypeById(GoodsType type) {
        for (int i = 0; i < this.goodsTypeList.size(); i++) {
            Object obj = this.goodsTypeList.get(i);
            if (obj instanceof GoodsType) {
                GoodsType t = (GoodsType) obj;
                if (t.getId() == type.getId()) {
                    goodsTypeList.set(i, type);
                }
            }
        }
    }

    /**
     * 根据ID获取物品类型
     *
     * @param id
     * @return
     */
    public GoodsType queryGoodsTypesById(int id) {
        for (int i = 0; i < this.goodsTypeList.size(); i++) {
            Object obj = this.goodsTypeList.get(i);
            if (obj instanceof GoodsType) {
                GoodsType type = (GoodsType) obj;
                if (id == type.getId()) {
                    return type;
                }
            }
        }
        return null;
    }

    /**
     * 获取所有物品类型
     *
     * @return
     */
    public GoodsType[] queryGoodsTypesList() {
        GoodsType[] types = new GoodsType[this.goodsTypeList.size()];
        for (int i = 0; i < this.goodsTypeList.size(); i++) {
            Object obj = this.goodsTypeList.get(i);
            if (obj instanceof GoodsType) {
                GoodsType type = (GoodsType) obj;
                types[i] = type;
            }
        }
        return types;
    }
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    private int goodsId = 0;

    private int goodsIdSequence() {
        return ++this.goodsId;
    }

    /**
     * 添加物品
     *
     * @param goods
     */
    public void insertGoods(Goods goods) {
        goods.setId(this.goodsIdSequence());
        goodsList.add(goods);
    }

    /**
     * 修改物品
     *
     * @param goods
     */
    public void updateGoods(Goods goods) {
        for (int i = 0; i < this.goodsList.size(); i++) {
            Object obj = this.goodsList.get(i);
            if (obj instanceof Goods) {
                Goods g = (Goods) obj;
                if (g.getId() == goods.getId()) {
                    goodsList.set(i, g);
                    break;
                }
            }
        }
    }

    /**
     * 根据ID获取物品
     *
     * @param id
     * @return
     */
    public Goods queryGoodsById(int id) {
        for (int i = 0; i < this.goodsList.size(); i++) {
            Object obj = this.goodsList.get(i);
            if (obj instanceof Goods) {
                Goods g = (Goods) obj;
                if (id == g.getId()) {
                    return g;
                }
            }
        }
        return null;
    }

    /**
     * 查找物品列表
     *
     * @return
     */
    public Goods[] queryGoodsList() {
        Goods[] gs = new Goods[this.goodsList.size()];
        for (int i = 0; i < this.goodsList.size(); i++) {
            Object obj = this.goodsList.get(i);
            if (obj instanceof Goods) {
                Goods g = (Goods) obj;
                gs[i] = g;
            }
        }
        return gs;
    }
    //--------------------------------------------------------------------------------
}
