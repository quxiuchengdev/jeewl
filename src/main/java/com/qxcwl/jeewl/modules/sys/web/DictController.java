package com.qxcwl.jeewl.modules.sys.web;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qxcwl.jeewl.modules.sys.entity.User;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qxcwl.jeewl.common.controller.BaseController;
import com.qxcwl.jeewl.common.mapper.JsonMapper;
import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;
import com.qxcwl.jeewl.common.utils.StringUtils;
import com.qxcwl.jeewl.modules.sys.entity.Dict;
import com.qxcwl.jeewl.modules.sys.service.DictService;


@Controller
@RequestMapping(value = "${adminPath}/sys/dict")
public class DictController extends BaseController{
	
	@Autowired
	private DictService dictService;
	
	@ModelAttribute("dict")
	public Dict get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return dictService.get(id);
		}else{
			return new Dict();
		}
	}
	
	@RequestMapping(value = {"list",""})
	public String list(Dict dict ,HttpServletRequest request, HttpServletResponse response,Model model){
		return "modules/sys/dictList";
	}
	
	@RequestMapping(value = "form")
	public String form(Dict dict,HttpServletRequest request, HttpServletResponse response,Model model){
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}
	
	@RequestMapping(value = "add")
	public String add(Dict dict,HttpServletRequest request, HttpServletResponse response,Model model){
		dict.setId(null);
		dict.setValue(null);
		dict.setLabel(null);
		dict.setSort(dict.getSort()+10);
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}
	
	@RequestMapping(value = "save")
	public String save(Dict dict, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if(StringUtils.isEmpty(dict.getId())){
			dict.setDelFlag(DataEntity.DEL_FLAG_NORMAL);
			dict.setId(UUID.randomUUID().toString().replace("-", ""));
			dict.setUpdateDate(new Date());
			dict.setCreateDate(new Date());
			dict.setUpdateBy(new User("1"));
			dict.setCreateBy(new User("1"));
			dictService.insert(dict);
		}else{
			dict.setUpdateDate(new Date());
			dict.setUpdateBy(new User("1"));
			dictService.update(dict);
		}
		return "redirect:" + adminPath + "/sys/dict/list?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Dict dict, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		dictService.delete(dict);
		return "redirect:" + adminPath + "/sys/dict/list?repage";
	}
	
	@ResponseBody
	@RequestMapping(value = "datatables")
	public String datatables(Dict dict, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(required=false,defaultValue="10") int iDisplayStart ,
			@RequestParam(required=false,defaultValue="1") int iDisplayLength) {
		 //定义列名
        String[] sortCols = {"", "value", "label", "type", "sort","description"};
		String sEcho = request.getParameter("sEcho");
		
		String iSortCol_0 = request.getParameter("iSortCol_0");
		String sSortDir_0 = request.getParameter("sSortDir_0");
		
		String sSearch = request.getParameter("sSearch");
		String iTotalRecords = request.getParameter("iTotalRecords");
		String iTotalDisplayRecords = request.getParameter("iTotalDisplayRecords");
		String aaData = request.getParameter("aaData");
		String sColumns = request.getParameter("sColumns");
		
		/*List<Order> orderList = Lists.newArrayList();
		//排序
		if(StringUtils.isNotEmpty(iSortCol_0)){
			String sortCol = sortCols[Integer.valueOf(iSortCol_0)];
			if(StringUtils.isNotEmpty(sortCol)){
				Order order = new Order(sortCol, Direction.fromString(sSortDir_0), "");
				orderList.add(order);			
			}
		}*/
		
		//System.out.println(StreamUtils.byteTOString(sSearch.getBytes()));
		//全局搜索
		if(StringUtils.isNotEmpty(sSearch)){
			dict.setGlobalSearch(sSearch);
		}
		Page<Dict> dictPage = dictService.findPage(new Page<Dict>(getPage(iDisplayStart, iDisplayLength),getLimit(iDisplayLength)), dict);
		//System.out.println(dictPage);
		//PageList<Dict> list= dictService.findPage(new Paginator(getPage(iDisplayStart, iDisplayLength),getLimit(iDisplayLength),orderList,true), dict);
		//Paginator paginator = list.getPaginator();
		
		JSONObject json = new JSONObject();
        json.put("aaData", JsonMapper.toJsonString(dictPage.getList()));
        json.put("iTotalRecords", dictPage.getCount());
        json.put("iTotalDisplayRecords", dictPage.getCount());
        json.put("sEcho", sEcho);
		return json.toString();
	}
	
}
