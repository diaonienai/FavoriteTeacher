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
public class InstituteService {

    @Resource
    private InstituteDAO instituteDAO;

    /**
     * 单条插入，若已存在则不插入
     */
    public int insertOne(Institute institute) {
        return instituteDAO.insertOne(institute);
    }

    /**
     * 查询全部
     */
    public List<Institute> getAllInstitute() {
        return instituteDAO.getAllInstitute();
    }

    /**
     * 测试接口，后期删除
     */
    public boolean reset() {
        return instituteDAO.reset() >= 0;
    }

}
