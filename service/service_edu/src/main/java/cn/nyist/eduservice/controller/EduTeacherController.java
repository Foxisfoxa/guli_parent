package cn.nyist.eduservice.controller;


import cn.nyist.commonutils.Result;
import cn.nyist.eduservice.entity.EduTeacher;
import cn.nyist.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Fox
 * @since 2021-12-22
 */
@Api(description = "教师管理")
@RestController
@RequestMapping("/eduservice/eduteacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "获取所有教师信息")
    @GetMapping
    public Result getAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("list",list);
    }

    @ApiOperation(value = "根据ID删除教师")
    @DeleteMapping("{id}")
    public Result delTeacher(@PathVariable String id){
        boolean remove = eduTeacherService.removeById(id);
        if (remove){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


}

