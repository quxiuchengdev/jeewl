package com.qxcwl.jeewl.modules.sys.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.qxcwl.jeewl.common.persistence.DataEntity;


public class Menu extends DataEntity<Menu> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 父级菜单
	 */
	private Menu parent;
	
	/**
	 * 菜单名称
	 */
	private String name;
	
	/**
	 * 菜单连接
	 */
	private String href;
	
	/**
	 * 权限
	 */
	private String permission;
	
	/**
	 * 菜单图标
	 */
	private String icon;
	
	/**
	 * 是否显示
	 */
	private String isShow;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 级别
	 */
	private String level;
	
	/**
	 * 所有父级菜单ID
	 */
	private String parentIds;
	
	/**
	 * 子菜单
	 */
	private List<Menu> childList;
	
	public Menu() {
		super();
	}

	public Menu(String id) {
		super(id);
	}
	
	
	public Menu(Menu parent) {
		this.parent = parent;
	}

	/** 
	 * 获取父级菜单 
	 * @return parent 父级菜单 
	 */
	public Menu getParent() {
		return parent;
	}

	/** 
	 * 设置父级菜单 
	 * @param parent 父级菜单 
	 */
	public void setParent(Menu parent) {
		this.parent = parent;
	}

	/** 
	 * 获取菜单名称 
	 * @return name 菜单名称 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * 设置菜单名称 
	 * @param name 菜单名称 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * 获取菜单连接 
	 * @return href 菜单连接 
	 */
	public String getHref() {
		return href;
	}

	/** 
	 * 设置菜单连接 
	 * @param href 菜单连接 
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/** 
	 * 获取权限 
	 * @return permission 权限 
	 */
	public String getPermission() {
		return permission;
	}

	/** 
	 * 设置权限 
	 * @param permission 权限 
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/** 
	 * 获取菜单图标 
	 * @return icon 菜单图标 
	 */
	public String getIcon() {
		return icon;
	}

	/** 
	 * 设置菜单图标 
	 * @param icon 菜单图标 
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/** 
	 * 获取是否显示 
	 * @return isShow 是否显示 
	 */
	public String getIsShow() {
		return isShow;
	}

	/** 
	 * 设置是否显示 
	 * @param isShow 是否显示 
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	/** 
	 * 获取排序 
	 * @return sort 排序 
	 */
	public Integer getSort() {
		return sort;
	}

	/** 
	 * 设置排序 
	 * @param sort 排序 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/** 
	 * 获取级别 
	 * @return level 级别 
	 */
	public String getLevel() {
		return level;
	}

	/** 
	 * 设置级别 
	 * @param level 级别 
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/** 
	 * 获取所有父级菜单ID 
	 * @return parentIds 所有父级菜单ID 
	 */
	public String getParentIds() {
		return parentIds;
	}

	/** 
	 * 设置所有父级菜单ID 
	 * @param parentIds 所有父级菜单ID 
	 */
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	/** 
	 * 获取子菜单 
	 * @return childList 子菜单 
	 */
	public List<Menu> getChildList() {
		return childList;
	}

	/** 
	 * 设置子菜单 
	 * @param childList 子菜单 
	 */
	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

	public String getParentId() {
		if(this.parent==null){
			return "0";
		}else{
			return parent.id;
		}
	}
	
	/**
	 * 排序
	 * @Title sortList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月24日 下午5:37:27
	 * @param list
	 * @param sourcelist
	 * @param parentId 父ID
	 * @param cascade 是否递归
	 */
	public static void treeList(List<Menu> list, List<Menu> sourcelist, String parentId, boolean cascade){
		for (int i=0; i<sourcelist.size(); i++){
			Menu e = sourcelist.get(i);
			if (e.getParent()!=null && e.getParent().getId()!=null
					&& e.getParent().getId().equals(parentId)){
				list.add(e);
				if (cascade){
					// 判断是否还有子节点, 有则继续获取子节点
					for (int j=0; j<sourcelist.size(); j++){
						Menu child = sourcelist.get(j);
						if (child.getParent()!=null && child.getParent().getId()!=null
								&& child.getParent().getId().equals(e.getId())){
							treeList(list, sourcelist, e.getId(), true);
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * 遍历添加子菜单
	 * @Title treeChildList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月24日 下午6:01:06
	 * @param sourcelist
	 * @param parentId
	 * @return
	 */
	public static List<Menu> treeChildList(List<Menu> sourcelist, String parentId){
		List<Menu> childList = Lists.newArrayList();
				
		for (int i=0; i<sourcelist.size(); i++){
			Menu e = sourcelist.get(i);
			if(e.getParent()!=null && e.getParent().getId()!=null && e.getParent().getId().equals(parentId)) {
				List<Menu> childListTemp = treeChildList(sourcelist, e.getId());
				e.setChildList(childListTemp);
				childList.add(e);
			}
		}
		return childList;
	}
	
	/**
	 * 按照sort排序(升序)
	 * @Title sortList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月24日 下午5:42:40
	 * @param list
	 */
	public static List<Menu> sortAscList(List<Menu> list) {
		
		Collections.sort(list, new Comparator<Menu>() {
			public int compare(Menu menu1, Menu menu2) {
				return menu1.getSort().compareTo(menu2.getSort());
			}
		});
		return list;
	}
	
	/**
	 * 按照sort排序(降序)
	 * @Title sortList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月24日 下午5:42:40
	 * @param list
	 */
	public static List<Menu> sortDescList(List<Menu> list) {
		
		Collections.sort(list, new Comparator<Menu>() {
			public int compare(Menu menu1, Menu menu2) {
				return -menu1.getSort().compareTo(menu2.getSort());
			}
		});
		return list;
	}

	/**   
	 * @Title toString
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月28日 上午11:11:13
	 * @see java.lang.Object#toString()
	 * @return
	 */
	@Override
	public String toString() {
		return "Menu [name=" + name + ", href=" + href + ", permission=" + permission + ", isShow=" + isShow + ", parentIds=" + parentIds + "]";
	}
	/**
	 * 获取菜单根目录
	 */
	public static String getRootId() {
		return "1";
	}
	
	/**
	 * 生成树菜单
	 * @Title getTreeMenuList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月5日 上午9:52:00
	 * @param menuList
	 * @return
	 */
	public static List<Menu> getTreeMenuList(List<Menu> menuList) {
		List<Menu> list = treeList(menuList, Menu.getRootId());
		return list;
	}
	
	/**
	 * 生成菜单树
	 * @Title treeList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年6月9日 上午11:29:36
	 * @param list
	 * @param sourcelist
	 * @param parentId
	 * @param cascade
	 */
	public static List<Menu> treeList(List<Menu> sourcelist, String parentId){
		List<Menu> childList = new ArrayList<Menu>();
		for (int i=0; i<sourcelist.size(); i++){
			Menu e = sourcelist.get(i);
			if(e.getParent()!=null && e.getParent().getId()!=null && e.getParent().getId().equals(parentId)) {
				List<Menu> childListTemp = treeList(sourcelist, e.getId());
				e.setChildList(childListTemp);
				childList.add(e);
			}
		}
		return childList;
	}
	
	public static void sortList(List<Menu> list, List<Menu> sourcelist, String parentId){
		for (int i=0; i<sourcelist.size(); i++){
			Menu e = sourcelist.get(i);
			if (e.getParent()!=null && e.getParent().getId()!=null
					&& e.getParent().getId().equals(parentId)){
				list.add(e);
				// 判断是否还有子节点, 有则继续获取子节点
				for (int j=0; j<sourcelist.size(); j++){
					Menu child = sourcelist.get(j);
					if (child.getParent()!=null && child.getParent().getId()!=null
							&& child.getParent().getId().equals(e.getId())){
						sortList(list, sourcelist, e.getId());
						break;
					}
				}
			}
		}
	}
	
}
