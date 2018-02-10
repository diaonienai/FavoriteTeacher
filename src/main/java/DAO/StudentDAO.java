package DAO;

import entity.Student;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface StudentDAO {

    /**
     * 单条查询
     */
    Student getStudentById(String id);

    /**
     * 根据学号，密码查询
     */
    Student getStudentByIdAndPwd(@Param("id") String id, @Param("password") String password);

    /**
     * 查询所有学生
     */
    List<Student> getAllStudents();

    /**
     * 设置某个学生的投票状态
     */
    int setVoted(@Param("id") String id, @Param("status") int status);

    /**
     * 测试接口，后期删除，重置学生的投票状态
     */
    int reset();

}
