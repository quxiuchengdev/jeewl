package com.qxcwl.jeewl.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class BaseController {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${adminPath}")
	protected String adminPath;
	
	/**
	 * 获取当前页码
	 * @Title getPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年8月4日 下午8:06:28
	 * @param start
	 * @param length
	 * @return
	 */
	protected int getPage(int start, int length) {  //整除  
		if(length < 0){
			return 1;
		}
	    int n1 = Math.round(start); //四舍五入     
	    int n2 = Math.round(length); //四舍五入    
	  
	    int rslt = n1 / n2; //除    
	    if (rslt >= 0) {  
	        rslt = (int) Math.floor(rslt); //返回小于等于原rslt的最大整数。     
	    }  
	    else {  
	        rslt = (int) Math.ceil(rslt); //返回大于等于原rslt的最小整数。     
	    }  
	    return ++rslt;  
	}
	
	/**
	 * 获取当前页码
	 * @Title getPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年8月4日 下午8:06:50
	 * @param startStr
	 * @param lengthStr
	 * @return
	 */
	protected int getPage(String startStr, String lengthStr) {  //整除  
		int start = Integer.valueOf(startStr);
		int length = Integer.valueOf(lengthStr);
		
		if(length < 0){
			return 1;
		}
		
	    int n1 = Math.round(start); //四舍五入     
	    int n2 = Math.round(length); //四舍五入    
	  
	    int rslt = n1 / n2; //除    
	    if (rslt >= 0) {  
	        rslt = (int) Math.floor(rslt); //返回小于等于原rslt的最大整数。     
	    }  
	    else {  
	        rslt = (int) Math.ceil(rslt); //返回大于等于原rslt的最小整数。     
	    }  
	    return ++rslt;  
	}
	
	/**
	 * 获取分页大小
	 * @Title getLimit
	 * @Description 
	 * @author 曲修成
	 * @date 2016年8月4日 下午8:06:57
	 * @param start
	 * @param length
	 * @return
	 */
	protected int getLimit(int length) {  //整除  
		if(length < 0){
			return 10;
		}
	    return length;  
	}
	/**
	 * 获取分页大小
	 * @Title getLimit
	 * @Description 
	 * @author 曲修成
	 * @date 2016年8月4日 下午8:07:34
	 * @param startStr
	 * @param lengthStr
	 * @return
	 */
	protected int getLimit( String lengthStr) {  //整除  
		int length = Integer.valueOf(lengthStr);
		if(length < 0){
			return 10;
		}
	    return length;  
	}
}
