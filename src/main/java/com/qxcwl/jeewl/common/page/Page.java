package com.qxcwl.jeewl.common.page;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Page<T> {
	
	/**
	 * 当前页码,默认为1
	 */
	private int pageNo = 1; 
	/**
	 * 页面大小,默认为10,"-1"表示不分页
	 */
	private int pageSize = 10;
	
	/**
	 * 记录数量
	 */
	private int count;
	
	/**
	 * 结果是否包含总记录数
	 */
	private boolean containsCount;
	
	/**
	 * 实际数据
	 */
	private List<T> list = new ArrayList<T>();
	
	/**
	 * 标准查询有效， 实例： updatedate desc, name asc
	 */
	private List<String> orderBys = new ArrayList<String>(); 

	/**
	 * 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
	 */
	private String pageFunctionName = "page";
	
	/**
	 * 函数的附加参数，第三个参数值。
	 */
	private String funcParam = "";
	
	private String message = ""; // 设置提示消息，显示在“共n条”之后

	/**
	 * 构造函数
	 * @Title Page
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月21日 上午10:36:45
	 */
	public Page() {
		//默认第一页
		this.pageNo = 1;
		//默认分页大小为10
		this.pageSize = 10;
	}
	/**
	 * 
	 * @Title Page
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月21日 上午10:38:57
	 * @param request
	 * @param response
	 */
	public Page(HttpServletRequest request, HttpServletResponse response){
		this(request, response, -2);
	}
	
	/**
	 * 
	 * @Title Page
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月21日 上午10:37:23
	 * @param request 传递 repage 参数，来记住页码
	 * @param response 用于设置 Cookie，记住页码
	 * @param defaultPageSize 默认分页大小，如果传递 -1 则为不分页，返回所有数据
	 */
	public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize){
		// 获取当前页码
		String pageNoStr = request.getParameter("paginator.page");
		// 获取分页大小
		String pageSizeStr = request.getParameter("paginator.limit");
		// 设置排序参数
		String orderBy = request.getParameter("orderBy");
		
		String totalPagesStr = request.getParameter("paginator.totalPages");
		
		String totalCountStr = request.getParameter("paginator.totalCount");
		
		if (pageNoStr == null || "".equals(pageNoStr)) {
			this.pageNo = Integer.valueOf(1);
		} else {
			this.pageNo = Integer.valueOf(pageNoStr);
		}
		if (pageSizeStr == null || "".equals(pageSizeStr)) {
			this.pageSize = Integer.valueOf(10);
		} else {
			this.pageSize = Integer.valueOf(pageSize);
		}

		if (totalPagesStr != null && !"".equals(totalPagesStr)) {
			int totalPages = Integer.valueOf(totalPagesStr);
			if (this.pageNo > totalPages) {
				this.pageNo = totalPages;
			}
		}
		if (totalCountStr != null && !"".equals(totalCountStr)) {
			int totalCount = Integer.valueOf(totalCountStr);
			if ((this.pageNo - 1) * this.pageSize > totalCount) {
				this.pageNo = 1;
			}
		}
		
	}
	
	public Page(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	/** 
	 * 获取当前页
	 * @return pageNo 当前页码
	 */
	public int getPageNo() {
		return pageNo;
	}
	/** 
	 * 设置当前页码
	 * @param pageNo 当前页码
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/** 
	 * 获取页面大小
	 * @return pageSize 页面大小
	 */
	public int getPageSize() {
		return pageSize;
	}
	/** 
	 * 设置页面大小
	 * @param pageSize 页面大小
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 
	 * 设置记录数量 
	 * @param count 记录数量 
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/** 
	 * 获取结果是否包含总记录数 
	 * @return containsCount 结果是否包含总记录数 
	 */
	public boolean isContainsCount() {
		return containsCount;
	}
	/** 
	 * 设置结果是否包含总记录数 
	 * @param containsCount 结果是否包含总记录数 
	 */
	public void setContainsCount(boolean containsCount) {
		this.containsCount = containsCount;
	}
	/** 
	 * 获取实际数据 
	 * @return list 实际数据 
	 */
	public List<T> getList() {
		return list;
	}
	/** 
	 * 设置实际数据 
	 * @param list 实际数据 
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	/** 
	 * 获取标准查询有效，实例：updatedate desc,name asc 
	 * @return orderBys 标准查询有效
	 */
	public List<String> getOrderBys() {
		return orderBys;
	}
	/** 
	 * 设置标准查询有效,实例：updatedate desc,name asc 
	 * @param orderBys 标准查询有效
	 */
	public void setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
	}
	
	/** 
	 * 获取设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。 
	 * @return pageFunctionName 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。 
	 */
	public String getPageFunctionName() {
		return pageFunctionName;
	}
	/** 
	 * 设置设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。 
	 * @param pageFunctionName 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。 
	 */
	public void setPageFunctionName(String pageFunctionName) {
		this.pageFunctionName = pageFunctionName;
	}
	/** 
	 * 获取函数的附加参数，第三个参数值。 
	 * @return funcParam 函数的附加参数，第三个参数值。 
	 */
	public String getFuncParam() {
		return funcParam;
	}
	/** 
	 * 设置函数的附加参数，第三个参数值。 
	 * @param funcParam 函数的附加参数，第三个参数值。 
	 */
	public void setFuncParam(String funcParam) {
		this.funcParam = funcParam;
	}
	/** 
	 * 获取message 
	 * @return message message 
	 */
	public String getMessage() {
		return message;
	}
	/** 
	 * 设置message 
	 * @param message message 
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/** 
	 * 获取首页索引 
	 * @return first 首页索引 
	 */
	public int getFirst() {
		return (this.pageNo - 1) * this.pageSize + 1;
	}
	
	/**
	 * 获取记录总页数
	 * @Title getCount
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:25:08
	 * @return
	 */
	public int getCount() {
		//没有数据则返回0
		/*if (list==null || list.size() <= 0) {
			return 0;
		}
		//分页大小小于0返回0
		if (this.pageSize <= 0) {
			return 0;
		}

		//总页数 除以 分页大小 为页码
		int count = list.size() / this.pageSize;
		
		//判断是否有下一页
		if (list.size() % this.pageSize > 0) {
			count++;
		}*/
		return this.count;
	}
	
	/** 
	 * 获取尾页索引 
	 * @return last 尾页索引 
	 */
	public int getLast() {
		//是否为第一页
		if(isFirstPage()){
			//分页大小 > 记录总数 返回记录总数
			if(this.pageSize > getCount()){
				return getCount();
			}
			//如果是第一页返回分页大小
			return this.pageSize;
		}
		//如果是最后一页
		else if(isLastPage()){
			//返回页码总数
			return getCount();
		}
		//其他页码
		else{
			//分页大小 > 记录总数 返回记录总数
			if(this.pageSize > getCount()){
				return getCount();
			}
			//第一页 + 记录总数 -1
			return getFirst() + getCount() -1;
		}
	}
	
	/**
	 * 获取总页数
	 * @Title getTotalPages
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月29日 下午5:47:06
	 * @return
	 */
	public int getTotalPages() {
		if (getCount() <= 0) {
			return 0;
		}
		if (getPageSize() <= 0) {
			return 0;
		}

		int count = (int)getCount() / getPageSize();
		if (getCount() % getPageSize() > 0) {
			count++;
		}
		return count;
	}
	
	/**
	 * 当前页码的第一个条数
	 * @Title getNowFirstCount
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月29日 下午5:34:17
	 * @return
	 */
	public int getNowFirstCount() {
		return (getPageNo() - 1) * getPageSize() + 1;
	}
	
	/**
	 * 当前页码的最后一条数
	 * @Title getNowLastCount
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月29日 下午5:37:26
	 * @return
	 */
	public int getNowLastCount() {
		if (isFirstPage()) {
			if (getPageSize() > getCount()) {
				return (int)getCount();
			}
			return getPageSize();
		} else if (isLastPage()) {
			return (int)getCount();
		} else {
			if (getPageSize() > getCount()) {
				return (int)getCount();
			}
			return getNowFirstCount() + getPageSize() - 1;
		}
	}
	
	/**
	 * 是否有上一页
	 * @Title isHasPrePage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:33:00
	 * @return
	 */
	public boolean isHasPrePage() {
		//页码数 - 1 大于 1,例如:第一页-1 = 0 没有上一页
		return (this.pageNo - 1 >= 1);
	}
	
	/**
	 * 是否有上一页
	 * @Title isHasNextPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:34:30
	 * @return
	 */
	public boolean isHasNextPage() {
		//页码数 + 1 大于 页码总数,例如:最后一页 +1 大于 总页数 没有上一页
		return (this.pageNo + 1 <= getCount());
	}

	/**
	 * 判断是否为第一页
	 * @Title isFirstPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:24:14
	 * @return
	 */
	public boolean isFirstPage() {
		//页码是否为第一页
		return this.pageNo <= 1;
	}
	
	/**
	 * 判断是否是最后一页
	 * @Title isLastPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:24:01
	 * @return
	 */
	public boolean isLastPage() {
		//页码是否大于总页数
		return this.pageNo >= getCount();
	}
	
	/**
	 * 获取上一页页码
	 * @Title getPrePage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:36:22
	 * @return
	 */
	public int getPrePage() {
		//是否有上一页
		if (isHasPrePage()) {
			return this.pageNo - 1;
		} else {
			return this.pageNo;
		}
	}

	/**
	 * 获取下一页页码
	 * @Title getNextPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:36:35
	 * @return
	 */
	public int getNextPage() {
		//判断是有下一页
		if (isHasNextPage()) {
			return this.pageNo + 1;
		} else {
			return this.pageNo;
		}
	}
	
	public Integer[] getSlider() {
		return slider(this.pageNo, getTotalPages(), 8);
	}
	
	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。 注意:不可以使用 getSlider(1)方法名称，因为在JSP中会与
	 * getSlider()方法冲突，报exception
	 * @Title slider
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:41:23
	 * @param slidersCount 页码框大小
	 * @return
	 */
	public Integer[] slider(int slidersCount) {
		return slider(this.pageNo, getTotalPages(), slidersCount);
	}
	
	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。 注意:不可以使用 getSlider(1)方法名称，因为在JSP中会与
	 * getSlider()方法冲突，报exception
	 * @Title slider
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:49:23
	 * @param pageNo 当前页码
	 * @param count 页码总数
	 * @param slidersCount 页码框大小
	 * @return
	 */
	public Integer[] slider(int pageNo, int count, int slidersCount) {
		//【1,2,3,[4],5,6,7,8】
		int avg = slidersCount / 2;
		//计算开始开始页码 : 4 - 4 = 0
		int startPageNumber = pageNo - avg;
		//页码框第一页 第一页为0 则设置为1
		if (startPageNumber <= 0) {
			startPageNumber = 1;
		}
		//计算结束页码 : 1 + 8 - 1 = 8
		int endPageNumber = startPageNumber + slidersCount - 1;
		//页码框最后一页
		if (endPageNumber > count ) {
			endPageNumber = count ;
		}
		//8 - 1 = 7 < 8
		//判断是否大于页码框
		if (endPageNumber - startPageNumber < slidersCount) {
			// 8 - 8 = 0
			startPageNumber = endPageNumber - slidersCount;
			if (startPageNumber <= 0) {
				//设置开始页码框
				startPageNumber = 1;
			}
		}
		//返回结果集合
		List<Integer> result = new ArrayList<Integer>();
		//【1,2,3,4,5,6,7,8】
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			result.add(new Integer((int)i));
		}
		return result.toArray(new Integer[result.size()]);
	}
	
	/**
	 * 计算最后的页码总数
	 * @Title computeLastPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午10:58:46
	 * @param pageSize
	 * @param count
	 * @return
	 */
	public static int computeLastPage(int pageSize, int totalItems){
		//分页大小为0 返回1
		if(pageSize <= 0){
			return 1;
		}
		int result = (int) (totalItems % pageSize == 0 ? totalItems / pageSize : totalItems / pageSize + 1);
		if (result <= 1){
			result = 1;
		}
		return result;
	}
	/**
	 * 获取页码总数
	 * @Title computeCount
	 * @Description 
	 * @author 曲修成
	 * @date 2016年9月22日 上午11:02:32
	 * @param page
	 * @param pageSize
	 * @param totalItems
	 * @return
	 */
	public static int computeCount(int page, int pageSize, int totalItems) {
		if (page <= 1) {
			return 1;
		}
		
		if (Integer.MAX_VALUE == page || page > computeLastPage(pageSize, totalItems)) { // last
																								// page
			return computeLastPage(pageSize, totalItems);
		}
		return page;
	}
	
	/**
	 * 获取 Hibernate FirstResult
	 */
	public int getFirstResult() {
		int firstResult = (getPageNo() - 1) * getPageSize();
		if (firstResult >= getCount()) {
			firstResult = 0;
		}
		return firstResult;
	}
	
	/**
	 * 获取 Hibernate MaxResults
	 */
	public int getMaxResults(){
		return getPageSize();
	}
	
//	/**
//	 * 获取 Spring data JPA 分页对象
//	 */
//	public Pageable getSpringPage(){
//		List<Order> orders = new ArrayList<Order>();
//		if (orderBy!=null){
//			for (String order : StringUtils.split(orderBy, ",")){
//				String[] o = StringUtils.split(order, " ");
//				if (o.length==1){
//					orders.add(new Order(Direction.ASC, o[0]));
//				}else if (o.length==2){
//					if ("DESC".equals(o[1].toUpperCase())){
//						orders.add(new Order(Direction.DESC, o[0]));
//					}else{
//						orders.add(new Order(Direction.ASC, o[0]));
//					}
//				}
//			}
//		}
//		return new PageRequest(this.pageNo - 1, this.pageSize, new Sort(orders));
//	}
//	
//	/**
//	 * 设置 Spring data JPA 分页对象，转换为本系统分页对象
//	 */
//	public void setSpringPage(org.springframework.data.domain.Page<T> page){
//		this.pageNo = page.getNumber();
//		this.pageSize = page.getSize();
//		this.count = page.getTotalElements();
//		this.list = page.getContent();
//	}
	
}
