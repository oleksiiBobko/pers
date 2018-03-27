package org.op.pers.web.api.misc;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadModel {

    private String extraField;

    private MultipartFile[] files;

}
