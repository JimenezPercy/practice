package com.joker.demo.stock.view;

import com.joker.demo.stock.entity.Goods;
import com.joker.demo.stock.entity.GoodsOption;
import com.joker.demo.stock.entity.GoodsType;
import com.joker.demo.stock.service.GoodsService;
import com.joker.demo.stock.service.GoodsTypeService;
import com.joker.demo.stock.service.impl.GoodsServiceImpl;
import com.joker.demo.stock.service.impl.GoodsTypeServiceImpl;

import java.util.Scanner;


public class GoodsView {
	
	private GoodsTypeService gtService = new GoodsTypeServiceImpl();
	private GoodsService gService = new GoodsServiceImpl();
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * ��Ʒ�����Ĳ˵�
	 * @return
	 */
	public int goodsMenus() {
		int index = 0;
		do {
			System.out.println("请选择物品操作：1.入库|2.出库|3.返回上级菜单");
			System.out.print("请输入操作类型：");
			index = scanner.nextInt();
		}while(index != GoodsOption.GOODS_IN &&
				index != GoodsOption.GOODS_OUT && 
				index != GoodsOption.GOODS_EXIT );
		return index;
	}
	
	
	/**
	 * ִ执行操作
	 * @param index
	 */
	public void optionChoose(int index) {
		switch(index) {
			case GoodsOption.GOODS_IN:
				this.inGoods();
				break;
			case GoodsOption.GOODS_OUT:
				this.outGoods();
				break;
			case GoodsOption.GOODS_EXIT:
				System.out.println("物品库存管理退出……");
				break;
		}
	}
	
	/**
	 * 物品入库
	 */
	private void inGoods() {
		//1.展示物品类型列表
		boolean gtFlag = this.showGoodsTypeList();
		if(gtFlag) {
			//2.请选择物品类型
			System.out.print("请输入需要操作的物品类型ID:");
			int gtId = this.scanner.nextInt();
			GoodsType[] gts =
					this.gtService.queryGoodsTypesList(
							new GoodsType().setId(gtId));
			if(gts.length == 0) {
				//物品类型不存在
				System.out.println("所选物品类型不存在：");
				return;
			}else {
				//物品类型存在
				GoodsType gt = gts[0];
				//展示当前类型物品列表
				this.showGoodsList(gtId);
				//4.输入入库信息，同事检查物品是否存在
				System.out.print("请输入物品编号：");
				String goodCode = this.scanner.next();
				Goods g = this.gService.queryGoodsByGoodsCode(
						new Goods().setGoodsCode(goodCode));
				if(g == null) {
					System.out.println("物品编号不存在，请新增该物品入库信息！");
					//需要新增
					g = new Goods();
					System.out.print("请输入物品名称：");
					g.setName(this.scanner.next());
					System.out.print("请输入物品最小入库数量：");
					g.setMinNumber(this.scanner.nextInt());
					System.out.print("请输入物品最大入库数量：");
					g.setMaxNumber(this.scanner.nextInt());
					System.out.print("请输入物品入库数量：");
					g.setNumber(this.scanner.nextInt());
					//设置类型
					g.setType(gt);
					//验证
					this.gService.insertGoods(g);
				}else {
					//需要修改
					System.out.print("请输入物品入库数量：");
					//增加数量
					g.setNumber(g.getNumber() + this.scanner.nextInt());
					//验证
					this.gService.updateGoods(g);
				}
				
			}
			
		}
	}
	/**
	 * 出库
	 */
	private void outGoods() {
		
	}
	
	/**
	 * 展示物品列表
	 */
	private void showGoodsList(int gtId) {
		Goods[] gs = this.gService.queryGoodsListByTypeId(
					new Goods().setType(new GoodsType().setId(gtId))
				);

		System.out.println("------------------------------------");
		if(gs.length == 0) {
			System.out.println("无物品库存信息！");
		}
		for(Goods g : gs) {
			System.out.println("|"
					+ g.getId() + "|" 
					+ g.getGoodsCode() + "|"
					+ g.getName() + "|" 
					+ g.getType().getName() + "|"
					+ g.getNumber() + "|"
					+ g.getMaxNumber() + "|"
					+ g.getMinNumber() + "|"
					+ (g.getStatus() ? "可用":"不可用") + "|"
					);
		}
		System.out.println("------------------------------------");
		
		
	}
	
	/**
	 * 展示物品类型列表
	 */
	private boolean showGoodsTypeList() {
		GoodsType[] types = this.gtService.queryGoodsTypesList(null);
		//��ʼ�б�չʾ
		System.out.println("------------------------------------");
		if(types.length == 0) {
			System.out.println("无物品类型信息，请先添加物品类型！");
			return false;
		}
		for(GoodsType type : types) {
			System.out.println("|" +type.getId() + "|" + type.getName() + "|");
		}
		System.out.println("------------------------------------");
		return true;
	}
	
	
	
	/**
	 * ��Ʒ���
	 */
	private void deleteGoods() {
		
	}
}
