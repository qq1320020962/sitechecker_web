package com.sitechecker.struts2.action.mobile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.Image;
import com.sitechecker.domain.NewMsg;
import com.sitechecker.domain.User;
import com.sitechecker.service.ImageService;
import com.sitechecker.service.InspectService;
import com.sitechecker.service.NewMsgService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.ImageResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.ConstantUtil;

@Controller("mobileImageAction")
@Scope("prototype")
public class MobileImageAction extends BaseAction<Image> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "inspectService")
	private InspectService inspectService;

	@Resource(name = "imageService")
	private ImageService imageService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="newMsgService")
	private NewMsgService newMsgService;

	private File file;
	private String fileFileName;
	private String fileContentType;
	private Long inspectID;
	private Long uid;

	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
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
	public Long getInspectID() {
		return inspectID;
	}
	public void setInspectID(Long inspectID) {
		this.inspectID = inspectID;
	}

	public void addImg() throws IOException {
		
		System.out.println("id为"+this.uid+"的用户准备上传一张图片");
		System.out.println("this.file=" + this.file);
		System.out.println("this.fileFileName=" + this.fileFileName);
		//String imgFormat = this.fileFileName.substring(this.fileFileName.charAt('.'));
		String imgFormat = "jpg";
		System.out.println("imgFormat=" + imgFormat);
		
		Image image = this.getModel();
		image.setInspect(this.inspectService.findInspectByIsid(this.inspectID));
		ImageResult imageResult = this.imageService.validateImage(image,
				this.file, imgFormat);
		if (imageResult.getResult() == RESULT.SUCCESS) {
			String time = String.valueOf(System.currentTimeMillis());// 图片上传后生成的随机名字
			String targetPath = ServletActionContext.getServletContext()
					.getRealPath(ConstantUtil.IMGPATH);
			String randImgName = time +"."+ imgFormat;
			File target = new File(targetPath, randImgName);
			FileUtils.copyFile(file, target);// 前者是文件源，后者是文件复制的目标地址
			User user = this.userService.findUserByID(this.uid);
			image.setUrl(ConstantUtil.IMGPATH + "/" + randImgName);
			image.setPublish_time(new Date());
			image.setUser(user);
			this.imageService.addImage(image);
			//图片上传之后给实时推送一条信息提醒管理者,逻辑交给service层来做
			this.newMsgService.addNewMsg(user, image);
		}
		System.out.println(imageResult.getJson());
		writeJson2Resp(imageResult.getJson());

	}

}
