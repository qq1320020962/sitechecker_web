package com.sitechecker.struts2.action;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sitechecker.domain.Image;
import com.sitechecker.domain.Inspect;
import com.sitechecker.service.ImageService;
import com.sitechecker.service.InspectService;
import com.sitechecker.service.result.ImageResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.SCUtil;

@Controller("imageAction")
@Scope("prototype")
public class ImageAction extends BaseAction<Image> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "imageService")
	private ImageService imageService;

	@Resource(name = "inspectService")
	private InspectService inspectService;

	private File file;
	private String fileContentType;
	private Long inspectID;

	public Long getInspectID() {
		return inspectID;
	}

	public void setInspectID(Long inspectID) {
		this.inspectID = inspectID;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String addImgUI() {
		return "addImgUI";
	}

	public String imgList() {

		Collection<Image> allImg = this.imageService.findAllImage();
		ActionContext.getContext().put("allImg", allImg);
		return "imgList";
	}

	public String deleteByIid() throws IOException {

		Image img = this.imageService.findImgByIid(this.getModel().getIid());
		String targetImage = ServletActionContext.getServletContext()
				.getRealPath(img.getUrl());
		System.out.println("本次删除的图片文件是" + this.getModel().getUrl());
		SCUtil.deleteFile(targetImage);
		this.imageService.deleteImageByIid(img.getIid());
		System.out.println("文件删除成功。");
		return "action2action";
	}

}
