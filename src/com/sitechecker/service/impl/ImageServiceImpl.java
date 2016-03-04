package com.sitechecker.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.ImagesDao;
import com.sitechecker.domain.Images;
import com.sitechecker.service.ImageService;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	@Resource(name="imagesDao")
	private ImagesDao<Images> imageDao;

	@Transactional(readOnly = false)
	@Override
	public void addImage(Images image) {
		// TODO Auto-generated method stub
		this.imageDao.saveEntry(image);
	}

	@Override
	public Collection<Images> findAllImage() {
		// TODO Auto-generated method stub
		return this.imageDao.getAllEntry();
	}

	@Override
	public Images findImgByIid(Serializable iid) {
		return this.imageDao.getEntryByID(iid);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteImageByIid(Serializable iid) {
		this.imageDao.deleteEntry(iid);
	}

	
	
}
