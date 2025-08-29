package com.scm.scm2.services.impl;

import java.io.IOException;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.scm.scm2.helpers.AppConstants;
import com.scm.scm2.services.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    private final Cloudinary cloudinary;

    public ImageServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile contactImage, String filename) {
        try {
            byte[] data = contactImage.getBytes(); // simpler than manual read
            cloudinary.uploader().upload(data, ObjectUtils.asMap(
                    "public_id", filename));

            return this.getUrlFromPublicId(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getUrlFromPublicId(String publicId) {
        return cloudinary
                .url()
                .transformation(
                        new Transformation<>()
                                .width(AppConstants.CONTACT_IMAGE_WIDTH)
                                .height(AppConstants.CONTACT_IMAGE_HEIGHT)
                                .crop(AppConstants.CONTACT_IMAGE_CROP))
                .generate(publicId);
    }
}
