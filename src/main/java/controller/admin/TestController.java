package controller.admin;

import DAO.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private VotesService votesService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    @Resource
    private InstituteService instituteService;

    @Resource
    private MessageService messageService;

    /**
     * 重置导师和学院的投票数为0，清除学生投票状态
     */
    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    @ResponseBody
    public String reset() {
        return votesService.reset() &&
                teacherService.reset() &&
                studentService.reset() &&
                instituteService.reset() ? "success" : "false";
    }

}
