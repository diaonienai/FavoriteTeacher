package controller.front;

import DTO.Result;
import DTO.TeacherDetailDTO;
import DTO.TeacherListDTO;
import DTO.TeacherVoteDTO;
import entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeacherService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * 返回所有导师信息
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<List<TeacherListDTO>> list() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        Result<List<TeacherListDTO>> result = new Result<List<TeacherListDTO>>(200, "成功获取导师列表");
        result.setData(TeacherListDTO.convertTeacher(teachers));
        return result;
    }

    /**
     * 返回所有导师投票情况
     */
    @RequestMapping(value = "/voteInfo", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<List<TeacherVoteDTO>> teacherVote() {
        Result<List<TeacherVoteDTO>> result = new Result<List<TeacherVoteDTO>>(710, "成功获取所有导师投票信息");
        result.setData(TeacherVoteDTO.convert(teacherService.getAllTeachers()));
        return result;
    }


    /**
     * 根据id返回某个导师的详细信息
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<TeacherDetailDTO> detail(int id) {
        Teacher teacher = teacherService.getTeacherById(id);
        System.out.println(teacher.toString());
        return new Result<TeacherDetailDTO>(210, "成功获取导师详细信息",
                TeacherDetailDTO.convertTeacher(teacher));
    }

}
