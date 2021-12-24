package cn.nyist.ossservice.service.impl;

import cn.nyist.ossservice.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fox
 * @date 2021/12/24 22:46
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFileOss(MultipartFile file) {
        return null;
    }
}
