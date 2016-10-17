package com.qxcwl.jeewl.modules.sys.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.qxcwl.jeewl.common.controller.BaseController;
import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;
import com.qxcwl.jeewl.common.utils.StringUtils;
import com.qxcwl.jeewl.modules.sys.entity.Menu;
import com.qxcwl.jeewl.modules.sys.service.MenuService;

@Controller
@RequestMapping(value = "${adminPath}/sys/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	@ModelAttribute("menu")
	public Menu get(@RequestParam(required = false) String id) {
		if (StringUtils.isNotBlank(id)) {
			return menuService.get(id);
		} else {
			return new Menu();
		}
	}

	@RequestMapping(value = { "list", "" })
	public String list(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {
		// com.github.miemiedev.mybatis.paginator.domain.Paginator
		// List<Menu> menuList = UserUtils.getMenuList();

		// Paginator paginator = pageList.getPaginator();
		// if(paginator==null){
		// paginator = new Paginator(0, 5, 20);
		// }
		// paginator.getEndRow();
		// paginator.getStartRow();
		// //pageList.getPaginator().
		Page<Menu> pageList = menuService.findPage(new Page(request, response,-1), new Menu());
		List<Menu> list = Lists.newArrayList();
		List<Menu> sourcelist = Lists.newArrayList();
		sourcelist = Menu.sortAscList(pageList.getList());
		Menu.sortList(list, sourcelist, "1");
		model.addAttribute("list", list);
		//model.addAttribute("paginator", list.getPaginator());
		// model.addAttribute("paginator", paginator);
		return "modules/sys/menuList";
	}

	@RequestMapping(value = "form")
	public String form(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(menu.getParent()!=null&&StringUtils.isNotEmpty(menu.getParent().getId())){
			Menu parent = menuService.get(menu.getParent().getId());
			menu.setParent(parent);
		}
		model.addAttribute("menu", menu);
		return "modules/sys/menuForm";
	}
	
	@RequestMapping(value = "save")
	public String save(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isEmpty(menu.getId())){
			menu.setDelFlag(DataEntity.DEL_FLAG_NORMAL);
			menu.setId(UUID.randomUUID().toString().replace("-", ""));
			Menu parent = menuService.get(menu.getParent().getId());
			menu.setParentIds(parent.getParentIds()+menu.getId()+",");
			menu.setParent(parent);
			menuService.insert(menu);
		}else{
			Menu parent = menuService.get(menu.getParent().getId());
			menu.setParent(parent);
			menu.setParentIds(parent.getParentIds()+menu.getId()+",");
			menuService.update(menu);
		}
		model.addAttribute("menu", menu);
		return "redirect:" + adminPath + "/sys/menu/";
	}
	

	@ResponseBody
	@RequestMapping(value = "treeview")
	public String treeview(String parentId,Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Menu> menuList = menuService.findList(new Menu());
		JSONArray ja = new JSONArray();
		for (Menu menu2 : menuList) {
			JSONObject jo = new JSONObject();
			
			jo.put("id", menu2.getId());
			jo.put("pId", menu2.getParent().getId());
			jo.put("name", menu2.getName());
			
			ja.put(jo);
		}
		return ja.toString();
	}
	

}
