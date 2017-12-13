package service;

import DAO.InstituteDAO;
import DAO.TeacherDAO;
import bean.Page;
import entity.Institute;
import entity.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {

    @Resource
    private TeacherDAO teacherDAO;

    @Resource
    private InstituteDAO instituteDAO;

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    public List<Teacher> getTeachersWithAllInfos() {
        return teacherDAO.getTeachersWithAllInfos();
    }

    /**
     * 分页查询导师列表
     */
    public List<Teacher> getTeachersByPage(Page page) {
        int totalNumber = teacherDAO.getNumberOfTeachers();
        page.setTotalNumber(totalNumber);
        page.count();
        return teacherDAO.getTeachersByPage(page);
    }

    /**
     * 批量删除
     */
    public int deleteBatch(int[] ids) {
        return teacherDAO.deleteBatch(ids);
    }

    /**
     * 单条插入
     */
    public int insertOne(Teacher teacher, Institute institute) {
        Institute ins = instituteDAO.queryByName(institute.getInsName());
        if (ins == null) {
            //该学院不存在，先插入学院，再插入导师
            ins = institute;
            instituteDAO.insertOne(ins);
        }
        teacher.setInstitute(ins);
        return teacherDAO.insertOne(teacher);
    }

}
