package com.qxcwl.jeewl.modules.sys.entity;

import com.qxcwl.jeewl.common.persistence.DataEntity;

import java.util.List;

/**
 * 角色
 *
 * @author quxiucheng
 * @ClassName Role
 * @Description
 * @date 2016/8/4 14:07:14
 */
public class Role extends DataEntity<Role> {

	private static final long serialVersionUID = -8403597962054113494L;
	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 角色英文名
	 */
	private String enname;

	/**
	 * 角色类型
	 */
	private String roleType;

	/**
	 * 是否启用
	 */
	private String useable;

	/**
	 * 菜单集合
	 */
	private List<Menu> menuList;


	/**
	 * 获取 角色名称
	 *
	 * @return name 角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 角色名称
	 *
	 * @param name 角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 角色英文名
	 *
	 * @return enname 角色英文名
	 */
	public String getEnname() {
		return enname;
	}

	/**
	 * 设置 英文名称
	 *
	 * @param enname 英文名称
	 */
	public void setEnname(String enname) {
		this.enname = enname;
	}

	/**
	 * 获取 角色类型
	 *
	 * @return roleType 角色类型
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * 设置 角色类型
	 *
	 * @param roleType 角色类型
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * 获取 是否启用
	 *
	 * @return useable 启用状态
	 */
	public String getUseable() {
		return useable;
	}

	/**
	 * 设置 启用状态
	 *
	 * @param useable 启用状态
	 */
	public void setUseable(String useable) {
		this.useable = useable;
	}

	/**
	 * 获取 菜单集合
	 * @return menuList 菜单集合
	 */
	public List<Menu> getMenuList() {
		return menuList;
	}

	/**
	 * 设置 菜单集合
	 * @param menuList 菜单集合
	 */
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
