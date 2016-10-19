package com.qxcwl.jeewl.modules.sys.web;

import com.google.common.collect.Lists;
import com.qxcwl.jeewl.common.controller.BaseController;
import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;
import com.qxcwl.jeewl.common.utils.StringUtils;
import com.qxcwl.jeewl.modules.sys.entity.Dict;
import com.qxcwl.jeewl.modules.sys.entity.Menu;
import com.qxcwl.jeewl.modules.sys.entity.Role;
import com.qxcwl.jeewl.modules.sys.entity.User;
import com.qxcwl.jeewl.modules.sys.service.MenuService;
import com.qxcwl.jeewl.modules.sys.service.RoleService;
import com.qxcwl.jeewl.modules.sys.utils.DictUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "${adminPath}/sys/role")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;
	
	@ModelAttribute("role")
	public Role get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return roleService.get(id);
		}else{
			return new Role();
		}
	}
	
	@RequestMapping(value = {"list",""})
	public String list(Role role ,HttpServletRequest request, HttpServletResponse response,Model model){
		//PageList<Role> list= roleService.findPage(new Paginator(request,true), new Role());
		Page<Role> page= roleService.findPage(new Page(request,response), new Role());
		model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		return "modules/sys/roleList";
	}
	
	@RequestMapping(value = "form")
	public String form(Role role,HttpServletRequest request, HttpServletResponse response,Model model){
		model.addAttribute("role", role);
		return "modules/sys/roleForm";
	}
	
	@RequestMapping(value = "save")
	public String save(Role role, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		String menuIds = request.getParameter("menuIds");
		if(StringUtils.isNotEmpty(menuIds)){
			List<Menu> menuList = Lists.newArrayList();
			String[] menuIdArr = menuIds.split(",");
			for (String menuId : menuIdArr) {
				Menu menu = menuService.get(menuId);
				menuList.add(menu);
			}
			role.setMenuList(menuList);
		}
		role.setDelFlag(DataEntity.DEL_FLAG_NORMAL);
		if(StringUtils.isEmpty(role.getId())){
			role.setId(UUID.randomUUID().toString().replace("-", ""));
			role.setUpdateDate(new Date());
			role.setCreateDate(new Date());
			role.setUpdateBy(new User("1"));
			role.setCreateBy(new User("1"));
			roleService.insert(role);
		}else{
			role.setUpdateDate(new Date());
			role.setUpdateBy(new User("1"));
			roleService.update(role);
		}
		return "redirect:" + adminPath + "/sys/role/list?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Role role, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		roleService.delete(role);
		return "redirect:" + adminPath + "/sys/role/list?repage";
	}

	@ResponseBody
	@RequestMapping(value = "datatables")
	public String datatables(Role role, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(required=false,defaultValue="10") int iDisplayStart ,
			@RequestParam(required=false,defaultValue="1") int iDisplayLength) {
		
		String sEcho = request.getParameter("sEcho");
		//String iDisplayStart = request.getParameter("iDisplayStart");
		//String iDisplayLength = request.getParameter("iDisplayLength");
		String iSortCol_0 = request.getParameter("iSortCol_0");
		String sSortDir_0 = request.getParameter("sSortDir_0");
		String sSearch = request.getParameter("sSearch");
		String iTotalRecords = request.getParameter("iTotalRecords");
		String iTotalDisplayRecords = request.getParameter("iTotalDisplayRecords");
		String aaData = request.getParameter("aaData");
		String sColumns = request.getParameter("sColumns");
		
		Page<Role> list= roleService.findPage(new Page(getPage(iDisplayStart, iDisplayLength),iDisplayLength), new Role());
	//	Paginator paginator = list.getPaginator();
		JSONArray jsonArray = new JSONArray();
		for (Role r : list.getList()) {
			JSONObject j = new JSONObject();
        	j.put("name", r.getName());
        	j.put("enname", r.getEnname());
        	j.put("roleType", r.getRoleType());
        	j.put("useable", DictUtils.getDictLabel(r.getUseable(),"sys_is_able",""));
        	j.put("remarks", r.getRemarks());
        	j.put("id", r.getId());
        	//j.put("status", u.getStatus()==null?"":u.getStatus());
        	jsonArray.put(j);
		}
		JSONObject json = new JSONObject();
        json.put("aaData", jsonArray.toString());
        json.put("iTotalRecords", list.getCount());
        json.put("iTotalDisplayRecords", list.getCount());
        json.put("sEcho", sEcho);
       // json.put("pageNo", paginator.getPage());
       // json.put("pageSize", paginator.getTotalPages());
		return json.toString();
	}

	@ResponseBody
	@RequestMapping(value = "treeview")
	public String treeview(String roleId, HttpServletRequest request, HttpServletResponse response, Model model) {
		Role role = roleService.get(roleId);
		List<Menu> menuList = menuService.findList(new Menu());
		JSONArray ja = new JSONArray();
		for (Menu menu : menuList) {
			JSONObject jo = new JSONObject();

			jo.put("id", menu.getId());
			jo.put("pId", menu.getParent().getId());
			jo.put("name", menu.getName());

			ja.put(jo);
		}

		JSONArray roleMenuList = new JSONArray();
		if (role != null) {
			for (Menu menu : role.getMenuList()) {
				JSONObject jo = new JSONObject();
				//menu = menuService.get(menu.getId());
				jo.put("id", menu.getId());
				jo.put("pId", menu.getParent().getId());
				jo.put("name", menu.getName());

				roleMenuList.put(jo);
			}
		}
		JSONObject result = new JSONObject();
		result.put("menuList",ja);
		result.put("roleMenuList",roleMenuList);
		return result.toString();
	}
	
	
}
