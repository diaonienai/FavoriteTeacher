package service;

import DAO.InstituteDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import bean.Page;
import entity.Institute;
import entity.Student;
import entity.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Resource
    private StudentDAO studentDAO;

    /**
     * 单条查询
     */
    public Student getStudentById(String id) {
        return studentDAO.getStudentById(id);
    }

    /**
     * 根据学号密码查询
     */
    public boolean checkIfExisted(String id, String password) {
        Student student = studentDAO.getStudentByIdAndPwd(id, password);
        return student != null;
    }

    /**
     * 查询所有学生
     */
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    /**
     * 设置学生投票状态
     */
    public boolean setVoted(String id, int status) {
        return studentDAO.setVoted(id, status) > 0;
    }

    /**
     * 测试接口，后期删除
     */
    public boolean reset() {
        return studentDAO.reset() >= 0;
    }



}
