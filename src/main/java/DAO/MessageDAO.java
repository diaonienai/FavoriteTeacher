package DAO;

import bean.Page;
import entity.Message;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface MessageDAO {

    /**
     * 查询所有留言
     */
    List<Message> getAllMessages();

    /**
     * 查询特定导师的留言
     */
    List<Message> getMsgOfTeacher(int tId);

    /**
     * 分页查询所有导师留言
     */
    List<Message> getAllMsgByPage(Page page);

    int getNumOfAllMsg();

    /**
     * 分页查询特定导师留言
     */
    List<Message> getMsgOfOneByPage(@Param("tId") int tId, @Param("page") Page page);

    int getNumOfMsgOfOne(int tId);

    /**
     * 添加留言
     */
    int insertOne(Message message);

    /**
     * 根据学生id，导师id查询留言
     */
    Message getMsgByStuAndTeaId(@Param("tId") int tId, @Param("sId") String sId);

    /**
     * 测试接口，后期删除，删除所有的留言
     */
    int reset();
}
