package com.qxcwl.jeewl.modules.sys.entity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.qxcwl.jeewl.common.persistence.DataEntity;
import com.qxcwl.jeewl.common.utils.Collections3;

public class User extends DataEntity<User> {

	private static final long serialVersionUID = 4085897603399160506L;
	
	/**
	 * 系统昵称
	 */
	private String nickname;

	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 身份证
	 */
	private String idCard;
	
	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 性别
	 * @ClassName SEX
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午9:43:40
	 */
	public static enum SEX {
		MALE,//男性
		FAMALE//女性
	}
	
	/**
	 * 手机号
	 */
	private String mobileNumber;
	
	/**
	 * 手机号
	 */
	private String telephone;
	
	/**
	 * 用户状态
	 */
	private String status;
	
	/**
	 * 用户状态
	 * @ClassName STATUS
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:04:06
	 */
	public static enum STATUS {
		LOCK , //用户锁定
		REGISTER ,//注册中
		NORMAL//正常状态
	}
	
	/**
	 * 编号
	 */
	private String number;
	
	/**
	 * 用户类型
	 */
	private String userType;
	
	/**
	 * 用户类型
	 * @ClassName USERTYPE
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:08:00
	 */
	public static enum USERTYPE {
		VISITOR , //游客用户
		NORMAL,//正常用户
		ADMIN //管理员用户
	}
	
	
	/**
	 * 上次登录IP
	 */
	private String lastLoginIp;
	
	/**
	 * 上次登录日期
	 */
	private Date lastLoginDate;
	
	/**
	 * 注册时间
	 */
	private Date regisTime;
	
	/**
	 * 注册地点
	 */
	private String regisPlace;

	private List<Role> roleList;

	public User() {
	}

	public User(String id) {
		super(id);
	}

	/**
	 * 获取系统昵称 
	 * @return nickname 系统昵称 
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 设置系统昵称 
	 * @param nickname 系统昵称 
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/** 
	 * 获取用户名 
	 * @return username 用户名 
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 * 设置用户名 
	 * @param username 用户名 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** 
	 * 获取密码 
	 * @return password 密码 
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * 设置密码 
	 * @param password 密码 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * 获取邮箱 
	 * @return email 邮箱 
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * 设置邮箱 
	 * @param email 邮箱 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * 获取手机号 
	 * @return mobileNumber 手机号 
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/** 
	 * 设置手机号 
	 * @param mobileNumber 手机号 
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/** 
	 * 获取手机号 
	 * @return telephone 手机号 
	 */
	public String getTelephone() {
		return telephone;
	}

	/** 
	 * 设置手机号 
	 * @param telephone 手机号 
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** 
	 * 获取用户状态 
	 * @return status 用户状态 
	 */
	public String getStatus() {
		return status;
	}

	/** 
	 * 设置用户状态 
	 * @param status 用户状态 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/** 
	 * 获取编号 
	 * @return number 编号 
	 */
	public String getNumber() {
		return number;
	}

	/** 
	 * 设置编号 
	 * @param number 编号 
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/** 
	 * 获取用户类型 
	 * @return userType 用户类型 
	 */
	public String getUserType() {
		return userType;
	}

	/** 
	 * 设置用户类型 
	 * @param userType 用户类型 
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/** 
	 * 获取上传登录IP 
	 * @return lastLoginIp 上传登录IP 
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/** 
	 * 设置上传登录IP 
	 * @param lastLoginIp 上传登录IP 
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/** 
	 * 获取上册登录日期 
	 * @return lastLoginDate 上册登录日期 
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/** 
	 * 设置上册登录日期 
	 * @param lastLoginDate 上册登录日期 
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/** 
	 * 获取注册时间 
	 * @return regisTime 注册时间 
	 */
	public Date getRegisTime() {
		return regisTime;
	}

	/** 
	 * 设置注册时间 
	 * @param regisTime 注册时间 
	 */
	public void setRegisTime(Date regisTime) {
		this.regisTime = regisTime;
	}

	/** 
	 * 获取注册地点 
	 * @return regisPlace 注册地点 
	 */
	public String getRegisPlace() {
		return regisPlace;
	}

	/** 
	 * 设置注册地点 
	 * @param regisPlace 注册地点 
	 */
	public void setRegisPlace(String regisPlace) {
		this.regisPlace = regisPlace;
	}

	/** 
	 * 获取身份证 
	 * @return idCard 身份证 
	 */
	public String getIdCard() {
		return idCard;
	}

	/** 
	 * 设置身份证 
	 * @param idCard 身份证 
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/** 
	 * 获取性别 
	 * @return sex 性别 
	 */
	public String getSex() {
		return sex;
	}

	/** 
	 * 设置性别 
	 * @param sex 性别 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取 角色集合
	 * @return roleList 角色集合
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 设置 角色集合
	 * @param roleList 角色集合
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 获取角色ID集合,用逗号,分隔
	 * @return
	 */
	public String getRoleListIdsStr(){
		if(null != roleList){
			return Collections3.extractToString(roleList, "id", ",");
		}else{
			return "";
		}

	}
}
