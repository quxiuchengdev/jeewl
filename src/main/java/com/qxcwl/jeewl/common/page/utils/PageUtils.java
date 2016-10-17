package com.qxcwl.jeewl.common.page.utils;

public class PageUtils {
	/**
	 * 
	 * @Title isDisabledPage
	 * @Description
	 * @author 曲修成
	 * @date 2016年6月29日 下午8:07:12
	 * @param paginator
	 * @return
	 */
	public static boolean isDisabledPage(String paginatorTotalPagesStr, String paginatorPageStr, String pageStr) {
		int page = Integer.valueOf(pageStr);
		int paginatorTotalPages = Integer.valueOf(paginatorTotalPagesStr);
		int paginatorPage = Integer.valueOf(paginatorPageStr);
		return ((page < 1) || (page > paginatorTotalPages) || (page == paginatorPage));
	}
}
