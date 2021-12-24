package cn.nyist.ossservice.controller;

import cn.nyist.commonutils.Result;
import cn.nyist.ossservice.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fox
 * @date 2021/12/24 22:44
 */
@Api(description = "文件管理")
@RestController
@RequestMapping("/ossservice/fileoss")
@CrossOrigin
public class FileController {
    @Autowired
    private FileService fileService;

    @ApiOperation(value = "上传文件")
    @PostMapping
    public Result uploadFile(MultipartFile file){
        String url = fileService.uploadFileOss(file);
        return Result.ok().data("url",url);
    }
}
