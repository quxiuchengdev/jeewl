package com.qxcwl.jeewl.modules.sys.utils;

import java.util.List;

import com.qxcwl.jeewl.common.utils.SpringContextHolder;
import com.qxcwl.jeewl.modules.sys.dao.MenuDao;
import com.qxcwl.jeewl.modules.sys.entity.Menu;

public class UserUtils {

	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	
	public static List<Menu> getMenuList(){
		return getPMenuList();
	}
	
	public static List<Menu> getChildTreeMenuList(){
		List<Menu> menuList = menuDao.findList(new Menu());
		
		menuList = Menu.getTreeMenuList(menuList);
		return menuList;
	}
	
	
	private static List<Menu> getPMenuList(){
		
		List<Menu> menuList = menuDao.findList(new Menu());
		
		menuList = Menu.getTreeMenuList(menuList);
		return menuList;
//		
//		Menu m1 = new Menu();
//		m1.setId("1");
//		m1.setName("页面示例");
//		m1.setHref("");
//		m1.setIsShow(Global.SHOW);
//		m1.setSort(10);
//		m1.setParent(new Menu("0"));
//		m1.setParentIds("0,");
//		
//
//		Menu m2 = new Menu();
//		m2.setId("2");
//		m2.setName("404页面");
//		m2.setHref("/page404");
//		m2.setIsShow(Global.SHOW);
//		m2.setSort(20);
//		m2.setParent(m1);
//		m2.setParentIds("0,1,");
//		
//		Menu m3 = new Menu();
//		m3.setId("3");
//		m3.setName("500页面");
//		m3.setHref("/page500");
//		m3.setIsShow(Global.SHOW);
//		m3.setSort(30);
//		m3.setParent(m1);
//		m3.setParentIds("0,3,");
//		
//		Menu m4 = new Menu();
//		m4.setId("4");
//		m4.setName("菜单管理");
//		m4.setHref("/sys/menu/list");
//		m4.setIsShow(Global.SHOW);
//		m4.setSort(40);
//		m4.setParent(m1);
//		m4.setParentIds("0,4,");
//		
//		Menu m5 = new Menu();
//		m5.setId("5");
//		m5.setName("用户管理");
//		m5.setHref("/sys/user/list");
//		m5.setIsShow(Global.SHOW);
//		m5.setSort(50);
//		m5.setParent(m1);
//		m5.setParentIds("0,5,");
//		
//		Menu m6 = new Menu();
//		m6.setId("6");
//		m6.setName("字典管理");
//		m6.setHref("/sys/dict/list");
//		m6.setIsShow(Global.SHOW);
//		m6.setSort(60);
//		m6.setParent(m1);
//		m6.setParentIds("0,5,");
//		
//		menuList.add(m1);
//		menuList.add(m3);
//		menuList.add(m2);
//		menuList.add(m4);
//		menuList.add(m5);
//		menuList.add(m6);
//		
//		Menu.sortAscList(menuList);
//		List<Menu> list = Lists.newArrayList();
//		Menu.treeList(list, menuList, "0", true);
//		
//		return list;
	}
	
	public static void main(String[] args) {
		
		List<Menu> list = getChildTreeMenuList();
		for (Menu menu : list) {
			System.out.println("1:"+menu.getName());
			if(menu.getChildList().size()>0){
				for (Menu menu2 : menu.getChildList()) {
					System.out.println("22222:"+menu2.getName());
				}
			}
		}
		
	}
}
