package com.joker.demo.stock.util;

public class GoodsCodeSystemUtil {
	
	private static final String PREFIX = "GC";
	private static int number = 0;
	private static final int SUFFIX_LENGTH = 3;
	
	//GC001
	public static String getGoodsCode() {
		++number;
		String numberStr = String.valueOf(number);
		if(SUFFIX_LENGTH - numberStr.length() < 0) {
			return null;
		}
		for(int i = 0 ; 
				(SUFFIX_LENGTH - numberStr.length() >= 0)&&
				i < SUFFIX_LENGTH - numberStr.length(); i ++) {
			numberStr = "0"+numberStr;
		}
		if(number<10) {
			numberStr = "0"+numberStr;
		}
		return PREFIX + numberStr;
	}
	
	
	public static void main(String[] args) {
		for(int i = 0; i < 300; i ++) {
			System.out.println(getGoodsCode());
		}
	}
}
