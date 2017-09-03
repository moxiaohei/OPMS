package com.opms.unti;

import java.util.Random;


/**
 * 
 * description:
 * @author changzhewei
 * @date 2017年7月29日
 */
public class RandomTest {
	/**
	 * 
	 * description:获得一个随机ID
	 * @author changzhewei
	 * @date 2017年7月29日
	 */
	public static long random(){
		Random rs=new Random();
		String ss=rs.nextLong()+"";
		Long ran = Long.parseLong("146"+ss.substring(ss.length()-16, ss.length()));
		return ran;
	}
	
}
