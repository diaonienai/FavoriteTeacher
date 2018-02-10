package DAO;

import entity.Institute;
import entity.Votes;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface VotesDAO {

    /**
     * 单条插入
     */
    int insertOne(Votes votes);

    /**
     * 批量插入
     */
    int insertBatch(List<Votes> votes);

    /**
     * 测试接口，后期删除，删除所有投票
     */
    int reset();

}
