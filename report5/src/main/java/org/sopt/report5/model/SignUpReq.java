package org.sopt.report5.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by bomi on 2018-11-23.
 */

@Data
public class SignUpReq {
    private String name;
    private String part;
    private String profileUrl;
    private MultipartFile profile;
}
