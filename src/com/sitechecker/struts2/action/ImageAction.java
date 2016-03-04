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
import com.sitechecker.domain.Images;
import com.sitechecker.domain.Inspect;
import com.sitechecker.service.ImageService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.Constant;
import com.sitechecker.utils.SCUtil;

@Controller("imageAction")
@Scope("prototype")
public class ImageAction extends BaseAction<Images> {

	@Resource(name = "imageService")
	private ImageService imageService;

	private File file;
	private String fileFileName;
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
	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
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

	public String addImg() throws IOException {
		System.out.println("图片的名字=" + this.fileFileName);
		System.out.println("自定义的文字=" + this.getModel().getName());
		String targetPath = ServletActionContext.getServletContext()
				.getRealPath(Constant.IMGPATH);
		File target = new File(targetPath, this.fileFileName);
		FileUtils.copyFile(file, target);// 前者是文件源，后者是文件复制的目标地址

		// Images image = this.getModel();
		// image.setName(this.fileName);
		// image.setUrl(Constant.IMGPATH + "/" + this.fileFileName);
		// Inspect inspect = new Inspect();
		// // System.out.println("图盘要绑定的任务id是"+this.inspectID);
		// inspect.setIid(3L);
		// image.setInspect(inspect);
		// image.setPublishTime(new Date());
		// image.setUser(SCUtil.getUserFromSession());
		
		Images image = this.getModel();
		image.setUrl(Constant.IMGPATH + "/" + this.fileFileName);
		Inspect inspect = new Inspect();
		inspect.setIsid(this.inspectID);
		image.setInspect(inspect);
		image.setPublishTime(new Date());
		image.setUser(SCUtil.getUserFromSession());

		this.imageService.addImage(image);
		return SUCCESS;
	}

	/**
	 * 上传文件的老方法
	 * 
	 * @return
	 * @throws Exception
	 */
	// public String addImg_old() throws Exception {
	// System.out.println("--->文件正在准备上床，当前的文件指定名字是"+fileName+"file="+file.getName());
	//
	// File uploadFile = new File(ServletActionContext.getServletContext()
	// .getRealPath("uploadimages"));
	//
	// if (!uploadFile.exists()) {
	// uploadFile.mkdir();
	// }
	//
	// FileInputStream input = new FileInputStream(file);
	// FileOutputStream out = new FileOutputStream(uploadFile + "\\"
	// + fileName + ".jpg");
	//
	// try {
	// byte[] b = new byte[1024];// 每次写入的大小
	// int i = 0;
	// while ((i = input.read(b)) > 0) {
	// out.write(b, 0, i);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if(input!=null){
	// input.close();
	// }
	// if(out!=null){
	// out.close();
	// }
	// }
	//
	// Images image = new Images();
	// image.setName(fileName);
	// image.setUrl("uploadimages/"+fileName+".jpg");
	// Inspect inspect = new Inspect();
	// inspect.setIid(3L);
	// image.setInspect(inspect);
	// image.setLongitude("116.37950086");
	// image.setLatitude("23.54799947");
	// image.setPublishTime(new Date());
	// image.setRemark("测试图片备注");
	// image.setUser(SCUtil.getUserFromSession());
	//
	// this.imageService.addImage(image);
	//
	// return SUCCESS;
	// }

	public String imgList() {

		Collection<Images> allImg = this.imageService.findAllImage();
		ActionContext.getContext().put("allImg", allImg);
		return imgList;
	}

	public String deleteByIid() throws IOException {

		Images img = this.imageService.findImgByIid(this.getModel().getIid());
		String targetImage = ServletActionContext.getServletContext()
				.getRealPath(img.getUrl());
		System.out.println("本次删除的图片文件是" + this.getModel().getUrl());
		SCUtil.deleteFile(targetImage);
		this.imageService.deleteImageByIid(img.getIid());
		System.out.println("文件删除成功。");
		return "action2action";
	}

	private static String imgList = "imgList";

}
