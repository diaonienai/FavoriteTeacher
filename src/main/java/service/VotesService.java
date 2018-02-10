package service;

import DAO.StudentDAO;
import DAO.VotesDAO;
import DTO.VoteDTO;
import entity.Student;
import entity.Teacher;
import entity.Votes;
import enums.VoteEnum;
import exception.InsertException;
import exception.StuNotFoundException;
import exception.UpdateException;
import exception.VoteTwiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VotesService {

    @Resource
    private VotesDAO votesDAO;

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    /**
     * 投票
     */
    public void vote(int[] tIds, String sId) {
        Student student = studentService.getStudentById(sId);
        if (student == null) {
            throw new StuNotFoundException("找不到该学生");
        }
        if (student.isVoted()) {
            throw new VoteTwiceException("该学生已经投过票");
        }
        List<Votes> votes = new ArrayList<Votes>();
        List<Teacher> teachers = teacherService.getTeachersByIds(tIds);
        Votes vote;
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
            vote = new Votes(teacher, student);
            votes.add(vote);
        }
        int insertRow = votesDAO.insertBatch(votes);
        if (insertRow != tIds.length) {
            throw new InsertException("插入异常");
        }
        if (!studentService.setVoted(sId, 1)) {
            throw new UpdateException("更新学生投票票状态出错");
        }
    }

    /**
     * 测试接口，后期删除
     */
    public boolean reset() {
        return votesDAO.reset() >= 0;
    }
}
