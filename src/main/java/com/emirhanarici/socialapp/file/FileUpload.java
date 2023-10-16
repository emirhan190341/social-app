package com.emirhanarici.socialapp.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUpload {

//    String uploadFile(MultipartFile multipartFile) throws IOException;
    public Map uploadFile(MultipartFile multipartFile);
}
