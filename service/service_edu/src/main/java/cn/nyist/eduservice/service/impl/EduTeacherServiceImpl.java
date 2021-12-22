package cn.nyist.eduservice.service.impl;

import cn.nyist.eduservice.entity.EduTeacher;
import cn.nyist.eduservice.mapper.EduTeacherMapper;
import cn.nyist.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.PrimitiveIterator;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Fox
 * @since 2021-12-22
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

}
