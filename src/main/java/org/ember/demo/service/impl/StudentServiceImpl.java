package org.ember.demo.service.impl;

import org.ember.demo.entity.Student;
import org.ember.demo.mapper.StudentMapper;
import org.ember.demo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author eden
 * @since 2024-08-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
