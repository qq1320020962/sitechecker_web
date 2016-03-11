package com.sitechecker.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.ImagesDao;
import com.sitechecker.domain.Image;
import com.sitechecker.service.ImageService;
import com.sitechecker.service.result.ImageResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.ValidateUtil;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

	@Resource(name = "imagesDao")
	private ImagesDao<Image> imageDao;

	@Transactional(readOnly = false)
	@Override
	public void addImage(Image image) {
		this.imageDao.saveEntry(image);
	}

	@Override
	public Collection<Image> findAllImage() {
		return this.imageDao.getAllEntry();
	}

	@Override
	public Image findImgByIid(Serializable iid) {
		return this.imageDao.getEntryByID(iid);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteImageByIid(Serializable iid) {
		this.imageDao.deleteEntry(iid);
	}

	@Override
	public ImageResult validateImage(Image image, File file,
			String fileContentType) {
		ImageResult imageResult = new ImageResult();
		if (file == null) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_FILE_EMPTY);
		} else if (ValidateUtil.isEmpty(image.getImg_name())) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_NAME_EMPTY);
		} else if (!ValidateUtil.checkImgFormat(fileContentType)) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_FORMAT_ERROR);
		} else if (image.getInspect() == null) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_INSPECT_NULL);
		} else if (image.getLongitude() == null) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_LONGITUDE_NULL);
		} else if (image.getLatitude() == null) {
			imageResult.setResult(RESULT.ERROR);
			imageResult.setJson(ConstantUtil.IMG_LATITUDE_NULL);
		} else {
			imageResult.setResult(RESULT.SUCCESS);
			imageResult.setJson(ConstantUtil.IMG_VALIDATE_SUCC);
		}
		return imageResult;
	}
}
