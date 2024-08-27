package org.ember.demo.mapper;

import org.ember.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author eden
 * @since 2024-08-27
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
