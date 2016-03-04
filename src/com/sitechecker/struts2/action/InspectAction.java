package com.sitechecker.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.Images;
import com.sitechecker.domain.Inspect;
import com.sitechecker.domain.User;
import com.sitechecker.service.ImageService;
import com.sitechecker.service.InspectService;
import com.sitechecker.service.UserService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.Constant;
import com.sitechecker.utils.SCUtil;

@Controller("inspectAction")
@Scope("prototype")
public class InspectAction extends BaseAction<Inspect> {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="inspectService")
	private InspectService inspectService;
	
	@Resource(name="imageService")
	private ImageService imageService;
	
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	private int[] uids;
	public int[] getUids() {
		return uids;
	}
	public void setUids(int[] uids) {
		this.uids = uids;
	}
	
	private Long imgID;
	public Long getImgID() {
		return imgID;
	}
	public void setImgID(Long imgID) {
		this.imgID = imgID;
	}
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String addInspectUI(){
		Collection allUser = this.userService.findAllUser();
		ServletActionContext.getContext().put("allUser", allUser);
		return addInspectUI;
	}
	
	public String addInspect(){
		Inspect inspect = this.getModel();
		this.inspectService.addInspect(inspect, uids);
		return SUCCESS;
	}
	
	public String listInspect(){
		Collection<Inspect> inspects = this.inspectService.findInspect_page(Constant.PAGESIZE, this.page-1);
		int entryCount = this.inspectService.findEntryCount();
		ServletActionContext.getContext().put("inspect_page", inspects);
		ServletActionContext.getContext().put("entryCount", entryCount);
		ServletActionContext.getContext().put("navCount", Constant.NAVCOUNT);
		ServletActionContext.getContext().put("pageCount", SCUtil.getPageCount(entryCount));
		return listInspect;
	}
	
	public String updateByIsidUI(){
		Inspect inspect = this.inspectService.findInspectByIsid(this.getModel().getIsid());
		Collection<User> allUser = this.userService.findAllUser();
		ServletActionContext.getContext().put("inspect", inspect);
		ServletActionContext.getContext().put("allUser", allUser);
		return "updateByIsidUI";
	}
	
	public String updateByIsid(){
		Inspect inspect = this.getModel();
		this.inspectService.updateInspect(inspect, uids);
		return SUCCESS;
	}
	
	public String deleteByIsid(){
		this.inspectService.deleteInspectByIsid(this.getModel().getIsid());
		return action2action;
	}
	
	public String showInspectByIsid(){
		ServletActionContext.getContext().put("isid", this.getModel().getIsid());
		return showInspect;
	}
	
	public String showInspectLeft(){
		Inspect inspect = this.inspectService.findInspectByIsid(this.getModel().getIsid());
		System.out.println("任务所含有的图片数量="+inspect.getImgs().size());
		ServletActionContext.getContext().put("inspect", inspect);
		return showInspectLeft;
	}
	
	public String showInspectRight(){
		Images image = this.imageService.findImgByIid(this.imgID);
		ServletActionContext.getContext().put("image", image);
		return showInspectRight;
	}
	
	public String showInpsectsByUsername(){
		User user = this.userService.findUserByUsername(this.username);
		Collection<Inspect> inspects = user.getInspects();
		int entryCount = inspects.size();
		ServletActionContext.getContext().put("inspect_page", inspects);
		ServletActionContext.getContext().put("entryCount", entryCount);
		ServletActionContext.getContext().put("navCount", Constant.NAVCOUNT);
		ServletActionContext.getContext().put("pageCount", SCUtil.getPageCount(entryCount));
		return listInspect;
	}
	
	private static String listInspect = "listInspect";
	private static String addInspectUI = "addInspectUI";
	private static String action2action = "action2action";
	private static String showInspect = "showInspect";
	private static String showInspectLeft = "showInspectLeft";
	private static String showInspectRight = "showInspectRight";
}
