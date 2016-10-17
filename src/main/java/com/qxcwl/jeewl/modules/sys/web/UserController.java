package com.qxcwl.jeewl.modules.sys.web;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qxcwl.jeewl.common.controller.BaseController;
import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;
import com.qxcwl.jeewl.common.utils.StringUtils;
import com.qxcwl.jeewl.modules.sys.entity.User;
import com.qxcwl.jeewl.modules.sys.service.UserService;

@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return userService.get(id);
		}else{
			return new User();
		}
	}
	
	@RequestMapping(value = {"list",""})
	public String list(User user ,HttpServletRequest request, HttpServletResponse response,Model model){
		//PageList<User> list= userService.findPage(new Paginator(request,true), new User());
		Page<User> page= userService.findPage(new Page(request,response), new User());
		model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		return "modules/sys/userList";
	}
	
	@RequestMapping(value = "form")
	public String form(User user,HttpServletRequest request, HttpServletResponse response,Model model){
		model.addAttribute("user", user);
		return "modules/sys/userForm";
	}
	
	@RequestMapping(value = "save")
	public String save(User user, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		user.setDelFlag(DataEntity.DEL_FLAG_NORMAL);
		user.setStatus(User.STATUS.NORMAL.toString());
		if(StringUtils.isEmpty(user.getId())){
			user.setId(UUID.randomUUID().toString().replace("-", ""));
			userService.insert(user);
		}else{
			userService.update(user);
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}
	
	@ResponseBody
	@RequestMapping(value = "datatables")
	public String datatables(User user, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
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
		
		Page<User> list= userService.findPage(new Page(getPage(iDisplayStart, iDisplayLength),iDisplayLength), new User());
	//	Paginator paginator = list.getPaginator();
		JSONArray jsonArray = new JSONArray();
		for (User u : list.getList()) {
			JSONObject j = new JSONObject();
        	j.put("nickname", u.getNickname());
        	j.put("username", u.getUsername()==null?"":u.getUsername());
        	j.put("mobileNumber", u.getMobileNumber()==null?"":u.getMobileNumber());
        	j.put("regisTime", u.getRegisTime()==null?"":u.getRegisTime());
        	j.put("status", u.getStatus()==null?"":u.getStatus());
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
	
	
}
