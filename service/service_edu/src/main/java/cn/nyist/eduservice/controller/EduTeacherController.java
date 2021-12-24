package cn.nyist.eduservice.controller;


import cn.nyist.commonutils.Result;
import cn.nyist.eduservice.entity.EduTeacher;
import cn.nyist.eduservice.entity.vo.TeacherQuery;
import cn.nyist.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "不带条件的分页查询讲师列表")
    @GetMapping("getTeacherNoneCondition/{current}/{limit}")
    public Result getTeacherNoneCondition(@PathVariable Long current,@PathVariable Long limit){
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page, null);
        List<EduTeacher> records = page.getRecords();
        Long total = page.getTotal();
        return Result.ok().data("total",total).data("records",records);
    }

    @ApiOperation(value = "带条件的查询教师")
    @PostMapping("getTeacherForCondition/{current}/{limit}")
    public Result getTeacherForCondition(@PathVariable Long current, @PathVariable Long limit, @RequestBody TeacherQuery teacherQuery){
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page,wrapper);
        Long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();
        return Result.ok().data("total",total).data("records",records);
    }


    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("getTeacherById/{id}")
    public Result getTeacherById(@PathVariable Integer id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return Result.ok().data("getTeacherById",eduTeacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean update = eduTeacherService.updateById(eduTeacher);

        if (update){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

}

