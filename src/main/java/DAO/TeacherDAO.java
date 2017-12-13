package DAO;

import bean.Page;
import entity.Teacher;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface TeacherDAO {
    /**
     * 获取所有导师基本信息，不包括导师简介，推荐语，点评
     */
    List<Teacher> getAllTeachers();

    /**
     * 获取所有导师基本信息，包括导师简介，推荐语，点评
     */
    List<Teacher> getTeachersWithAllInfos();

    /**
     * 获取所有导师的总数
     */
    int getNumberOfTeachers();

    /**
     * 分页查询导师
     */
    List<Teacher> getTeachersByPage(Page page);

    /**
     * 批量删除
     */
    int deleteBatch(int[] ids);

    /**
     * 单条插入
     */
    int insertOne(Teacher teacher);

}
