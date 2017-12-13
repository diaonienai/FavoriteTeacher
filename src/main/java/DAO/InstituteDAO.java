package DAO;

import entity.Institute;
import org.mybatis.spring.annotation.MapperScan;


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

}
