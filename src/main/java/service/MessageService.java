package service;

import DAO.MessageDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import DTO.MessageDTO;
import DTO.MsgAddDTO;
import DTO.MsgOfOneDTO;
import bean.Page;
import entity.Message;
import entity.Student;
import entity.Teacher;
import enums.MsgAddEnum;
import exception.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageDAO messageDAO;

    @Resource
    private TeacherDAO teacherDAO;

    @Resource
    private StudentDAO studentDAO;

    /**
     * 查询所有留言
     */
    public MessageDTO getAllMsgByPage(int currentPage) {
        Page page = new Page();
        //若没有该参数, 从第一页开始显示
        if (currentPage == 0) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(currentPage);
        }
        int total = messageDAO.getNumOfAllMsg();
        page.setTotalNumber(total);
        page.count();
        return MessageDTO.convert(messageDAO.getAllMsgByPage(page), page);
    }

    /**
     * 查询特定导师的留言
     */
    public MsgOfOneDTO getMsgOfOneByPage(int tId, int currentPage) {
        Page page = new Page();
        //若没有该参数, 从第一页开始显示
        if (currentPage == 0) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(currentPage);
        }
        int total = messageDAO.getNumOfMsgOfOne(tId);
        page.setTotalNumber(total);
        page.count();
        return MsgOfOneDTO.convert(messageDAO.getMsgOfOneByPage(tId, page), page);


    }

    /**
     * 添加留言
     */
    public void insertOne(int tid, String sid, String msg, int anonymous) {
        Teacher teacher = teacherDAO.getTeacherById(tid);
        if (teacher == null) {
            throw new TeaNotFoundException("不存在该导师");
        }
        Student student = studentDAO.getStudentById(sid);
        if (student == null) {
            throw new StuNotFoundException("不存在该学生");
        }
        if (messageDAO.getMsgByStuAndTeaId(tid, sid) != null) {
            throw new MsgRepeatException("重复评论");
        }
        if (msg == null || msg.length() == 0 || msg.length() > 300) {
            throw new MsgLengthException("留言长度为0或者过长");
        }
        Message message = new Message();
        message.setTeacher(teacher);
        message.setStudent(student);
        message.setContent(msg);
        message.setAnonymous(anonymous == 1);
        if (messageDAO.insertOne(message) != 1) {
            throw new InsertException("插入异常");
        }
    }

    /**
     * 测试接口，后期删除
     */
    public boolean reset() {
        return messageDAO.reset() >= 0;
    }

}
