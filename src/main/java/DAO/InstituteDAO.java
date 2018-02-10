package DAO;

import entity.Institute;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface InstituteDAO {

    /**
     * 单条插入，若已存在则不插入
     */
    int insertOne(Institute institute);

    /**
     * 条件查询
     */
    Institute queryByName(String name);

    /**
     * 查询全部
     */
    List<Institute> getAllInstitute();

    /**
     * 测试接口，后期删除，重置学院的投票
     */
    int reset();

}
