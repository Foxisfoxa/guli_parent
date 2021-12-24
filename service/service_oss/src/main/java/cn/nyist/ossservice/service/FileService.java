package cn.nyist.ossservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fox
 * @date 2021/12/24 22:46
 */
public interface FileService {
    String uploadFileOss(MultipartFile file);
}
