package com.sitechecker.service;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.Images;

public interface ImageService {
	
	public void addImage(Images image);
	
	public Collection<Images> findAllImage();
	
	public Images findImgByIid(Serializable iid);
	
	public void deleteImageByIid(Serializable iid);
	
}
