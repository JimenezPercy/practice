package com.joker.demo.stock.view;

import com.joker.demo.stock.entity.MainMenuOption;

import java.util.Scanner;


public class SystemView {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int mainMenu() {
		int index = 0;
		do {
			System.out.println("请选择操作1.物品类型管理|2.物品管理|3.退出");
			System.out.print("选项：");
			index = scanner.nextInt();
		}while(index != MainMenuOption.GOODS_TYPE_MANAGE &&
					index != MainMenuOption.GOODS_MANAGE && 
						index != MainMenuOption.EXIT);
		return index;
	}
	
	public static void init() throws Exception {
		System.out.println("欢迎使用库存管理系统");
		System.out.print("系统加载中，请稍候");
		for(int i = 0 ; i < 1 ; i ++) {
			System.out.print(".....");
			Thread.sleep(1000);
		}
		System.out.println("");
		System.out.println("系统加载完成");
	}
}
