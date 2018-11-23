package org.sopt.report5.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by bomi on 2018-11-23.
 */

public interface S3FileUploadService {
    String upload(MultipartFile uploadFile) throws IOException;
}
