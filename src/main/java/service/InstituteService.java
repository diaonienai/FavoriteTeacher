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

}
