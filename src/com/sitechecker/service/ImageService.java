package com.sitechecker.service;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.Image;
import com.sitechecker.service.result.ImageResult;

public interface ImageService {
	
	public void addImage(Image image);
	
	public Collection<Image> findAllImage();
	
	public Image findImgByIid(Serializable iid);
	
	public void deleteImageByIid(Serializable iid);
	
	public ImageResult validateImage(Image image, File file, String fileContentType);
	
}
