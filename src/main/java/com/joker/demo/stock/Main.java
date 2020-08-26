package com.joker.demo.stock;


import com.joker.demo.stock.entity.GoodsOption;
import com.joker.demo.stock.entity.GoodsTypeOption;
import com.joker.demo.stock.entity.MainMenuOption;
import com.joker.demo.stock.view.GoodsTypeView;
import com.joker.demo.stock.view.GoodsView;
import com.joker.demo.stock.view.SystemView;

public class Main {

	public static void main(String[] args) throws Exception {
		boolean exit = true;
		SystemView.init();//初始化
		while(exit) {
			int menuIndex = SystemView.mainMenu();
			
			GoodsTypeView typeView = new GoodsTypeView();
			GoodsView goodsView = new GoodsView();
			//主菜单选择
			switch(menuIndex) {
				//物品类型管理
				case MainMenuOption.GOODS_TYPE_MANAGE:
					while(true) {
						//1.展示列表
						typeView.showGoodsTypeList();
						//2.询问操作
						int goodsTypeOption = typeView.goodsTypeMenus();
						//3.ִ执行操作
						typeView.optionChoose(goodsTypeOption);
						//4.验证是否退出
						if(goodsTypeOption == 
								GoodsTypeOption.GOODS_TYPE_EXIT) {
							break;
						}
					}
					break;
				//物品管理
				case MainMenuOption.GOODS_MANAGE:
					while(true) {
						//1.展示管理
						//2.ִ询问操作
						int goodsOption = goodsView.goodsMenus();

						//3.执行操作
						goodsView.optionChoose(goodsOption);
						//验证是否退出
						if(goodsOption == GoodsOption.GOODS_EXIT) {
							break;
						}
					}
					break;
				case MainMenuOption.EXIT:
					exit = false;//退出
					break;
			}
		}
		
		System.out.println("谢谢使用");
		
	}
	
	
	
}
