package cn.nyist.ossservice.service.impl;

import cn.nyist.baseservice.handler.GuliException;
import cn.nyist.ossservice.service.FileService;
import cn.nyist.ossservice.utils.ConstantPropertiesUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Fox
 * @date 2021/12/24 22:46
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFileOss(MultipartFile file) {
        String endpoint = ConstantPropertiesUtil.END_POINT;

        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;


        String fileNames = file.getOriginalFilename();
        String[] split = fileNames.split("\\.");

        String path = new DateTime().toString("yyyy/MM/dd");

        String fileName = UUID.randomUUID().toString()+"."+split[1];
        fileName = path + "/" + fileName;

        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName,fileName,inputStream);
            ossClient.shutdown();

            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            throw new GuliException(20001,"上传失败");
        }

    }
}
